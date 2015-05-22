(ns evercraft.character-test
  (:require [clojure.test :refer :all])
  (:use     [evercraft.characters :refer :all]))

(deftest new-char-test
  (testing "Constructing a character"
    (let [bob (new-char {:name "Bob"})]
      (is (= "Bob" (:name bob))))))

(deftest defaults-test
  (testing "Default ac and hp"
    (let [bob (new-char {:name "Bob"})]
      (is (= "Bob" (:name bob)))
      (is (= 10 (:ac bob)))
      (is (= 5 (:hp bob)))))

  (testing "ac and hp can be set"
    (let [bob (new-char {:name "Bob" :ac 20 :hp 30})]
      (is (= 20 (:ac bob)))
      (is (= 30 (:hp bob)))))
)

(deftest alignment-tests
  (testing "alignment defaults to :neutral"
    (let [bob (new-char {:name "Bob"})]
      (is (= :neutral (:alignment bob)))))

  (testing "alignment defaults to :neutral when not valid"
    (let [bob (new-char {:name "Bob" :alignment :invalid})]
      (is (= :neutral (:alignment bob)))))

  (testing "alignment allows you to set it to a valid value"
    (let [bob (new-char {:name "Bob" :alignment :good})]
      (is (= :good (:alignment bob)))))
    (let [bob (new-char {:name "Bob" :alignment :evil})]
      (is (= :evil (:alignment bob))))
)


