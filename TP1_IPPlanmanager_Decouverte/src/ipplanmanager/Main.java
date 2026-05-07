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
System.out.println("===== IPPlan-Manager : TP1 =====");
System.out.println();
AdresseIP ipRouteur = new AdresseIP("192.168.1.1");
AdresseIP ipServeur = new AdresseIP("192.168.1.10");
AdresseIP ipClient = new AdresseIP("192.168.1.50");
InterfaceReseau interfaceRouteur = new InterfaceReseau("eth0",
ipRouteur);
InterfaceReseau interfaceServeur = new InterfaceReseau("eth0",
ipServeur);
InterfaceReseau interfaceClient = new InterfaceReseau("wlan0",
ipClient);
interfaceRouteur.activer();
interfaceServeur.activer();
Equipement routeur = new Equipement("R1_EDGE", "Routeur",
interfaceRouteur);
Equipement serveur = new Equipement("SRV_DNS", "Serveur",
interfaceServeur);
Equipement client = new Equipement("PC_ADMIN", "Poste client",
interfaceClient);
ReseauIP reseauPrincipal = new ReseauIP(
"192.168.1.0",
24,
"Réseau principal du laboratoire IRT"
);
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
    }
}
