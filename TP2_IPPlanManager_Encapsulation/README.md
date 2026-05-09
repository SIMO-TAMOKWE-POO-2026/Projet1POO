 TP2 - Encapsulation
 Objectif:Introduction de l'encapsulation et des validations.

 Notions étudiées
- private
- getters
- setters
- validation
- this

## Tests réalisés
- Création d'adresses IP avec des valeurs valides (ex: "192.168.1.1", "10.0.0.1", "172.16.0.254")
- Création d'adresses IP invalides (chaîne vide "" et null) : le constructeur détecte l'erreur et assigne "0.0.0.0" par défaut
- Création d'interfaces réseau avec des noms valides et invalides : les noms invalides sont remplacés par "eth0"
- Activation et désactivation d'interfaces réseau via les méthodes activer() et desactiver()
- Création d'équipements avec des noms et types valides et invalides : les valeurs invalides sont remplacées par des valeurs par défaut

## Difficultés rencontrées
- Comprendre l'avertissement de l'IDE concernant l'appel d'une méthode surchargeable (setValeur) dans le constructeur de AdresseIP : l'ampoule signalait un risque potentiel si la classe était héritée et que setValeur était redéfinie dans une sous-classe
- Résolution du problème en déplaçant la logique de validation directement dans le constructeur plutôt que d'appeler le setter
- Configuration de NetBeans pour exécuter la bonne classe contenant la méthode main : nécessité de faire un clic droit sur le fichier TP2.java puis "Run File" au lieu d'exécuter le package entier

 REPONSES AUX QUESTIONS

1. Pourquoi utilise-t-on private dans les classes ?
On utilise private pour empêcher l'accès direct aux attributs depuis l'extérieur de la classe. Cela oblige les autres classes à passer par des méthodes publiques (getters/setters) pour lire ou modifier ces attributs, ce qui permet de contrôler et valider les données avant toute modification.

2. Quelle différence existe entre un attribut public et un attribut privé ?
Un Attribut public est Accessible depuis n'importe quelle autre classe tandis que un attribut prive est	Accessible uniquement depuis la classe elle-même.

3. Pourquoi utilise-t-on des getters et setters ?
Pour contrôler l'accès aux attributs privés

Pour valider les données avant modification (dans les setters)

Pour permettre la lecture seule (getter sans setter) ou l'écriture seule

Pour pouvoir modifier l'implémentation interne sans changer l'interface publique


4. Pourquoi les validations sont-elles importantes dans un logiciel réseau ?
Une adresse IP invalide peut empêcher toute communication entre équipements

Un masque de sous-réseau incorrect peut causer des erreurs de routage

Des données incohérentes peuvent entraîner des pannes réseau ou des failles de sécurité


5. Quel est le rôle du mot-clé this ?
Le mot-clé this fait référence à l'instance courante de l'objet. Il permet de :Distinguer les attributs des paramètres quand ils portent le même nom 


6. Pourquoi le constructeur appelle-t-il les setters ?
Le constructeur appelle les setters pour réutiliser la logique de validation déjà présente dans ceux-ci. Plutôt que de dupliquer le code de validation dans le constructeur et dans le setter, on centralise la validation dans le setter et on l'appelle depuis le constructeur. Cela respecte le principe DRY (Don't Repeat Yourself) et simplifie la maintenance du code.

7. Pourquoi la validation du masque CIDR est-elle importante ?
Un masque CIDR doit être compris entre 0 et 32 (pour IPv4). Une valeur hors de cet intervalle est invalide.

Un masque incorrect peut rendre un réseau inutilisable (ex : /55 ou /-5 n'ont aucun sens)

Le masque définit la taille du réseau et le nombre d'adresses disponibles : une erreur peut causer des conflits d'adresses

Dans un logiciel réseau, une mauvaise configuration du masque peut isoler des équipements ou créer des problèmes de routage

8. Pourquoi l'encapsulation améliore-t-elle la sécurité logicielle ?
Les attributs privés empêchent la modification directe et non contrôlée des données

Les setters peuvent rejeter les valeurs invalides ou dangereuses avant de modifier l'état de l'objet

L'état interne de l'objet reste toujours cohérent grâce aux validations

Les classes externes ne peuvent pas accéder aux détails d'implémentation sensibles


