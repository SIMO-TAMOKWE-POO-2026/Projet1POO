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
        System.out.println("===== IPPlan-Manager : TP1 =====");
        System.out.println();
        AdresseIP ipRouteur = new AdresseIP("192.168.1.1");
        AdresseIP ipServeur = new AdresseIP("192.168.1.10");
        AdresseIP ipClient = new AdresseIP("192.168.1.50");
        InterfaceReseau interfaceRouteur = new InterfaceReseau("eth0", ipRouteur);
        InterfaceReseau interfaceServeur = new InterfaceReseau("eth0", ipServeur);
        InterfaceReseau interfaceClient = new InterfaceReseau("wlan0", ipClient);
        interfaceRouteur.activer();
        interfaceServeur.activer();
        Equipement routeur = new Equipement("R1_EDGE", "Routeur", interfaceRouteur);
        Equipement serveur = new Equipement("SRV_DNS", "Serveur", interfaceServeur);
        Equipement client = new Equipement("PC_ADMIN", "Poste client", interfaceClient);
        ReseauIP reseauPrincipal = new ReseauIP("192.168.1.0", 24, "Réseau principal du laboratoire IRT");
        System.out.println("----- Réseau créé -----");
        reseauPrincipal.afficher();
        System.out.println();
        System.out.println("----- Équipements créés -----");
        System.out.println();
        routeur.afficher();
        System.out.println();
        serveur.afficher();
        System.out.println();
        client.afficher();
        System.out.println();

        ReseauIP reseauSecondaire = new ReseauIP("10.0.2.0", 24, "Réseau secondaire");
        System.out.println("----- Nouveau réseau créé -----");
        reseauSecondaire.afficher();
        System.out.println();
        
        InterfaceReseau interfaceSwitch =new InterfaceReseau("sw0");
        interfaceSwitch.activer();
        Equipement switchEquip = new Equipement("SW_CORE", "Switch", interfaceSwitch);
        System.out.println("----- Switch -----");
        switchEquip.afficher();
        System.out.println();

        AdresseIP ipAP = new AdresseIP("10.0.2.1");
        InterfaceReseau interfaceAP = new InterfaceReseau("wlan1", ipAP);
        Equipement pointAcces = new Equipement("AP_LABO", "Point d'accès WiFi", interfaceAP);
        System.out.println("----- Point d'accès WiFi (inactif) -----");
        pointAcces.afficher();
        System.out.println();

        AdresseIP ipClient2 = new AdresseIP("10.0.2.50");
        InterfaceReseau interfaceClient2 = new InterfaceReseau("eth0", ipClient2);
        interfaceClient2.activer();
        Equipement client2 = new Equipement("PC_USER2", "Poste client supplémentaire", interfaceClient2);
        System.out.println("----- Poste client supplémentaire -----");
        client2.afficher();
        System.out.println();

        AdresseIP ipInactive = new AdresseIP("192.168.2.1");
        InterfaceReseau interfaceInactive = new InterfaceReseau("eth1", ipInactive);
        Equipement interfaceInactiveEquip = new Equipement("R1_EDGE_eth1", "Interface inactive", interfaceInactive);
        System.out.println("----- Interface inactive -----");
        interfaceInactiveEquip.afficher();
        System.out.println();

        InterfaceReseau interfaceSansIP = new InterfaceReseau("eth3", null);
interfaceSansIP.activer();
Equipement equipSansIP = new Equipement("SW_CORE_eth3", "Interface sans adresse IP", interfaceSansIP);
        interfaceSansIP.activer();
        System.out.println("----- Interface sans adresse IP (active) -----");
        equipSansIP.afficher();
    }
}