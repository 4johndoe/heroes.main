(ns ^:figwheel-hooks heroes.main
  (:require
   [goog.dom :as gdom]
   [rum.core :as rum]))

(defn multiply [a b] (* a b))

(defonce app-state (atom {:text "Hello world!"}))

(rum/defc app < rum/reactive []
  [:div
   (:text (rum/react app-state))])

(defn ^:after-load on-reload []
  (rum/mount (app) (gdom/getElement "mount")))

(defn ^:export on-load []
  (on-reload))