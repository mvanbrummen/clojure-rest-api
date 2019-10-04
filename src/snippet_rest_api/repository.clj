(ns snippet-rest-api.repository
  (:require [next.jdbc :as jdbc]
            [next.jdbc.result-set :as rs]))

(defn snippets [db-connection]
  (jdbc/execute! db-connection ["select * from snippet"] {:builder-fn rs/as-unqualified-maps}))

(defn snippet [db-connection id]
  (jdbc/execute-one! db-connection ["select * from snippet where id = ?" id] {:builder-fn rs/as-unqualified-maps}))