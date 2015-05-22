(ns evercraft.die-test
  (:require [clojure.test :refer :all])
  (:use     [evercraft.die :refer :all]))

(deftest roll-test
  (testing "Rolling the die"
    (let [number (roll)]
      (is (integer? number))
      (is (<= number 20))
      (is (>= number 0)))))

