# TP8 - Moteur de recommandations
## Objectif: Ajouter un moteur de recommandations capable d'analyser un plan VLAN et de proposer des conseils techniques.

## Notions étudiées
Interfaces Java, polymorphisme, règles métier, moteur de recommandations, séparation des responsabilités, extensibilité logicielle.

## Scénarios testés

### Scénario 1 : Campus Universitaire
Adresse de base : 10.10.0.0
- ETUDIANTS : 500 hôtes
- WIFI_INVITES : 200 hôtes
- ENSEIGNANTS : 120 hôtes
- ADMINISTRATION : 60 hôtes
- LABORATOIRES : 30 hôtes
- SERVEURS : 20 hôtes

### Scénario 2 : Nouveau scénario de test
Adresse de base : 192.168.1.0
- ADMINISTRATION : 50 hôtes
- WIFI_INVITES : 120 hôtes
- SERVEURS : 20 hôtes
- CAMERAS : 80 hôtes
- VOIP : 60 hôtes

## Recommandations obtenues

### Scénario 1 : Campus Universitaire

Plan VLAN généré :
VLAN 10 - ETUDIANTS | VLAN ETUDIANTS
ETUDIANTS -> 10.10.0.0/23 | Plage : 10.10.0.1 - 10.10.1.254 | Capacité : 510 hôtes
VLAN 20 - WIFI_INVITES | VLAN WIFI_INVITES
WIFI_INVITES -> 10.10.2.0/24 | Plage : 10.10.2.1 - 10.10.2.254 | Capacité : 254 hôtes
VLAN 30 - ENSEIGNANTS | VLAN ENSEIGNANTS
ENSEIGNANTS -> 10.10.3.0/25 | Plage : 10.10.3.1 - 10.10.3.126 | Capacité : 126 hôtes
VLAN 40 - ADMINISTRATION | VLAN ADMINISTRATION
ADMINISTRATION -> 10.10.3.128/26 | Plage : 10.10.3.129 - 10.10.3.190 | Capacité : 62 hôtes
VLAN 50 - LABORATOIRES | VLAN LABORATOIRES
LABORATOIRES -> 10.10.3.192/27 | Plage : 10.10.3.193 - 10.10.3.222 | Capacité : 30 hôtes
VLAN 60 - SERVEURS | VLAN SERVEURS
SERVEURS -> 10.10.3.224/27 | Plage : 10.10.3.225 - 10.10.3.254 | Capacité : 30 hôtes

Recommandations proposées :
Recommandation : VLAN de grande taille
Niveau : MOYENNE
Description : Le VLAN ETUDIANTS possede une grande capacite. Il faut surveiller les broadcasts.

Recommandation : Isolation du WiFi
Niveau : ELEVEE
Description : Le VLAN WIFI_INVITES doit etre isole des VLANs internes sensibles.

Recommandation : Marge d'adresses insuffisante
Niveau : MOYENNE
Description : Le VLAN WIFI_INVITES a une capacite de 254 hotes avec une marge estimee de seulement 4 hotes (1%). Prevoir une plage plus large si le reseau doit evoluer.

Recommandation : Marge d'adresses insuffisante
Niveau : MOYENNE
Description : Le VLAN ENSEIGNANTS a une capacite de 126 hotes avec une marge estimee de seulement 6 hotes (4%). Prevoir une plage plus large si le reseau doit evoluer.

Recommandation : Acces restreint a l'administration
Niveau : ELEVEE
Description : Le VLAN ADMINISTRATION est un VLAN d'administration. Limiter l'acces aux administrateurs reseau uniquement.

Recommandation : Securite des serveurs
Niveau : ELEVEE
Description : Le VLAN SERVEURS contient des serveurs. Isoler et restreindre les acces.



### Scénario 2 : Nouveau scénario de test


Plan VLAN généré :
VLAN 10 - WIFI_INVITES | VLAN WIFI_INVITES
WIFI_INVITES -> 192.168.1.0/25 | Plage : 192.168.1.1 - 192.168.1.126 | Capacité : 126 hôtes
VLAN 20 - CAMERAS | VLAN CAMERAS
CAMERAS -> 192.168.1.128/25 | Plage : 192.168.1.129 - 192.168.1.254 | Capacité : 126 hôtes
VLAN 30 - VOIP | VLAN VOIP
VOIP -> 192.168.2.0/26 | Plage : 192.168.2.1 - 192.168.2.62 | Capacité : 62 hôtes
VLAN 40 - ADMINISTRATION | VLAN ADMINISTRATION
ADMINISTRATION -> 192.168.2.64/26 | Plage : 192.168.2.65 - 192.168.2.126 | Capacité : 62 hôtes
VLAN 50 - SERVEURS | VLAN SERVEURS
SERVEURS -> 192.168.2.128/27 | Plage : 192.168.2.129 - 192.168.2.158 | Capacité : 30 hôtes

