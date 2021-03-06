(ns darkexchange.view.offer.view
  (:require [darkexchange.model.terms :as terms]
            [darkexchange.view.utils :as view-utils]
            [seesaw.core :as seesaw-core]))

(defn create-label-value-pair-panel [text label-key]
  (seesaw-core/horizontal-panel
      :items [ (seesaw-core/border-panel :size [100 :by 15] :east (seesaw-core/label :text text))
               [:fill-h 3]
               (seesaw-core/border-panel :size [200 :by 15]
                 :west (seesaw-core/label :id label-key :text "data" :font { :style :plain }))]))

(defn create-public-key-panel []
  (create-label-value-pair-panel (terms/public-key) :public-key-label))

(defn create-name-panel []
  (create-label-value-pair-panel (terms/name) :name-label))

(defn create-wants-panel []
  (create-label-value-pair-panel (terms/wants) :wants-label))

(defn create-to-receive-by-panel []
  (create-label-value-pair-panel (terms/to-receive-by) :to-receive-by-label))

(defn create-has-panel []
  (create-label-value-pair-panel (terms/has) :has-label))

(defn create-to-send-by-panel []
  (create-label-value-pair-panel (terms/to-send-by) :to-send-by-label))

(defn create-center-panel []
  (seesaw-core/vertical-panel
      :items [ (create-public-key-panel)
               [:fill-v 3]
               (create-name-panel)
               [:fill-v 3]
               (create-wants-panel)
               [:fill-v 3]
               (create-to-receive-by-panel)
               [:fill-v 3]
               (create-has-panel)
               [:fill-v 3]
               (create-to-send-by-panel)]))

(defn create-button-panel []
  (seesaw-core/border-panel
      :border 5
      :hgap 5
      :east (seesaw-core/horizontal-panel :items 
              [ (seesaw-core/button :id :accept-offer-button :text (terms/accept-offer))
                [:fill-h 3]
                (seesaw-core/button :id :cancel-button :text (terms/cancel)) ])))

(defn create-content []
  (seesaw-core/border-panel
      :border 5
      :vgap 5
      :center (create-center-panel)
      :south (create-button-panel)))

(defn create [main-frame]
  (view-utils/center-window-on main-frame
    (seesaw-core/frame
      :title (terms/offer-view)
      :content (create-content)
      :on-close :dispose
      :visible? false)))