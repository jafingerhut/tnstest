# tnstest

A Clojure library designed to ... well, that part is up to you.

## Usage

The following results were obtained with Clojure 1.7.0, and both
versions 0.2.11 and 0.3.0-alpha2 of tools.namespace.

```clojure
% lein repl

;; require tnstest.tns1.  Because this is being run from Clojure/Java,
;; it will find and load file src/tnstest/tns1.clj, and ignore file
;; src/tnstest/tns1.cljc.  The latter file would be used if being
;; compiled from ClojureScript.

user=> (require '[tnstest.tns1 :as tns1])
nil

;; Verify that the .clj version was loaded.  If the .cljc version was
;; loaded, it should return the string "4" instead.

user=> (tns1/tns1-func 3)
2

;; Now use tools.namespace's scan-all to get file and dependency info
;; about the project.  Note in the tracker t pretty-printed below that
;; tnstest.tns1 depends on tnstest.tns2 and tnstest.tns3, which only
;; appear as dependencies in the .cljc file src/tnstest/tns1.cljc

;; It would be better if one could specify whether dependencies should
;; be calculated correctly for Clojure/Java or ClojureScript, perhaps
;; selected by the caller.

user=> (use 'clojure.pprint)
nil
user=> (require '[clojure.tools.namespace.dir :as d])
nil
user=> (def t (d/scan-all nil))
#'user/t
user=> (pprint t)
{:clojure.tools.namespace.dir/files
 #{#object[java.io.File 0x5a8e261b "/Users/jafinger/clj/eastwood/tnstest/src/tnstest/tns1.clj"]
   #object[java.io.File 0x1d305c92 "/Users/jafinger/clj/eastwood/tnstest/src/tnstest/tns4.clj"]
   #object[java.io.File 0x520d8436 "/Users/jafinger/clj/eastwood/tnstest/src/tnstest/tns3.cljc"]
   #object[java.io.File 0x75631f4f "/Users/jafinger/clj/eastwood/tnstest/src/tnstest/tns1.cljc"]
   #object[java.io.File 0x3e9cb7be "/Users/jafinger/clj/eastwood/tnstest/src/tnstest/tns2.cljc"]},
 :clojure.tools.namespace.track/deps
 {:dependencies {tnstest.tns1 #{tnstest.tns2 tnstest.tns3}},
  :dependents
  {tnstest.tns2 #{tnstest.tns1}, tnstest.tns3 #{tnstest.tns1}}},
 :clojure.tools.namespace.track/unload
 (tnstest.tns4 tnstest.tns1 tnstest.tns2 tnstest.tns3),
 :clojure.tools.namespace.track/load
 (tnstest.tns3 tnstest.tns2 tnstest.tns1 tnstest.tns4),
 :clojure.tools.namespace.file/filemap
 {#object[java.io.File 0x5a8e261b "/Users/jafinger/clj/eastwood/tnstest/src/tnstest/tns1.clj"]
  tnstest.tns1,
  #object[java.io.File 0x75631f4f "/Users/jafinger/clj/eastwood/tnstest/src/tnstest/tns1.cljc"]
  tnstest.tns1,
  #object[java.io.File 0x3e9cb7be "/Users/jafinger/clj/eastwood/tnstest/src/tnstest/tns2.cljc"]
  tnstest.tns2,
  #object[java.io.File 0x520d8436 "/Users/jafinger/clj/eastwood/tnstest/src/tnstest/tns3.cljc"]
  tnstest.tns3,
  #object[java.io.File 0x1d305c92 "/Users/jafinger/clj/eastwood/tnstest/src/tnstest/tns4.clj"]
  tnstest.tns4},
 :clojure.tools.namespace.dir/time 1451509903007}
nil

```

## License

Copyright © 2015 Andy Fingerhut

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
