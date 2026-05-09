/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("===== IPPlan-Manager : TP8 - Recommandations =====");
        System.out.println();
        
        System.out.println("==============================================");
        System.out.println("        SCENARIO 1 : Campus Universitaire");
        System.out.println("==============================================");
        System.out.println();
        
        ArrayList<BesoinReseau> besoins1 = new ArrayList<>();
        besoins1.add(new BesoinReseau("ETUDIANTS", 500));
        besoins1.add(new BesoinReseau("WIFI_INVITES", 200));
        besoins1.add(new BesoinReseau("ENSEIGNANTS", 120));
        besoins1.add(new BesoinReseau("ADMINISTRATION", 60));
        besoins1.add(new BesoinReseau("LABORATOIRES", 30));
        besoins1.add(new BesoinReseau("SERVEURS", 20));
        
        System.out.println("Besoins exprimes :");
        for (BesoinReseau besoin : besoins1) {
            besoin.afficher();
        }
        
        MoteurVLSM moteurVLSM1 = new MoteurVLSM();
        ArrayList<ResultatVLSM> resultats1 = null;
        try {
            resultats1 = moteurVLSM1.genererPlan("10.10.0.0", besoins1);
        } catch (ReseauInsuffisantException e) {
            System.out.println("Erreur : " + e.getMessage());
            resultats1 = new ArrayList<>();
        }
        
        GestionnaireVLAN gestionnaireVLAN1 = new GestionnaireVLAN();
        int numeroVLAN1 = 10;
        try {
            for (ResultatVLSM resultat : resultats1) {
                VLAN vlan = new VLAN(numeroVLAN1, resultat.getNomBesoin(), resultat, "VLAN " + resultat.getNomBesoin());
                gestionnaireVLAN1.ajouterVLAN(vlan);
                numeroVLAN1 += 10;
            }
        } catch (ConflitVLANException e) {
            System.out.println("Erreur VLAN : " + e.getMessage());
        }
        
        System.out.println();
        System.out.println("Plan VLAN genere :");
        gestionnaireVLAN1.afficherTousLesVLANs();
        
        MoteurRecommandation moteurRecommandation1 = new MoteurRecommandation();
        moteurRecommandation1.ajouterRegle(new RecommandationGrandVLAN());
        moteurRecommandation1.ajouterRegle(new RecommandationWifiInvite());
        moteurRecommandation1.ajouterRegle(new RecommandationServeurs());
        moteurRecommandation1.ajouterRegle(new RecommandationAdministration());
        moteurRecommandation1.ajouterRegle(new RecommandationMargeAdresse());
        
        ArrayList<Recommandation> recommandations1 = moteurRecommandation1.analyserVLANs(gestionnaireVLAN1.getVlans());
        
        System.out.println();
        System.out.println("Recommandations proposees :");
        moteurRecommandation1.afficherRecommandations(recommandations1);
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("    SCENARIO 2 : Nouveau Scenario de Test");
        System.out.println("==============================================");
        System.out.println();
        
        ArrayList<BesoinReseau> besoins2 = new ArrayList<>();
        besoins2.add(new BesoinReseau("ADMINISTRATION", 50));
        besoins2.add(new BesoinReseau("WIFI_INVITES", 120));
        besoins2.add(new BesoinReseau("SERVEURS", 20));
        besoins2.add(new BesoinReseau("CAMERAS", 80));
        besoins2.add(new BesoinReseau("VOIP", 60));
        
        System.out.println("Besoins exprimes :");
        for (BesoinReseau besoin : besoins2) {
            besoin.afficher();
        }
        
        MoteurVLSM moteurVLSM2 = new MoteurVLSM();
        ArrayList<ResultatVLSM> resultats2 = null;
        try {
            resultats2 = moteurVLSM2.genererPlan("192.168.1.0", besoins2);
        } catch (ReseauInsuffisantException e) {
            System.out.println("Erreur : " + e.getMessage());
            resultats2 = new ArrayList<>();
        }
        
        GestionnaireVLAN gestionnaireVLAN2 = new GestionnaireVLAN();
        int numeroVLAN2 = 10;
        try {
            for (ResultatVLSM resultat : resultats2) {
                VLAN vlan = new VLAN(numeroVLAN2, resultat.getNomBesoin(), resultat, "VLAN " + resultat.getNomBesoin());
                gestionnaireVLAN2.ajouterVLAN(vlan);
                numeroVLAN2 += 10;
            }
        } catch (ConflitVLANException e) {
            System.out.println("Erreur VLAN : " + e.getMessage());
        }
        
        System.out.println();
        System.out.println("Plan VLAN genere :");
        gestionnaireVLAN2.afficherTousLesVLANs();
        
        MoteurRecommandation moteurRecommandation2 = new MoteurRecommandation();
        moteurRecommandation2.ajouterRegle(new RecommandationWifiInvite());
        moteurRecommandation2.ajouterRegle(new RecommandationServeurs());
        moteurRecommandation2.ajouterRegle(new RecommandationGrandVLAN());
        moteurRecommandation2.ajouterRegle(new RecommandationAdministration());
        moteurRecommandation2.ajouterRegle(new RecommandationMargeAdresse());
        
        ArrayList<Recommandation> recommandations2 = moteurRecommandation2.analyserVLANs(gestionnaireVLAN2.getVlans());
        
        System.out.println();
        System.out.println("Recommandations proposees :");
        moteurRecommandation2.afficherRecommandations(recommandations2);
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("          COMPARAISON DES SCENARIOS");
        System.out.println("==============================================");
        System.out.println();
        System.out.println("Scenario 1 (Campus) :");
        System.out.println("  - Nombre de VLANs : " + gestionnaireVLAN1.getNombreVLANs());
        System.out.println("  - Nombre de recommandations : " + recommandations1.size());
        System.out.println();
        System.out.println("Scenario 2 (Test) :");
        System.out.println("  - Nombre de VLANs : " + gestionnaireVLAN2.getNombreVLANs());
        System.out.println("  - Nombre de recommandations : " + recommandations2.size());
        System.out.println();
        System.out.println("Analyse :");
        System.out.println("  - La regle MargeAdresse detecte les VLANs avec une marge trop faible.");
        System.out.println("  - Les VLANs avec seulement 6 hotes de marge (126 pour 120) sont identifies.");
        System.out.println("  - Cela permet d'anticiper les evolutions futures du reseau.");
    }
}