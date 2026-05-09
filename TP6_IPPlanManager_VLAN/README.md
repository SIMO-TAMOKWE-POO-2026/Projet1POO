# TP6 - VLAN et segmentation logique
## Objectif: Mettre en place la gestion des VLANs et associer automatiquement les sous-réseaux générés aux VLANs.

## Notions étudiées
Segmentation logique, VLAN, gestionnaires métier, collections, associations entre objets, architecture métier.

## Scénarios testés

### Scénario 1 : Moyenne Entreprise
Adresse de base : 192.168.1.0
VLANs générés : numéros 10, 20, 30, 40
- TECHNIQUE : 120 hôtes
- WIFI : 80 hôtes
- ADMINISTRATION : 50 hôtes
- SERVEURS : 20 hôtes

### Scénario 2 : Université
Adresse de base : 10.0.0.0
VLANs générés : numéros 100, 110, 120, 130, 140
- ETUDIANTS : 500 hôtes
- ENSEIGNANTS : 120 hôtes
- LABORATOIRES : 60 hôtes
- WIFI_PUBLIC : 200 hôtes
- SERVEURS : 30 hôtes

## Résultats obtenus

### Scénario 1 : Moyenne Entreprise

VLAN 10 - TECHNIQUE
TECHNIQUE -> 192.168.1.0/25 | Plage : 192.168.1.1 - 192.168.1.126 | Capacité : 126 hôtes

VLAN 20 - WIFI
WIFI -> 192.168.1.128/25 | Plage : 192.168.1.129 - 192.168.1.254 | Capacité : 126 hôtes

VLAN 30 - ADMINISTRATION
ADMINISTRATION -> 192.168.2.0/26 | Plage : 192.168.2.1 - 192.168.2.62 | Capacité : 62 hôtes

VLAN 40 - SERVEURS
SERVEURS -> 192.168.2.64/27 | Plage : 192.168.2.65 - 192.168.2.94 | Capacité : 30 hôtes


Nombre total de VLANs : 4
VLANs avec plus de 100 hôtes : VLAN 10, VLAN 20
VLAN avec la plus grande capacité : VLAN 10 (126 hôtes)
VLANs critiques : VLAN 10 - TECHNIQUE - 126 hôtes, VLAN 20 - WIFI - 126 hôtes

### Scénario 2 : Université

VLAN 100 - ETUDIANTS
ETUDIANTS -> 10.0.0.0/23 | Plage : 10.0.0.1 - 10.0.1.254 | Capacité : 510 hôtes

VLAN 110 - WIFI_PUBLIC
WIFI_PUBLIC -> 10.0.2.0/24 | Plage : 10.0.2.1 - 10.0.2.254 | Capacité : 254 hôtes

VLAN 120 - ENSEIGNANTS
ENSEIGNANTS -> 10.0.3.0/25 | Plage : 10.0.3.1 - 10.0.3.126 | Capacité : 126 hôtes

VLAN 130 - LABORATOIRES
LABORATOIRES -> 10.0.3.128/26 | Plage : 10.0.3.129 - 10.0.3.190 | Capacité : 62 hôtes

VLAN 140 - SERVEURS
SERVEURS -> 10.0.3.192/27 | Plage : 10.0.3.193 - 10.0.3.222 | Capacité : 30 hôtes
Nombre total de VLANs : 5
VLANs avec plus de 100 hôtes : VLAN 100, VLAN 110, VLAN 120
VLAN avec la plus grande capacité : VLAN 100 (510 hôtes)
VLANs critiques : VLAN 100 - ETUDIANTS - 510 hôtes, VLAN 110 - WIFI_PUBLIC - 254 hôtes, VLAN 120 - ENSEIGNANTS - 126 hôtes

## Tests de recherche VLAN
- Recherche VLAN 20 : trouvé
- Recherche VLAN 99 : introuvable
- Recherche VLAN 110 : trouvé
- Recherche VLAN 200 : introuvable

REPONSES AUX QUESTIONS

1. Pourquoi les VLANs sont-ils importants dans les réseaux modernes ?
Les VLANs sont importants car ils permettent de segmenter un réseau physique en plusieurs réseaux logiques indépendants. 

2. Pourquoi un VLAN est-il souvent associé à un sous-réseau spécifique ?
Un VLAN est associé à un sous-réseau spécifique car chaque VLAN fonctionne comme un réseau indépendant avec sa propre plage d'adresses IP. 

3. Pourquoi la séparation logique améliore-t-elle la sécurité ?
La séparation logique améliore la sécurité car elle isole le trafic réseau. Un utilisateur du VLAN WiFi ne peut pas accéder directement aux ressources du VLAN Serveurs sans passer par un routeur configuré pour filtrer le trafic. 

4. Quel est le rôle de la classe GestionnaireVLAN ?
La classe GestionnaireVLAN centralise toutes les opérations liées aux VLANs : ajout, recherche par numéro, comptage, filtrage par capacité, recherche du VLAN le plus dimensionné, et affichage.

 5. Pourquoi la classe VLAN contient-elle un objet ResultatVLSM ?
La classe VLAN contient un objet ResultatVLSM car un VLAN a besoin d'un sous-réseau pour fonctionner. Cette association représente la réalité réseau : chaque VLAN doit avoir sa propre plage d'adresses IP. En incluant le ResultatVLSM, le VLAN connaît sa configuration réseau complète (adresse réseau, CIDR, plage d'adresses, capacité).

 6. Pourquoi utilise-t-on encore ArrayList dans ce TP ?
On utilise encore ArrayList car la liste des VLANs est dynamique et peut varier selon le nombre de sous-réseaux générés par le moteur VLSM. 

7. Pourquoi les responsabilités des classes doivent-elles être séparées ?
Les responsabilités doivent être séparées pour respecter le principe de responsabilité unique (Single Responsibility Principle). Chaque classe a un rôle précis : BesoinReseau exprime un besoin, MoteurVLSM génère le plan, ResultatVLSM stocke un résultat, VLAN l'associe à un numéro, GestionnaireVLAN gère la collection. 

 8. Pourquoi le projet commence-t-il maintenant à ressembler à une véritable application professionnelle ?
Le projet ressemble à une application professionnelle car il combine plusieurs couches logicielles : des classes de données (VLAN, ResultatVLSM), des classes de calcul (CalculateurReseau, MoteurVLSM), et des classes de gestion (GestionnaireVLAN). L'architecture est modulaire, chaque composant a un rôle défini, et l'ensemble fonctionne de manière cohérente pour résoudre un problème réel : la planification automatique d'adressage IP avec segmentation VLAN.

## Difficultés rencontrées
- Création de la classe VLAN pour associer un numéro de VLAN à un résultat VLSM
- Mise en place du GestionnaireVLAN avec des méthodes de recherche et filtrage
- Implémentation de la méthode afficherVLANsCritiques() pour détecter les VLANs avec plus de 100 hôtes
- Implémentation de getVLANPlusGrandeCapacite() pour trouver le VLAN le plus dimensionné
