(ns todo-mvc.db
  (:require [clojure.spec :as s]))

;; spec of app-db
(s/def ::id #(satisfies? cljs.core/IUUID %))
(s/def ::desc string?)
(s/def ::done? boolean?)

(s/def ::todo
  (s/keys :req-un [::desc ::done?]))

(s/def ::todos (s/map-of ::id ::todo :min-count 0))

(s/def ::app-db
  (s/keys :req-un [::todos]))

;; initial state of app-db
(def app-db {:todos {}})