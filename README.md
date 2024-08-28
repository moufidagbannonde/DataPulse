## Repository

Un repository est un composant de votre application qui gère les opérations de persistence (CRUD) sur les entités dans une Base de Données. En gros , c'est la couche qui nous permet de parler à la Base de Données sans se soucier des détails .

## Annotation *`@Repository`*

Elle sert à marquer une classe comme étant un repository , c'est-à-dire un endroit où vous allez interagir avec la BDD.

### Est-ce obligatoire de mettre l'annotation ?

Mais non !
Quant on implémente une interface comme `JpaRepository` , Spring détecte automatiquement notre repository !