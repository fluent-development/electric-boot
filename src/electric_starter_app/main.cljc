(ns electric-starter-app.main
  (:require
    [hyperfiddle.electric :as e]
    [hyperfiddle.electric-dom2 :as dom]
    [electric-starter-app.boot :as boot]))


(e/def Greeting)


;; ## "Middleware"
(e/defn A
  [Next]
  (e/server
    (boot/continue Next)))

(e/defn B
  [Next]
  (e/server
    (boot/continue Next)))

(e/defn C
  [Next]
  (e/client
    (binding [Greeting "world"]
      (boot/continue Next))))

(e/defn D
  [Next]
  (e/server
    (boot/continue Next)))

(e/defn E
  [Next]
  (e/server
    (boot/continue Next)))

(e/defn F
  [Next]
  (e/server
    (boot/continue Next)))

(e/defn G
  [Next]
  (e/server
    (boot/continue Next)))

(e/defn H
  [Next]
  (e/server
    (boot/continue Next)))

(e/defn I
  [Next]
  (e/server
    (boot/continue Next)))

(e/defn J
  [Next]
  (e/server
    (boot/continue Next)))

(e/defn K
  [Next]
  (e/server
    (boot/continue Next)))

(e/defn L
  [Next]
  (e/server
    (boot/continue Next)))

(e/defn M
  [Next]
  (e/server
    (boot/continue Next)))


;; ## App
(e/defn App
  []
  (e/client
    (dom/div (dom/text (str "Hello " Greeting)))))


;; ## Boot
(e/defn Main
  [ring-request]
  (e/client
    (binding [dom/node js/document.body]
      (boot/boot App
        ;; A bunch of "ring"-like reactive functions, playing the role of middleware.
        ;; The primary purpose being looser coupling, as opposed to a chain of functions
        ;; explicitly calling one another.
        A B C D E
        F E F G H
        I J K L M))))
