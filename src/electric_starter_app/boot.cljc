(ns electric-starter-app.boot
  (:require
    [hyperfiddle.electric :as e]))


(defmacro boot
  "Executes the reactive arity-0 function `EntryPoint` by running
   each of the reactive functions `Fs` first.

   Each function in `Fs` gets a single argument `Next`, which is
   the rest of the stack of functions in the chain to run. As such, each function
   in the chain should call `(continue Next)`, or the boot process will stop."
  [EntryPoint & [F & Fs]]
  (let [Next (conj (vec Fs) EntryPoint)]
    `(e/server (new ~F ~Next))))


(defmacro continue
  "Used with `boot`, see docstring."
  [Next]
  `(e/server
     (if-some [Next# (next ~Next)]
       (new (first ~Next) (vec Next#))
       (new (first ~Next)))))