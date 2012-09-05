(ns zebra-puzzle.test.core
  (:use [zebra-puzzle.core])
  (:use [clojure.test]))

(deftest immediate-right-test
  (is (true? (immediate-right? 2 1)))
  (is (false? (immediate-right? 1 1)))
  (is (false? (immediate-right? 1 2))))

(deftest next-to-test
  (is (true? (next-to? 1 2)))
  (is (true? (next-to? 2 1)))
  (is (false? (next-to? 1 3))))

(run-tests)
