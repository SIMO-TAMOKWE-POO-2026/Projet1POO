TP1:IPPlan-Manager

 Objectif du TP: Ce TP permet de découvrir les premières classes Java du projet IPPlan-
Manager.

 Classes créées
- AdresseIP
- ReseauIP
- InterfaceReseau
- Equipement
- Main

TRAVAIL REALISE
 il était question pour moi ici de savoir comment créer une ou plusieurs classes( AdresseIP, ResauIP, InterfaceReseau,Equipement et Main) et utiliser ,aussi la classe
Main est tres particuliere car contrairement aux autres classes elle permet de savoir l'etat ou la nature des autres classes

Réponses aux questions

1. Pourquoi une adresse IP a-t-elle été représentée par une classe au lieu d’être simplement stockée dans une variable String partout dans le programme ?

Une classe permet de regrouper l'adresse IP avec des méthodes de validation, de manipulation et de formatage. Si on utilise simplement une String, on ne peut pas facilement ajouter ces comportements plus tard sans tout modifier.

2. Quelle est la différence entre une classe et un objet ?

Une classe est un modèle tandis que un objet est une instance concrète de cette classe
Exemple : AdresseIP est la classe, new AdresseIP("192.168.1.1") est un objet.

3. Quel est le rôle du constructeur dans une classe Java ?

Initialiser les attributs de l'objet au moment de sa création. Il permet de s'assurer qu'un objet est dans un état cohérent dès son instanciation.

4. Pourquoi la classe InterfaceReseau contient-elle un objet de type AdresseIP ?

Parce qu'une interface réseau possède une adresse IP (ou pas). C'est une relation de composition : "une interface réseau a une adresse IP".

5. Pourquoi la classe Equipement contient-elle un objet de type InterfaceReseau ?

Parce qu'un équipement réseau possède une ou plusieurs interfaces réseau. 

6. Quelle est la limite actuelle de la classe Equipement dans ce TP ?

Elle ne peut contenir qu'une seule interface réseau.

7. Pourquoi cette première version n’est-elle pas encore suffisante pour produire automatiquement un plan d’adressage IP ?

Car il manque plusieurs éléments essentiels comme :

-La gestion des masques de sous-réseau et du calcul des plages

-La détection des conflits d'adresses IP

-La possibilité d'attribuer automatiquement la prochaine IP disponible

-La gestion de plusieurs interfaces par équipement


