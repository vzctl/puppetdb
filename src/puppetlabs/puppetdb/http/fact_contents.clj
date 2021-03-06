(ns puppetlabs.puppetdb.http.fact-contents
  (:require [puppetlabs.puppetdb.http.query :as http-q]
            [puppetlabs.puppetdb.query.paging :as paging]
            [net.cgrand.moustache :refer [app]]
            [puppetlabs.puppetdb.middleware :refer [wrap-with-paging-options]]))

(defn routes
  [version]
  (let [param-spec {:optional paging/query-params}]
    (app
      []
      (http-q/query-route-from "fact_contents" version param-spec
                               [http-q/restrict-query-to-active-nodes]))))

(defn fact-contents-app
  [version]
  (-> (routes version)
      wrap-with-paging-options))
