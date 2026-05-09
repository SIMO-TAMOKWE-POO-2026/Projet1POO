 TP5 - Moteur VLSM
## Objectif: Développer un moteur VLSM capable de proposer automatiquement un plan d'adressage à partir des besoins exprimés.

## Notions étudiées
VLSM, tri de collections, classe de service métier, calcul CIDR, conversion IP-entier, génération automatique de sous-réseaux.

## Scénarios testés

### Scénario 1 : Moyenne Entreprise
Adresse de base : 192.168.1.0
- TECHNIQUE : 120 hôtes
- WIFI : 80 hôtes
- ADMINISTRATION : 50 hôtes
- SERVEURS : 20 hôtes
- DIRECTION : 10 hôtes

### Scénario 2 : Petite Entreprise
Adresse de base : 10.0.0.0
- ADMIN : 25 hôtes
- COMPTABILITE : 12 hôtes
- WIFI_INVITES : 40 hôtes
- SERVEURS : 8 hôtes

### Scénario 3 : Campus
Adresse de base : 172.16.0.0
- ETUDIANTS : 500 hôtes
- PERSONNEL : 120 hôtes
- LABORATOIRE : 60 hôtes
- ADMINISTRATION : 40 hôtes
- WIFI_PUBLIC : 200 hôtes

## Résultats obtenus

### Scénario 1 : Moyenne Entreprise (192.168.1.0)
TECHNIQUE -> 192.168.1.0/25 | Plage : 192.168.1.1 - 192.168.1.126 | Capacité : 126 hôtes
WIFI -> 192.168.1.128/25 | Plage : 192.168.1.129 - 192.168.1.254 | Capacité : 126 hôtes
ADMINISTRATION -> 192.168.2.0/26 | Plage : 192.168.2.1 - 192.168.2.62 | Capacité : 62 hôtes
SERVEURS -> 192.168.2.64/27 | Plage : 192.168.2.65 - 192.168.2.94 | Capacité : 30 hôtes
DIRECTION -> 192.168.2.96/28 | Plage : 192.168.2.97 - 192.168.2.110 | Capacité : 14 hôtes



### Scénario 2 : Petite Entreprise (10.0.0.0)

WIFI_INVITES -> 10.0.0.0/26 | Plage : 10.0.0.1 - 10.0.0.62 | Capacité : 62 hôtes
ADMIN -> 10.0.0.64/27 | Plage : 10.0.0.65 - 10.0.0.94 | Capacité : 30 hôtes
COMPTABILITE -> 10.0.0.96/28 | Plage : 10.0.0.97 - 10.0.0.110 | Capacité : 14 hôtes
SERVEURS -> 10.0.0.112/28 | Plage : 10.0.0.113 - 10.0.0.126 | Capacité : 14 hôtes



### Scénario 3 : Campus (172.16.0.0)

ETUDIANTS -> 172.16.0.0/23 | Plage : 172.16.0.1 - 172.16.1.254 | Capacité : 510 hôtes
WIFI_PUBLIC -> 172.16.2.0/24 | Plage : 172.16.2.1 - 172.16.2.254 | Capacité : 254 hôtes
PERSONNEL -> 172.16.3.0/25 | Plage : 172.16.3.1 - 172.16.3.126 | Capacité : 126 hôtes
LABORATOIRE -> 172.16.3.128/26 | Plage : 172.16.3.129 - 172.16.3.190 | Capacité : 62 hôtes
ADMINISTRATION -> 172.16.3.192/26 | Plage : 172.16.3.193 - 172.16.3.254 | Capacité : 62 hôtes


## Comparaison des scénarios
- Le scénario 1 utilise la plage privée 192.168.x.x avec des CIDR allant de /25 à /28
- Le scénario 2 utilise la plage privée 10.x.x.x avec des CIDR allant de /26 à /28
- Le scénario 3 utilise la plage privée 172.16.x.x avec des CIDR plus larges (/23, /24) pour accommoder les grands besoins en hôtes
- Le VLSM optimise l'espace d'adressage en attribuant le masque le plus proche du besoin réel

