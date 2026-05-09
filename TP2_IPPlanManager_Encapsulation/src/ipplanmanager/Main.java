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
System.out.println("===== TP2 : Encapsulation =====");
AdresseIP ip1 = new AdresseIP("192.168.1.1");
AdresseIP ip2 = new AdresseIP("");
AdresseIP ip3 = new AdresseIP(null);
InterfaceReseau interface1 = new InterfaceReseau("eth0", ip1);
InterfaceReseau interface2 = new InterfaceReseau("", ip2);
interface1.activer();
Equipement routeur = new Equipement(
"R1_EDGE",
"Routeur",
interface1
);
Equipement serveur =
new Equipement(
""
        ,"",
interface2
);
ReseauIP reseau1 =
new ReseauIP(
"192.168.1.0",
24,
"Réseau principal"
);
ReseauIP reseau2 =
new ReseauIP(
"",
55,
""
);
System.out.println();
System.out.println("----- Réseau 1 -----");
reseau1.afficher();
}
}

