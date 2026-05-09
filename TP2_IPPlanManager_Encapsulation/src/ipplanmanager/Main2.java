/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author b.arnauld
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println("===== TP2 : Encapsulation =====");
        System.out.println();
        AdresseIP ip1 = new AdresseIP("192.168.1.1");
        AdresseIP ip2 = new AdresseIP("");
        AdresseIP ip3 = new AdresseIP(null);
        AdresseIP ip4 = new AdresseIP("10.0.0.1");
        AdresseIP ip5 = new AdresseIP("172.16.0.254");        
        InterfaceReseau interface1 = new InterfaceReseau("eth0", ip1);
        InterfaceReseau interface2 = new InterfaceReseau("", ip2);
        InterfaceReseau interface3 = new InterfaceReseau("wlan0", ip4);
        InterfaceReseau interface4 = new InterfaceReseau("eth1", ip5);       
        interface1.activer();
        interface3.activer();        
        Equipement routeur = new Equipement("R1_EDGE", "Routeur", interface1);
        Equipement serveur = new Equipement("", "", interface2);
        Equipement posteTravail = new Equipement("PC01", "Poste de travail", interface3);
        Equipement imprimante = new Equipement("IMP01", "Imprimante", interface4);
        Equipement switchReseau = new Equipement(null, null, null);       
        ReseauIP reseau1 = new ReseauIP("192.168.1.0", 24, "Réseau principal");
        ReseauIP reseau2 = new ReseauIP("", 55, "");
        ReseauIP reseau3 = new ReseauIP("10.0.0.0", 16, "Réseau secondaire");
        ReseauIP reseau4 = new ReseauIP("172.16.0.0", -5, null);        
        System.out.println();
        System.out.println("----- Réseau 1 -----");
        reseau1.afficher();
        System.out.println();
        System.out.println("----- Réseau 2 -----");
        reseau2.afficher();
        System.out.println();
        System.out.println("----- Réseau 3 -----");
        reseau3.afficher();
        System.out.println();
        System.out.println("----- Réseau 4 -----");
        reseau4.afficher();       
        System.out.println();
        System.out.println("----- Équipement 1 -----");
        routeur.afficher();
        System.out.println();
        System.out.println("----- Équipement 2 -----");
        serveur.afficher();
        System.out.println();
        System.out.println("----- Équipement 3 -----");
        posteTravail.afficher();
        System.out.println();
        System.out.println("----- Équipement 4 -----");
        imprimante.afficher();
        System.out.println();
        System.out.println("----- Équipement 5 -----");
        switchReseau.afficher();       
        System.out.println();
        System.out.println("===== Test des setters =====");
        System.out.println();        
        System.out.println("Modification de l'adresse IP de ip2 :");
        System.out.print("Avant : ");
        ip2.afficher();
        ip2.setValeur("192.168.1.100");
        System.out.print("Après modification valide : ");
        ip2.afficher();
        ip2.setValeur("");
        System.out.print("Après modification invalide : ");
        ip2.afficher();        
        System.out.println();
        System.out.println("Modification de l'équipement 2 :");
        System.out.print("Avant : ");
        serveur.afficher();
        serveur.setNom("SRV_WEB");
        serveur.setType("Serveur Web");
        System.out.println("Après modification :");
        serveur.afficher();
        System.out.println();
        System.out.println("Modification du réseau 2 :");
        System.out.println("Avant :");
        reseau2.afficher();
        reseau2.setAdresseReseau("192.168.2.0");       
        reseau2.setDescription("Réseau modifié");
        System.out.println("Après modification :");
        reseau2.afficher();       
        System.out.println();
        System.out.println("Test activation/désactivation :");
        interface2.activer();
        interface1.desactiver();
        System.out.println();
        System.out.println("État des interfaces :");
        interface1.afficher();
        interface2.afficher();
        interface3.afficher();
        interface4.afficher();
    }
}