## Comparaison des scénarios
- Le scénario 1 utilise la plage privée 192.168.x.x avec des CIDR allant de /25 à /28
- Le scénario 2 utilise la plage privée 10.x.x.x avec des CIDR allant de /26 à /28
- Le scénario 3 utilise la plage privée 172.16.x.x avec des CIDR plus larges (/23, /24) pour accommoder les grands besoins en hôtes
- Le VLSM optimise l'espace d'adressage en attribuant le masque le plus proche du besoin réel

REPONSES AUX QUESTIONS

 1. Pourquoi le VLSM permet-il d'économiser les adresses IP ?
Le VLSM permet d'économiser les adresses IP car il attribue à chaque sous-réseau un masque adapté à son besoin réel. Au lieu d'utiliser un masque unique pour tous les sous-réseaux , le VLSM donne un masque plus grand aux sous-réseaux avec peu d'hôtes et un masque plus petit à ceux avec beaucoup d'hôtes. 

2. Pourquoi faut-il traiter les plus grands besoins en premier ?
Il faut traiter les plus grands besoins en premier car ils nécessitent des blocs d'adresses plus volumineux. Si on commence par les petits sous-réseaux, on risque de fragmenter l'espace d'adressage et de ne plus avoir de blocs assez grands pour les besoins importants. 

3. Quelle est la différence entre un besoin réseau et un résultat VLSM ?
Un besoin réseau  exprime une demande utilisateur : un nom et un nombre d'hôtes souhaités. Un résultat VLSM  est la réponse calculée par le moteur : il contient le nom, l'adresse réseau attribuée, le CIDR calculé, le masque décimal, la capacité réelle, et la plage d'adresses utilisables. Le besoin est l'entrée, le résultat est la sortie après calcul et optimisation.

 4. Pourquoi la classe MoteurVLSM est-elle une classe de service métier ?
La classe MoteurVLSM est une classe de service métier car elle contient la logique principale de l'application : l'algorithme de génération de plan d'adressage. 

5. Pourquoi transforme-t-on une adresse IP en entier pour certains calculs ?
On transforme une adresse IP en entier car cela facilite les opérations arithmétiques. 

 6. Quel est le rôle de la méthode calculerCidrPourHotes() ?
La méthode calculerCidrPourHotes() détermine le plus petit CIDR capable de contenir le nombre d'hôtes demandé. Elle trouve la plus petite puissance de 2 supérieure ou égale à (nombre d'hôtes + 2) car il faut réserver l'adresse réseau et l'adresse de broadcast. Par exemple, pour 50 hôtes, 2^6 = 64 ≥ 52, donc CIDR = 32 - 6 = /26.

7. Pourquoi une adresse de réseau et une adresse de broadcast ne sont-elles pas attribuées aux machines ?
L'adresse réseau (tout à 0 dans la partie hôte) identifie le sous-réseau lui-même et sert au routage. L'adresse de broadcast (tout à 1 dans la partie hôte) permet d'envoyer un message à toutes les machines du sous-réseau simultanément. Si on les attribuait à des machines, on ne pourrait plus identifier le réseau ni diffuser des messages, ce qui rendrait les communications impossibles.

8. Pourquoi le moteur VLSM représente-t-il une étape importante dans le projet IPPlan-Manager ?
Le moteur VLSM est une étape importante car c'est le cœur intelligent du logiciel de planification IP. Il automatise la tâche la plus complexe : découper un espace d'adressage en sous-réseaux de tailles variées sans gaspillage. Sans lui, l'utilisateur devrait calculer manuellement chaque sous-réseau, ce qui est long et source d'erreurs. Il transforme IPPlan-Manager d'un simple gestionnaire d'adresses en un véritable outil d'aide à la décision réseau.

## Difficultés rencontrées
- Tri des besoins par ordre décroissant du nombre d'hôtes avec Collections.sort() et Comparator
- Conversion entre adresse IP sous forme de chaîne et représentation entière pour faciliter les calculs d'incrémentation
- Calcul automatique du CIDR optimal pour un nombre d'hôtes donné : trouver la plus petite puissance de 2 supérieure à (hôtes + 2)
- Gestion des retenues lors de l'incrémentation des adresses IP (dernier octet > 255)
- Calcul de la première et dernière adresse utilisable avec gestion du broadcast
- Appel des méthodes statiques de CalculateurReseau depuis ResultatVLSM et MoteurVLSM
- Compréhension du principe VLSM : attribution de masques de tailles différentes selon les besoins plutôt qu'un masque unique
