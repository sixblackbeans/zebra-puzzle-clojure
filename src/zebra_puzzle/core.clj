;1 There are five houses.
;2 The Englishman lives in the red house.
;3 The Spaniard owns the dog.
;4 Coffee is drunk in the green house.
;5 The Ukrainian drinks tea.
;6 The green house is immediately to the right of the ivory house.
;7 The Old Gold smoker owns snails.
;8 Kools are smoked in the yellow house.
;9 Milk is drunk in the middle house.
;10 The Norwegian lives in the first house.
;11 The man who smokes Chesterfields lives in the house next to the man with the fox.
;12 Kools are smoked in a house next to the house where the horse is kept.
;13 The Lucky Strike smoker drinks orange juice.
;14 The Japanese smokes Parliaments.
;15 The Norwegian lives next to the blue house.
; Who drinks the water? Who owns the zebra?

(ns zebra-puzzle.core
  (:use [clojure.math.combinatorics :only [permutations]]
        [clojure.math.numeric-tower :only [abs]]))

(def houses [1 2 3 4 5])
(def middle-house 3)
(def first-house 1)
(def orderings (permutations houses))

(defn immediate-right? [h1, h2]
  "Checks if h1 is immediately right of h2"
  (= 1 (- h1 h2)))

(defn next-to? [h1, h2]
  "Checks if h1 and h2 are next to each other"
  (= 1 (abs (- h1 h2))))

(for [[red, green, ivory, yellow, blue]                        orderings
        :when (immediate-right? green ivory)
      [englishman, spaniard, ukrainian, japanese, norwegian]    orderings
        :when (= englishman red)
        :when (= norwegian first-house)
        :when (next-to? norwegian blue)
      [dog, snails, fox, horse, zebra]                         orderings
        :when (= spaniard dog)
      [coffee, tea, milk, oj, water]                           orderings
        :when (= coffee green)
        :when (= ukrainian tea)
        :when (= milk middle-house)
      [oldgold, kools, chesterfields, luckystrike, parliaments] orderings
        :when (= oldgold snails)
        :when (= kools yellow)
        :when (next-to? chesterfields fox)
        :when (next-to? kools horse)
        :when (= luckystrike oj)
        :when (= japanese parliaments)]
  [water zebra])

