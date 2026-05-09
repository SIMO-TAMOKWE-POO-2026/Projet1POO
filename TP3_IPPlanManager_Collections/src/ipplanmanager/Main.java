/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author b.arnauld
 */
public class Main {
 public static void main(String[] args) {
InfrastructureReseau infrastructure =
new InfrastructureReseau("Infrastructure YFY");
ReseauIP reseauAdmin =
new ReseauIP(
"192.168.1.0",
24,
"Réseau administration"
);
ReseauIP reseauTech =
new ReseauIP(
"192.168.2.0",
24,
"Réseau technique"
);
SousReseau admin =
new SousReseau(
"ADMIN",
reseauAdmin
);
SousReseau tech =
new SousReseau(
"TECH",
reseauTech
);
infrastructure.ajouterSousReseau(admin);
infrastructure.ajouterSousReseau(tech);
AdresseIP ip1 = new AdresseIP("192.168.1.1");
AdresseIP ip2 = new AdresseIP("10.0.0.1");
InterfaceReseau eth0 = new InterfaceReseau("eth0", ip1);
InterfaceReseau eth1 = new InterfaceReseau("eth1", ip2);
eth0.activer();
eth1.activer();
Equipement routeur = new Equipement(
"R1_EDGE",
"Routeur"
);
routeur.ajouterInterface(eth0);
routeur.ajouterInterface(eth1);
infrastructure.ajouterEquipement(routeur);
infrastructure.afficher();
}
}

