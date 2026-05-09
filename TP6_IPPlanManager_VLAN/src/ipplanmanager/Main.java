/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println("===== IPPlan-Manager : TP6 - VLANs =====");
        System.out.println();
        
        System.out.println("==============================================");
        System.out.println("       SCÉNARIO 1 : Moyenne Entreprise");
        System.out.println("==============================================");
        System.out.println();
        
        ArrayList<BesoinReseau> besoins1 = new ArrayList<>();
        besoins1.add(new BesoinReseau("TECHNIQUE", 120));
        besoins1.add(new BesoinReseau("WIFI", 80));
        besoins1.add(new BesoinReseau("ADMINISTRATION", 50));
        besoins1.add(new BesoinReseau("SERVEURS", 20));
        
        MoteurVLSM moteur1 = new MoteurVLSM();
        ArrayList<ResultatVLSM> resultats1 = moteur1.genererPlan("192.168.1.0", besoins1);
        
        GestionnaireVLAN gestionnaire1 = new GestionnaireVLAN();
        int numeroVLAN1 = 10;
        for (ResultatVLSM resultat : resultats1) {
            VLAN vlan = new VLAN(
                numeroVLAN1,
                resultat.getNomBesoin(),
                resultat,
                "VLAN du service " + resultat.getNomBesoin()
            );
            gestionnaire1.ajouterVLAN(vlan);
            numeroVLAN1 += 10;
        }
        
        System.out.println("Besoins exprimés :");
        for (BesoinReseau besoin : besoins1) {
            besoin.afficher();
        }
        
        System.out.println();
        System.out.println("===== VLANS GÉNÉRÉS =====");
        gestionnaire1.afficherTousLesVLANs();
        
        System.out.println();
        System.out.println("Nombre total de VLANs : " + gestionnaire1.getNombreVLANs());
        
        System.out.println();
        System.out.println("===== VLANS CONTENANT PLUS DE 100 HÔTES =====");
        gestionnaire1.afficherVLANsPlusDe100Hotes();
        
        System.out.println();
        System.out.println("===== VLAN AVEC LA PLUS GRANDE CAPACITÉ =====");
        VLAN vlanMax1 = gestionnaire1.getVLANPlusGrandeCapacite();
        if (vlanMax1 != null) {
            vlanMax1.afficher();
        }
        
        System.out.println();
        System.out.println("===== TEST DE RECHERCHE VLAN =====");
        VLAN vlanRecherche1 = gestionnaire1.rechercherVLAN(20);
        if (vlanRecherche1 != null) {
            System.out.print("VLAN 20 trouvé : ");
            vlanRecherche1.afficher();
        } else {
            System.out.println("VLAN 20 introuvable.");
        }
        VLAN vlanRecherche99 = gestionnaire1.rechercherVLAN(99);
        if (vlanRecherche99 != null) {
            System.out.print("VLAN 99 trouvé : ");
            vlanRecherche99.afficher();
        } else {
            System.out.println("VLAN 99 introuvable.");
        }
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("           SCÉNARIO 2 : Université");
        System.out.println("==============================================");
        System.out.println();
        
        ArrayList<BesoinReseau> besoins2 = new ArrayList<>();
        besoins2.add(new BesoinReseau("ETUDIANTS", 500));
        besoins2.add(new BesoinReseau("ENSEIGNANTS", 120));
        besoins2.add(new BesoinReseau("LABORATOIRES", 60));
        besoins2.add(new BesoinReseau("WIFI_PUBLIC", 200));
        besoins2.add(new BesoinReseau("SERVEURS", 30));
        
        MoteurVLSM moteur2 = new MoteurVLSM();
        ArrayList<ResultatVLSM> resultats2 = moteur2.genererPlan("10.0.0.0", besoins2);
        
        GestionnaireVLAN gestionnaire2 = new GestionnaireVLAN();
        int numeroVLAN2 = 100;
        for (ResultatVLSM resultat : resultats2) {
            VLAN vlan = new VLAN(
                numeroVLAN2,
                resultat.getNomBesoin(),
                resultat,
                "VLAN du service " + resultat.getNomBesoin()
            );
            gestionnaire2.ajouterVLAN(vlan);
            numeroVLAN2 += 10;
        }
        
        System.out.println("Besoins exprimés :");
        for (BesoinReseau besoin : besoins2) {
            besoin.afficher();
        }
        
        System.out.println();
        System.out.println("===== VLANS GÉNÉRÉS =====");
        gestionnaire2.afficherTousLesVLANs();
        
        System.out.println();
        System.out.println("Nombre total de VLANs : " + gestionnaire2.getNombreVLANs());
        
        System.out.println();
        System.out.println("===== VLANS CONTENANT PLUS DE 100 HÔTES =====");
        gestionnaire2.afficherVLANsPlusDe100Hotes();
        
        System.out.println();
        System.out.println("===== VLAN AVEC LA PLUS GRANDE CAPACITÉ =====");
        VLAN vlanMax2 = gestionnaire2.getVLANPlusGrandeCapacite();
        if (vlanMax2 != null) {
            vlanMax2.afficher();
        }
        
        System.out.println();
        System.out.println("===== TEST DE RECHERCHE VLAN =====");
        VLAN vlanRecherche110 = gestionnaire2.rechercherVLAN(110);
        if (vlanRecherche110 != null) {
            System.out.print("VLAN 110 trouvé : ");
            vlanRecherche110.afficher();
        } else {
            System.out.println("VLAN 110 introuvable.");
        }
        VLAN vlanRecherche200 = gestionnaire2.rechercherVLAN(200);
        if (vlanRecherche200 != null) {
            System.out.print("VLAN 200 trouvé : ");
            vlanRecherche200.afficher();
        } else {
            System.out.println("VLAN 200 introuvable.");
        }
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("          COMPARAISON DES SCÉNARIOS");
        System.out.println("==============================================");
        System.out.println();
        System.out.println("Scénario 1 - Moyenne Entreprise :");
        System.out.println("  - Adresse de base : 192.168.1.0");
        System.out.println("  - Nombre de VLANs : " + gestionnaire1.getNombreVLANs());
        System.out.println("  - Numéros VLAN : 10, 20, 30, 40");
        System.out.println();
        System.out.println("Scénario 2 - Université :");
        System.out.println("  - Adresse de base : 10.0.0.0");
        System.out.println("  - Nombre de VLANs : " + gestionnaire2.getNombreVLANs());
        System.out.println("  - Numéros VLAN : 100, 110, 120, 130, 140");
        System.out.println();
        System.out.println("Analyse :");
        System.out.println("  - Le scénario Université nécessite des plages");
        System.out.println("    d'adresses plus grandes (/23, /24).");
        System.out.println("  - Les VLANs sont correctement isolés avec des");
        System.out.println("    numéros distincts pour chaque service.");
        System.out.println("  - La segmentation VLAN suit la structure");
        System.out.println("    organisationnelle de chaque entité.");
    }
}
