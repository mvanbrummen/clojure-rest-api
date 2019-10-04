(ns snippet-rest-api.db
  (:require [ragtime.jdbc :as jdbc]
            [ragtime.repl :as repl]))

(def db-spec {:subprotocol "postgresql"
              :subname "//localhost:5432/postgres"
              :user "postgres"
              :password "password"})

(def config
  {:datastore (jdbc/sql-database db-spec)
   :migrations (jdbc/load-resources "migrations")})

(defn migrate []
  (repl/migrate config))

(defn rollback []
  (repl/rollback config))