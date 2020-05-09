(ns quil-workflow.core
  (:require [quil.core :as q]
            [quil-workflow.dynamic :as dynamic]
            [quil.middleware :as m]))


(q/defsketch example
  :title "Color spectrum in a circle"
  :setup dynamic/setup
  :draw dynamic/draw-state
  :update dynamic/update-state
  :size [1000 1000]
  :features [:keep-on-top]
  :middleware [m/fun-mode])
