(ns introdução-clojure.core)


;Tipos  Númericos
(def literal 13)
(def meuFloat 0.13)
(def ratio 1/2)

(println literal)
(println meuFloat )
(println ratio)

;tipos de conjuntos
(def meuVector [1 2 3 4])
(def meuList '(1 2 3 4)) ;precisa possuir o '
(def meuMap {:a 1 :b 2 :c 3 :d 4}) ; o :a é a chave para o elemento 1
(def meuHashSet #{1 2 3 4}) ;Não pode possuir elementos repetidos

(println meuVector)
(println meuList)
(println meuMap)
(println meuHashSet)

;Funções
(inc 1) ;incrementa
(max 1 2 54 6) ;retorna o mínimo
(min 1 2 54 6) ;retorna o máximo
(hash-set 1 2 3 3 3 4 4) ;retorna um hashset e elimina os repetidos
(map inc [1 2 3 4]) ;O map aplica uma função para todos os elementos de um array. a função retorna uma lista com todos os valores incrementados
(rand-int 10) ;retorna um número inteiro de 0 até 9

;Operadores
(< 1 2)
(> 1 2)
(= 1 1)
(not= 1 1)

;coleções (collections)
(conj '(1 2 3) 4) ;retorna uma nova coleção com o elemento ao início
(conj [1 2 3] 4) ;retorna uma nova coleção com o elemento ao final
(def nomes ["Lucas" "Wesley" "Alexandre"])
(remove #(= % "Alexandre") nomes)                           ;remove alexandre do vetor nomes
(every? even? '(2 4 8)) ;verifica se todos os elementos de uma lista respeitam a uma condição, que nesse caso é se é par.
(get [1 2 3 4] 0) ;retorna o elemento da posição 0 para vetor
(nth '(1 2 3 4) 0) ;retorna o elemento da posição 0 para lista

;filter e reduce
(def lista [1 2 3 4 5 6 7 8 9 10])
(defn filter-list [lista] (filter #(= (mod % 2) 0) lista))  ;filtra a nossa lista e retorna uma nova com apenas os números múltiplos de 2
(defn multiply-list [lista] (map #( * 2 %) lista) )         ;multiplica cada elemento da lista por 2 com o map
(defn sum-list [lista] (reduce (fn [number result] (+ result number)) 0 lista)) ; soma todos os elementos da lista usando o reduce
;definir função

(defn hello-world [] (println "Hello World!"))
(defn sum [a b] (+ a b))

(hello-world)
(println (sum 1 2))

"Uso do let: "
(def card1 5)                                               ;Defino a variável card1 = 5

"Gera um número aleatório entre 0 e 12 e incrementa com +1"
(defn new-card []
  (inc (rand-int 13)))

"com o uso do let a variável card1 terá um valor diferente somente dentro desta função"
(defn player [player_name]
  (let [card1 (new-card)
        card2 (new-card)]
    {:player player_name
     :cards [card1 card2]}))

(println (player "Eric"))

(println card1)


"Uso do atom: "

(def nome (atom "Eric"))                                    ;atom permite que a variável seja modificada
(println @nome)

"essa função retorna um novo nome"
(defn funcao-altera-nome [atom novo-nome]
  (println atom)
  (println novo-nome)
  novo-nome)

"O swap! muda o valor de nossa variável"
(swap! nome funcao-altera-nome "Eric Bispo")
(println @nome)


