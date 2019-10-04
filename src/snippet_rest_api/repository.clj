(ns snippet-rest-api.repository
  (:require [next.jdbc :as jdbc]
            [next.jdbc.result-set :as rs]))

(defn snippets [ds]
  (jdbc/execute! ds ["select * from snippet"] {:builder-fn rs/as-unqualified-maps}))

(defn snippet [ds id]
  (jdbc/execute-one! ds ["select * from snippet where id = ?" id] {:builder-fn rs/as-unqualified-maps}))

(defn create-snippet [ds snippet]
  (let [{:keys [title content file_name]} snippet]
    (jdbc/execute-one! ds ["insert into snippet (title, content, file_name) VALUES (?, ?, ?)" title content file_name]
                       {:return-keys true
                        :builder-fn  rs/as-unqualified-maps}
                       )
    )
  )