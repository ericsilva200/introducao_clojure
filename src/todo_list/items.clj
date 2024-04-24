(ns todo-list.items)

(defn create-item [id description]
  {:item/id           id
   :item/description  description
   :item/done?        false})

(defn done-item [item]
  (assoc item :item/done? true))

(defn undone-item [item]
  (assoc item :item/done? false))

