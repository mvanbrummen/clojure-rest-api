(defproject snippet-rest-api "0.1.0-SNAPSHOT"
  :description "Snippet REST API"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [metosin/compojure-api "2.0.0-alpha30"]]
  :ring {:handler snippet-rest-api.core/app}
  :uberjar-name "snippet-rest-api.jar"
  :profiles {:dev {:plugins [[lein-ring "0.12.5"]]}})
