# TP7 - Validations avancées et détection des conflits
## Objectif: Ajouter des validations avancées pour détecter les incohérences dans un plan d'adressage.

## Notions étudiées
Exceptions personnalisées, try/catch, throw, validation réseau, détection de chevauchement, conflit VLAN, robustesse logicielle.

## Scénarios testés

### Scénario 1 : Plan d'adressage valide
Génération d'un plan VLSM à partir de 192.168.1.0 avec 4 besoins (ADMINISTRATION: 50, TECHNIQUE: 120, WIFI: 80, SERVEURS: 20) et validation complète du plan.

### Scénario 2 : Adresse de départ invalide
Génération d'un plan à partir d'une adresse IP invalide (192.168.300.0) pour vérifier la détection d'erreur de validation.

### Scénario 3 : Chevauchement de réseaux
Création manuelle de deux objets ResultatVLSM qui se chevauchent : 192.168.1.0/25 et 192.168.1.64/26, pour tester la détection de chevauchement.

### Scénario 4 : Conflit d'identifiants VLAN
Ajout de 3 VLANs valides (10, 20, 30) puis tentative d'ajout d'un quatrième VLAN avec l'ID 10 déjà utilisé.

### Scénario 5 : Réseau de départ insuffisant
Tentative de génération d'un plan avec des besoins totalisant 350 hôtes dans un réseau 192.168.1.0/24 qui ne peut contenir que 254 hôtes.

## Résultats obtenus

### Scénario 1 : Plan valide

Plan généré :
TECHNIQUE -> 192.168.1.0/25 | Plage : 192.168.1.1 - 192.168.1.126 | Capacité : 126 hôtes
WIFI -> 192.168.1.128/25 | Plage : 192.168.1.129 - 192.168.1.254 | Capacité : 126 hôtes
ADMINISTRATION -> 192.168.2.0/26 | Plage : 192.168.2.1 - 192.168.2.62 | Capacité : 62 hôtes
SERVEURS -> 192.168.2.64/27 | Plage : 192.168.2.65 - 192.168.2.94 | Capacité : 30 hôtes
Validation réussie : aucune erreur détectée.


### Scénario 2 : Adresse invalide

Erreur de validation : Adresse réseau invalide pour TEST


### Scénario 3 : Chevauchement

Erreur de validation : Chevauchement détecté entre RESEAU_A et RESEAU_B


### Scénario 4 : Conflit VLAN

Ajout de 3 VLANs valides...
VLAN 10 ajouté avec succès.
VLAN 20 ajouté avec succès.
VLAN 30 ajouté avec succès.

Tentative d'ajout d'un VLAN avec ID déjà utilisé...
Erreur VLAN : Conflit : le VLAN 10 est déjà utilisé par ADMINISTRATION


### Scénario 5 : Réseau insuffisant

Erreur : Le réseau de départ est insuffisant ! Capacité du réseau : 254 hôtes, Besoins cumulés : 350 hôtes.



## REPONSES AUX QUESTIONS

 1. Pourquoi les validations avancées sont-elles indispensables dans un outil IPAM ?
Les validations avancées sont indispensables car un outil IPAM manipule des données critiques pour le fonctionnement du réseau. Une erreur de planification (adresses invalides, chevauchements, conflits) peut rendre le réseau inutilisable. 

 2. Quelle est la différence entre une erreur simple et une exception en Java ?
Une erreur simple (comme retourner -1 ou null) oblige le programmeur à vérifier manuellement la valeur de retour après chaque appel de méthode, ce qui peut être oublié. Une exception interrompt le flux normal du programme et doit obligatoirement être traitée avec try/catch, ce qui force la gestion du problème. 

 3. Pourquoi crée-t-on des exceptions personnalisées ?
On crée des exceptions personnalisées pour donner un sens métier précis aux erreurs. `ReseauInsuffisantException` indique clairement que le réseau de départ n'a pas assez de capacité, `ConflitVLANException` signale un conflit d'identifiant VLAN. Cela rend le code plus lisible et permet de catcher spécifiquement certains types d'erreurs pour les traiter différemment.

 4. Quel est le rôle du bloc try/catch ?
Le bloc try/catch permet de gérer les exceptions de manière contrôlée. Le code à risque est placé dans le try. Si une exception est levée, le catch la capture et exécute un traitement approprié (afficher un message, proposer une alternative, journaliser l'erreur) au lieu de laisser le programme planter brutalement.

 5. Pourquoi deux VLANs ne doivent-ils pas avoir le même identifiant dans une même infrastructure ?
Deux VLANs ne doivent pas avoir le même identifiant car le numéro VLAN est utilisé par les commutateurs pour identifier et isoler le trafic. Si deux VLANs partagent le même ID, leurs trafics seraient mélangés, ce qui compromettrait la sécurité et la segmentation logique du réseau. Chaque VLAN doit avoir un identifiant unique pour garantir l'isolation.

 6. Pourquoi deux sous-réseaux ne doivent-ils pas se chevaucher ?
Deux sous-réseaux ne doivent pas se chevaucher car cela créerait une ambiguïté dans le routage. Une adresse IP appartenant à deux sous-réseaux en même temps rendrait impossible de déterminer vers quel réseau router le trafic. Cela entraînerait des conflits d'adresses, des erreurs de communication et potentiellement l'isolement de certaines machines.

 7. Pourquoi transforme-t-on les adresses IP en entiers pour comparer des plages réseau ?
On transforme les adresses IP en entiers car cela permet de comparer facilement des plages avec des opérations mathématiques simples. Une adresse IP comme 192.168.1.0 devient un nombre unique. Pour vérifier un chevauchement, il suffit de comparer les débuts et fins de plages avec des opérateurs < et >, ce qui est beaucoup plus simple que de manipuler 4 octets séparément.

 8. Pourquoi la classe ValidateurPlanAdressage doit-elle être séparée du moteur VLSM ?
La classe ValidateurPlanAdressage doit être séparée du moteur VLSM pour respecter le principe de responsabilité unique. Le moteur VLSM a pour rôle de générer le plan d'adressage. Le validateur a pour rôle de vérifier la cohérence du plan. En les séparant, on peut valider n'importe quel plan (généré automatiquement ou créé manuellement), faire évoluer les règles de validation sans toucher au moteur, et tester chaque composant indépendamment.

## Difficultés rencontrées
- Création d'exceptions personnalisées en héritant de la classe Exception
- Gestion de la clause throws dans la méthode genererPlan() pour déclarer ReseauInsuffisantException
- Adaptation du code Main pour capturer la nouvelle exception avec des blocs try/catch
- Implémentation de la logique de détection de chevauchement : conversion des adresses IP en entiers et comparaison des plages
- Vérification de la somme des besoins par rapport à la capacité du réseau de départ
- Extraction du CIDR depuis l'adresse de départ (format "192.168.1.0/24") pour calculer la capacité
