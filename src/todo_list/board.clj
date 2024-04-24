(ns todo-list.board
  (:require
    [todo-list.items]))

(defn create [name item]
  {:board/name  name
   :board/items item})

(defn add-items-from-board
  [{:board/keys [name items]} item]
  "Cria uma outra list com o mesmo nome da lista que
   foi passada como argumento só que adicionando o item novo"
  (create name (conj items item)))

(defn remove-item-from-board
  [{:board/keys [name items]}
   {:item/keys [id]}]
  "Cria uma nova lista com o mesmo nome da atual excluindo
  o item que queremos remover"
  (create name (remove #(= (id %) id) items)))

(defn mark-item-as-done [board undone-item]
  "Recebe o board e o item que queremos marcar como feito
   Remover o item originalmente marcado como false e adiciona o mesmo
   só que com o done? true"
  (-> board
      (remove-item-from-board undone-item)
      (add-items-from-board (todo-list.items/done-item undone-item))))

(defn mark-item-as-undone [board done-item]
  (-> board
      (remove-item-from-board done-item)
      (add-items-from-board (todo-list.items/undone-item done-item))))


