(ns hello
  (:gen-class
              :implements [com.github.K0zka.HelloService]
              )
  )

(defn -greet
  [_ name]
  (format "Hello %s!" name))