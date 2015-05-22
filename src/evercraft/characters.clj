(ns evercraft.characters)

(defrecord GameCharacter [name alignment ac hp])

(defn set-alignment [alignment]
   (or (alignment #{:good :evil :neutral} :neutral)))

(defn new-char [attrs]
  (let [defaults {:ac 10 :hp 5}
        alignment (set-alignment (get attrs :alignment, :invalid))]
    (map->GameCharacter (merge defaults attrs {:alignment alignment}))))
