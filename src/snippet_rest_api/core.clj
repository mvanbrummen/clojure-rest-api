(ns snippet-rest-api.core
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]))

(def app
  (api
   (GET "/test" []
     (ok {:message "Hi"}))))