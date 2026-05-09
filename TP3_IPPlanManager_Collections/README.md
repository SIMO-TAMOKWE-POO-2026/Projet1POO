# TP3 - Collections et composition
## Objectif: Introduction des collections et des relations entre objets.

## Notions étudiées
- Composition
- ArrayList
- Collections
- Parcours de listes
- Relations entre objets

## Tests réalisés
- Création d'une infrastructure réseau contenant plusieurs sous-réseaux et équipements
- Ajout de 9 équipements dans l'infrastructure : routeur, serveur, switch, PC fixe, PC portable, imprimante, point d'accès WiFi, caméra de surveillance, équipement invalide
- Ajout de 5 sous-réseaux : réseau principal (192.168.1.0/24), réseau secondaire (10.0.0.0/16), réseau direction (192.168.2.0/24), réseau WiFi (192.168.3.0/24), réseau invalide
- Chaque équipement possède une ArrayList d'interfaces réseau avec possibilité d'en ajouter plusieurs
- Test du parcours des listes avec affichage complet de l'infrastructure (affichage de tous les sous-réseaux puis de tous les équipements)

 Difficultés rencontrées
- Comprendre la différence entre l'ancienne version d'Equipement (avec une seule InterfaceReseau en paramètre du constructeur) et la nouvelle version (avec une ArrayList d'interfaces ajoutées via ajouterInterface())
- Adaptation du code main pour utiliser la nouvelle structure avec ArrayList et la méthode ajouterInterface()
- Gestion de l'erreur "Class does not have a main method" dans NetBeans : nécessité de configurer la classe principale dans les propriétés du projet ou d'exécuter directement le fichier TP2.java


REPONSES AUX QUESTIONS

1. Qu'est-ce qu'une composition en Programmation Orientée Objet ?
La composition est une relation entre classes où une classe contient une référence à une autre classe comme attribut. 

2. Pourquoi utilise-t-on ArrayList dans ce TP ?
On utilise ArrayList car c'est une collection dynamique qui permet de stocker un nombre variable d'éléments, d'ajouter ou supprimer des éléments facilement avec add() et remove(), de parcourir les éléments simplement avec une boucle for-each, et de gérer automatiquement le redimensionnement sans se soucier de la taille maximale.


4. Pourquoi un équipement possède-t-il plusieurs interfaces ?
Un équipement réseau possède plusieurs interfaces pour se connecter à différents réseaux simultanément, assurer la redondance en cas de panne, séparer le trafic réseau, et permettre à un routeur d'interconnecter plusieurs réseaux.

5. Pourquoi une infrastructure réseau contient-elle plusieurs sous-réseaux ?
Une infrastructure réseau contient plusieurs sous-réseaux pour segmenter le réseau par zones géographiques ou fonctionnelles, isoler le trafic, améliorer les performances, renforcer la sécurité en séparant les réseaux sensibles, et faciliter la gestion et l'attribution des adresses IP.

6. Quel est le rôle de la boucle for-each ?
La boucle for-each permet de parcourir tous les éléments d'une collection sans avoir à gérer manuellement un index. Elle est plus lisible et plus sûre qu'une boucle for classique car elle évite les erreurs d'index.

7. Pourquoi la classe InfrastructureReseau devient-elle importante dans le projet ?
La classe InfrastructureReseau devient le point central du projet car elle regroupe tous les éléments du réseau en une seule entité, permet de gérer l'ensemble de l'infrastructure depuis un seul objet, facilite l'affichage global et la recherche d'équipements, et représente le niveau le plus haut de l'organisation du réseau.

8. Pourquoi les collections sont-elles indispensables dans les applications professionnelles ?
Les collections sont indispensables car les applications gèrent des quantités de données variables et imprévisibles. Elles offrent des structures optimisées pour différents usages, simplifient le code en évitant la gestion manuelle des tableaux, fournissent des méthodes puissantes pour trier et rechercher, et sont utilisées partout : clients, produits, transactions, logs, connexions réseau.