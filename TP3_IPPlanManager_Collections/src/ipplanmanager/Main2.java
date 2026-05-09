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
        AdresseIP ip4 = new AdresseIP("192.168.1.254");
        AdresseIP ip5 = new AdresseIP("10.0.0.1");
        AdresseIP ip6 = new AdresseIP("10.0.0.2");
        AdresseIP ip7 = new AdresseIP("172.16.0.1");
        AdresseIP ip8 = new AdresseIP("172.16.0.2");
        AdresseIP ip9 = new AdresseIP("192.168.2.1");
        AdresseIP ip10 = new AdresseIP("192.168.2.2");
        AdresseIP ip11 = new AdresseIP("10.0.1.1");
        AdresseIP ip12 = new AdresseIP("10.0.1.2");
        
        InterfaceReseau intRouteur1 = new InterfaceReseau("eth0", ip1);
        InterfaceReseau intRouteur2 = new InterfaceReseau("eth1", ip5);
        InterfaceReseau intRouteur3 = new InterfaceReseau("eth2", ip7);
        
        InterfaceReseau intServeur1 = new InterfaceReseau("eth0", ip4);
        InterfaceReseau intServeur2 = new InterfaceReseau("eth1", ip6);
        
        InterfaceReseau intSwitch1 = new InterfaceReseau("eth0", ip9);
        InterfaceReseau intSwitch2 = new InterfaceReseau("eth1", ip10);
        InterfaceReseau intSwitch3 = new InterfaceReseau("eth2", ip11);
        
        InterfaceReseau intPC1 = new InterfaceReseau("eth0", ip8);
        InterfaceReseau intPC2 = new InterfaceReseau("wlan0", ip12);
        
        InterfaceReseau intImprimante1 = new InterfaceReseau("eth0", new AdresseIP("192.168.1.100"));
        
        InterfaceReseau intAP1 = new InterfaceReseau("eth0", new AdresseIP("192.168.1.200"));
        InterfaceReseau intAP2 = new InterfaceReseau("wlan0", new AdresseIP("192.168.3.1"));
        
        InterfaceReseau intCam1 = new InterfaceReseau("eth0", new AdresseIP("192.168.1.150"));
        
        intRouteur1.activer();
        intRouteur2.activer();
        intRouteur3.activer();
        intServeur1.activer();
        intServeur2.activer();
        intSwitch1.activer();
        intSwitch2.activer();
        intSwitch3.activer();
        intPC2.activer();
        intAP2.activer();
        
        Equipement routeur = new Equipement("R1_EDGE", "Routeur");
        routeur.ajouterInterface(intRouteur1);
        routeur.ajouterInterface(intRouteur2);
        routeur.ajouterInterface(intRouteur3);
        
        Equipement serveur = new Equipement("SRV_WEB", "Serveur");
        serveur.ajouterInterface(intServeur1);
        serveur.ajouterInterface(intServeur2);
        
        Equipement switchEquip = new Equipement("SW_CORE", "Switch");
        switchEquip.ajouterInterface(intSwitch1);
        switchEquip.ajouterInterface(intSwitch2);
        switchEquip.ajouterInterface(intSwitch3);
        
        Equipement pcFixe = new Equipement("PC_FIXE_01", "Poste de travail fixe");
        pcFixe.ajouterInterface(intPC1);
        
        Equipement pcPortable = new Equipement("PC_PORTABLE_01", "Poste de travail portable");
        pcPortable.ajouterInterface(intPC2);
        
        Equipement imprimante = new Equipement("IMP_RESEAU", "Imprimante réseau");
        imprimante.ajouterInterface(intImprimante1);
        
        Equipement pointAcces = new Equipement("AP_WIFI_01", "Point d'accès WiFi");
        pointAcces.ajouterInterface(intAP1);
        pointAcces.ajouterInterface(intAP2);
        
        Equipement camera = new Equipement("CAM_SURV_01", "Caméra de surveillance");
        camera.ajouterInterface(intCam1);
        
        Equipement equipInvalide = new Equipement("", "");
        
        ReseauIP reseau1 = new ReseauIP("192.168.1.0", 24, "Réseau principal - Siège");
        ReseauIP reseau2 = new ReseauIP("", 55, "");
        ReseauIP reseau3 = new ReseauIP("10.0.0.0", 16, "Réseau secondaire - Étages");
        ReseauIP reseau4 = new ReseauIP("172.16.0.0", -5, null);
        ReseauIP reseau5 = new ReseauIP("192.168.2.0", 24, "Troisième sous-réseau - Direction");
        ReseauIP reseau6 = new ReseauIP("192.168.3.0", 24, "Sous-réseau WiFi - Invités");
        
        SousReseau sr1 = new SousReseau("SR-Principal", reseau1);
        SousReseau sr2 = new SousReseau("", reseau2);
        SousReseau sr3 = new SousReseau("SR-Secondaire", reseau3);
        SousReseau sr4 = new SousReseau("SR-Direction", reseau5);
        SousReseau sr5 = new SousReseau("SR-WiFi", reseau6);
        
        InfrastructureReseau infra = new InfrastructureReseau("Infra_Entreprise_XYZ");
        infra.ajouterSousReseau(sr1);
        infra.ajouterSousReseau(sr2);
        infra.ajouterSousReseau(sr3);
        infra.ajouterSousReseau(sr4);
        infra.ajouterSousReseau(sr5);
        
        infra.ajouterEquipement(routeur);
        infra.ajouterEquipement(serveur);
        infra.ajouterEquipement(switchEquip);
        infra.ajouterEquipement(pcFixe);
        infra.ajouterEquipement(pcPortable);
        infra.ajouterEquipement(imprimante);
        infra.ajouterEquipement(pointAcces);
        infra.ajouterEquipement(camera);
        infra.ajouterEquipement(equipInvalide);
        
        infra.afficher();
        
        System.out.println();
        System.out.println("===== Test estAdresseLocale =====");
     
        System.out.println();
        System.out.println("===== Test des setters =====");
        System.out.println();
        
        System.out.println("Modification adresse IP de ip2 :");
        System.out.print("Avant : ");
        ip2.afficher();
      
        System.out.print("Après modification valide : ");
        ip2.afficher();
       
        System.out.print("Après modification invalide : ");
        ip2.afficher();
        
        System.out.println();
        System.out.println("Modification du switch :");
        switchEquip.setNom("SW_DISTRIBUTION");
        switchEquip.setType("Switch de distribution");
        switchEquip.afficher();
        
        System.out.println();
        System.out.println("Modification du sous-réseau WiFi :");
        sr5.setNom("SR-WiFi-Corporate");
       
        sr5.afficher();
        
        System.out.println();
        System.out.println("===== Test activation/désactivation =====");
        intServeur1.desactiver();
        intPC1.activer();
        System.out.println();
        System.out.println("État des interfaces du serveur :");
        serveur.afficherInterfaces();
        System.out.println();
        System.out.println("État des interfaces du PC fixe :");
        pcFixe.afficherInterfaces();
    }
}   

