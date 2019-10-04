(ns snippet-rest-api.core
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [next.jdbc :as jdbc]
            [snippet-rest-api.db :as db-config]
            [snippet-rest-api.repository :as repository]
            [schema.core :as s]))

(def db-connection (jdbc/get-datasource db-config/db-spec))

(def app
  (api
    (GET "/snippets" []
      (ok (repository/snippets db-connection)))
    (GET "/snippets/:id" []
      :path-params [id :- s/Int]
      (ok (repository/snippet db-connection id))
      )))