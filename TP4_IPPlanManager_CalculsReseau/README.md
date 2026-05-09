 TP4 - Calculs réseau
Objectif: Introduction des calculs automatiques réseau.

Notions étudiées
Méthodes statiques, calculs réseau, CIDR, logique algorithmique, classes utilitaires.

 Tests réalisés
- Calcul du nombre d'hôtes utilisables pour différents CIDR : /8, /16, /20, /24, /26, /28
- Vérification des cas limites : CIDR /0 (toutes les adresses), /31 (2 hôtes), /32 (0 hôte)
- Vérification des CIDR invalides (-3, 55) retournant 0 hôte
- Détection des classes réseau (A, B, C) à partir du premier octet des adresses IP
- Conversion des masques CIDR en notation décimale pointée : /8, /16, /24, /25, /26, /27, /28
- Test de la méthode estReseauPrive() sur les plages privées : 10.x.x.x, 172.16.x.x à 172.31.x.x, 192.168.x.x
- Test de la méthode estReseauPrive() sur des adresses publiques : 8.8.8.8, 1.1.1.1
- Test des cas limites de la plage 172.16/12 : 172.15.0.1 (false) et 172.32.0.1 (false)
- Calcul de l'adresse réseau par opération AND bit à bit entre IP et masque
- Affichage des capacités réseau pour les 9 sous-réseaux de l'infrastructure
- Vérification de l'infrastructure complète avec 9 sous-réseaux créés

REPONSES AUX QUESTIONS

 1. Pourquoi a-t-on créé une classe utilitaire ?
On a créé une classe utilitaire pour regrouper toutes les méthodes de calcul réseau au même endroit. Cela évite de dupliquer le code dans plusieurs classes. Les méthodes étant statiques, on peut les appeler directement sans créer d'objet, ce qui est pratique pour des fonctions de calcul indépendantes.

 2. Quel est le rôle du mot-clé static ?
Le mot-clé static permet d'associer une méthode ou un attribut à la classe elle-même plutôt qu'à une instance. On peut appeler une méthode statique directement avec le nom de la classe (ex: `CalculateurReseau.estReseauPrive("10.0.0.1")`) sans avoir besoin de créer un objet avec new.

3. Pourquoi les calculs réseau sont-ils importants dans un outil IPAM ?
Les calculs réseau sont essentiels dans un outil IPAM (IP Address Management) car ils permettent d'automatiser la détermination du nombre d'hôtes disponibles, la vérification des conflits d'adresses, l'identification des plages privées et publiques, et la validation des configurations réseau avant déploiement.

 4. Quelle est l'utilité du CIDR ?
Le CIDR (Classless Inter-Domain Routing) permet de définir un masque de sous-réseau de façon flexible sans être limité par les classes A, B, C traditionnelles. Il permet de découper un réseau en sous-réseaux de taille précise, d'optimiser l'utilisation des adresses IP et d'éviter le gaspillage.

 5. Pourquoi le nombre d'hôtes dépend-il du masque réseau ?
Le nombre d'hôtes dépend du masque car le masque définit combien de bits sont réservés au réseau et combien restent pour les hôtes. La formule est 2^(32-CIDR) - 2. Plus le masque est grand, moins il y a de bits pour les hôtes, donc moins d'hôtes possibles. On retire 2 pour l'adresse réseau et l'adresse de broadcast.

 6. Pourquoi certaines adresses IP sont-elles privées ?
Certaines adresses IP sont privées pour permettre aux réseaux internes (domestiques, entreprises) de fonctionner sans occuper des adresses publiques uniques sur Internet. Les plages privées (10.x.x.x, 172.16-31.x.x, 192.168.x.x) peuvent être réutilisées dans différents réseaux locaux, protégées par NAT pour accéder à Internet.

 7. Pourquoi la séparation entre logique métier et logique de calcul améliore-t-elle le projet ?
Cette séparation améliore le projet car chaque classe a une responsabilité unique. Les classes AdresseIP, Equipement, InfrastructureReseau gèrent les données métier tandis que CalculateurReseau gère uniquement les calculs. Cela rend le code plus lisible, plus facile à maintenir et à tester, et permet de modifier les calculs sans toucher aux classes métier.

8. Pourquoi les outils de planification réseau doivent-ils automatiser les calculs ?
Les outils de planification réseau doivent automatiser les calculs pour éviter les erreurs humaines lors de la configuration manuelle, gagner du temps sur les tâches répétitives, garantir la cohérence des adresses attribuées, détecter automatiquement les conflits d'adresses, et permettre de simuler rapidement différents scénarios de découpage réseau.

 Difficultés rencontrées
- Compréhension de la conversion CIDR vers masque décimal : construction d'une chaîne binaire de 32 bits puis découpage en 4 octets
- Calcul du nombre d'hôtes avec la formule 2^(32-CIDR) - 2 et gestion des cas particuliers /31 et /32
- Détection des plages privées avec vérification sur deux octets pour la plage 172.16/12
- Gestion des erreurs de parsing d'adresses IP avec split("\\.") et try-catch
- Appel des méthodes statiques sans avoir besoin d'instancier la classe CalculateurReseau
- Compréhension que les classes réseau (A, B, C) sont déterminées uniquement par le premier octet