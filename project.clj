(defproject snippet-rest-api "0.1.0-SNAPSHOT"
  :description "Snippet REST API"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [metosin/compojure-api "2.0.0-alpha30"]
                 [ragtime "0.8.0"]
                 [seancorfield/next.jdbc "1.0.8"]
                 [org.postgresql/postgresql "42.2.8"]]
  :ring {:handler snippet-rest-api.core/app}
  :uberjar-name "snippet-rest-api.jar"
  :aliases {"migrate"  ["run" "-m" "snippet-rest-api.db/migrate"]
            "rollback" ["run" "-m" "snippet-rest-api.db/rollback"]}
  :profiles {:dev {:plugins [[lein-ring "0.12.5"]]}})
