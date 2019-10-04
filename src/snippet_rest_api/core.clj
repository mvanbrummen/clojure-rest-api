(ns snippet-rest-api.core
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [next.jdbc :as jdbc]
            [snippet-rest-api.db :as db-config]
            [snippet-rest-api.repository :as repository]
            [schema.core :as s]))

(s/defschema Snippet
  {
   :id          s/Int
   :title       s/Str
   :content     s/Str
   :file_name   s/Str
   :create_date s/Str
   }
  )

(def db-connection (jdbc/get-datasource db-config/db-spec))

(def app
  (api
    :swagger
    {
     :ui   "/"
     :spec "/swagger.json"
     :data {
            :info     {
                       :title       "Snippet API"
                       :description "API for code snippets"
                       }
            :tags     [{:name "api" :description "some apis"}]
            :produces ["application/json"]
            :consumes ["application/json"]
            }
     }

    (GET "/snippets" []
      :summary "Returns all snippets"
      (ok (repository/snippets db-connection)))

    (GET "/snippets/:id" []
      :summary "Returns a snippet for an ID"
      :path-params [id :- s/Int]
      (ok (repository/snippet db-connection id))
      )))