Recommandations proposées :
Recommandation : Isolation du WiFi
Niveau : ELEVEE
Description : Le VLAN WIFI_INVITES doit etre isole des VLANs internes sensibles.

Recommandation : Marge d'adresses insuffisante
Niveau : MOYENNE
Description : Le VLAN WIFI_INVITES a une capacite de 126 hotes avec une marge estimee de seulement 6 hotes (4%). Prevoir une plage plus large si le reseau doit evoluer.

Recommandation : Marge d'adresses insuffisante
Niveau : MOYENNE
Description : Le VLAN CAMERAS a une capacite de 126 hotes avec une marge estimee de seulement 6 hotes (4%). Prevoir une plage plus large si le reseau doit evoluer.

Recommandation : Acces restreint a l'administration
Niveau : ELEVEE
Description : Le VLAN ADMINISTRATION est un VLAN d'administration. Limiter l'acces aux administrateurs reseau uniquement.

Recommandation : Securite des serveurs
Niveau : ELEVEE
Description : Le VLAN SERVEURS contient des serveurs. Isoler et restreindre les acces.


## Règles de recommandation implémentées

| Règle | Classe | Niveau | Déclencheur |
|-------|--------|--------|-------------|
| VLAN de grande taille | RecommandationGrandVLAN | MOYENNE | Capacité > 200 hôtes |
| Isolation WiFi | RecommandationWifiInvite | ELEVEE | Nom contient "WIFI" |
| Sécurité serveurs | RecommandationServeurs | ELEVEE | Nom contient "SERVEUR" |
| Accès administration | RecommandationAdministration | ELEVEE | Nom contient "ADMIN" |
| Marge d'adresses | RecommandationMargeAdresse | MOYENNE | Marge < 20% de la capacité |

## REPONSES AUX QUESTIONS

1. Quel est le rôle d'un moteur de recommandations dans un outil IPAM ?
Le moteur de recommandations analyse automatiquement le plan d'adressage et les VLANs pour fournir des conseils techniques pertinents. Il aide l'administrateur à identifier les problèmes potentiels (marges insuffisantes, VLANs surdimensionnés), à appliquer les bonnes pratiques de sécurité (isolation WiFi, restriction administration), et à anticiper les évolutions du réseau sans avoir à vérifier manuellement chaque configuration.

 2. Pourquoi utilise-t-on une interface pour les règles de recommandation ?
On utilise une classe abstraite (RegleRecommandation) pour définir un contrat commun que toutes les règles doivent respecter. Chaque règle implémente la méthode analyser() à sa façon. Cela permet au MoteurRecommandation de traiter toutes les règles de manière uniforme sans connaître leur fonctionnement interne, et d'ajouter de nouvelles règles sans modifier le code existant.

 3. Quelle est la différence entre une classe concrète et une interface ?
Une classe abstraite (ou interface) définit un contrat avec des méthodes que les classes concrètes doivent implémenter. Elle ne peut pas être instanciée directement. Une classe concrète comme RecommandationGrandVLAN hérite de ce contrat et fournit une implémentation complète de la méthode analyser(). 

 4. Pourquoi la méthode analyser() peut-elle retourner null ?
La méthode analyser() peut retourner null car une règle ne s'applique pas forcément à tous les VLANs.

5. Pourquoi le moteur de recommandations illustre-t-il le polymorphisme ?
Le moteur illustre le polymorphisme car il manipule toutes les règles via leur type abstrait RegleRecommandation. 

 6. Pourquoi est-il préférable de créer une classe par règle au lieu de mettre tous les tests dans Main ?
Créer une classe par règle respecte le principe de responsabilité unique : chaque classe a une seule raison de changer. Cela rend le code plus lisible, plus facile à tester unitairement, et permet d'ajouter ou modifier des règles sans toucher au moteur ou au Main. 

 7. Pourquoi un VLAN WiFi invité doit-il être isolé des réseaux internes ?
Un VLAN WiFi invité doit être isolé des réseaux internes pour des raisons de sécurité. Les utilisateurs invités ne doivent pas pouvoir accéder aux ressources sensibles de l'entreprise (serveurs, bases de données, imprimantes, postes de travail).

 8. Pourquoi les VLANs de grande taille doivent-ils être surveillés ?
Les VLANs de grande taille doivent être surveillés car ils génèrent un trafic broadcast important. Dans un VLAN de 500 hôtes, chaque broadcast (ARP, DHCP) est envoyé à toutes les machines, ce qui consomme de la bande passante et du temps CPU sur chaque poste. 

## Difficultés rencontrées
- Création de la classe abstraite RegleRecommandation pour permettre le polymorphisme
- Implémentation du pattern stratégie avec des règles interchangeables
- Détection des mots-clés dans les noms de VLAN avec toUpperCase() et contains()
- Calcul de la marge d'adresses par rapport au besoin estimé
- Gestion du cas où getResultat() retourne null (VLAN sans résultat associé)

