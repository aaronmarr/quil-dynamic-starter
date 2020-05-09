(ns sketch.core
  (:require [quil.core :as q]
            [sketch.dynamic :as dynamic]
            [quil.middleware :as m]))


(q/defsketch example
  :title "Color spectrum in a circle"
  :setup dynamic/setup
  :draw dynamic/draw-state
  :update dynamic/update-state
  :size [1000 1000]
  :features [:keep-on-top]
  :middleware [m/fun-mode])


(defn refresh []
  (use :reload 'sketch.dynamic)
  (.loop example))
