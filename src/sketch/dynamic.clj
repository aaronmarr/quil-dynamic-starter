(ns sketch.dynamic
  (:require [quil.core :refer :all]
            [quil.middleware :as m]))


(defn setup []
  {:segment-count 24})


(defn update-state [state]
  {:segment-count
   ((key-as-keyword) {:1 360, :2 45 :3 24 :4 12 :5 6} 24)})


(defn draw-state [state]
  (def radius (/ (or (width) 0) 2))

  (color-mode :hsb 360 radius radius)
  (background 360)

  (begin-shape :triangle-fan)
  (vertex radius radius)

  (def step (/ 360 (:segment-count state)))

  (doseq [angle (into [] (range 0 (+ 360 1) step))]
    (vertex
     (+ (* (cos (radians angle)) radius) radius)
     (+ (* (sin (radians angle)) radius) radius))

    (fill angle (+ (mouse-x) 2) (+ (mouse-y) 2)))

  (end-shape))
