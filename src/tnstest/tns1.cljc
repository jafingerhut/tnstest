(ns tnstest.tns1
  (:require [tnstest.tns2 :as t2]
            [tnstest.tns3 :as t3]))


(defn tns1-func [x]
  (t3/tns3-func (t2/tns2-func x)))
