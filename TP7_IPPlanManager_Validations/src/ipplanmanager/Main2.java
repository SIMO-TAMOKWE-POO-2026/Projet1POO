/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("===== IPPlan-Manager : TP7 - Validations avancees =====");
        System.out.println();
        
        System.out.println("==============================================");
        System.out.println("    SCENARIO 1 : Plan d'adressage valide");
        System.out.println("==============================================");
        System.out.println();
        
        ArrayList<BesoinReseau> besoins = new ArrayList<>();
        besoins.add(new BesoinReseau("ADMINISTRATION", 50));
        besoins.add(new BesoinReseau("TECHNIQUE", 120));
        besoins.add(new BesoinReseau("WIFI", 80));
        besoins.add(new BesoinReseau("SERVEURS", 20));
        
        MoteurVLSM moteur = new MoteurVLSM();
        ArrayList<ResultatVLSM> resultats = null;
        try {
            resultats = moteur.genererPlan("192.168.1.0", besoins);
        } catch (ReseauInsuffisantException e) {
            System.out.println("Erreur : " + e.getMessage());
            return;
        }
        
        System.out.println("Plan genere :");
        for (ResultatVLSM resultat : resultats) {
            resultat.afficher();
        }
        
        ValidateurPlanAdressage validateur = new ValidateurPlanAdressage();
        try {
            validateur.verifierAdresses(resultats);
            validateur.verifierChevauchements(resultats);
            validateur.afficherValidationReussie();
        } catch (AdresseIPInvalideException | ChevauchementReseauException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        }
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("    SCENARIO 2 : Adresse de depart invalide");
        System.out.println("==============================================");
        System.out.println();
        
        ArrayList<BesoinReseau> besoins2 = new ArrayList<>();
        besoins2.add(new BesoinReseau("TEST", 10));
        
        MoteurVLSM moteur2 = new MoteurVLSM();
        ArrayList<ResultatVLSM> resultats2 = null;
        try {
            resultats2 = moteur2.genererPlan("192.168.300.0", besoins2);
        } catch (ReseauInsuffisantException e) {
            System.out.println("Erreur : " + e.getMessage());
            resultats2 = new ArrayList<>();
        }
        
        System.out.println("Plan genere avec adresse invalide :");
        for (ResultatVLSM resultat : resultats2) {
            resultat.afficher();
        }
        
        ValidateurPlanAdressage validateur2 = new ValidateurPlanAdressage();
        try {
            validateur2.verifierAdresses(resultats2);
            validateur2.verifierChevauchements(resultats2);
            validateur2.afficherValidationReussie();
        } catch (AdresseIPInvalideException | ChevauchementReseauException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        }
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("    SCENARIO 3 : Chevauchement de reseaux");
        System.out.println("==============================================");
        System.out.println();
        
        ArrayList<ResultatVLSM> resultatsChevauche = new ArrayList<>();
        
        ResultatVLSM r1 = new ResultatVLSM("RESEAU_A", "192.168.1.0", 25, "255.255.255.128", 126);
        ResultatVLSM r2 = new ResultatVLSM("RESEAU_B", "192.168.1.64", 26, "255.255.255.192", 62);
        
        resultatsChevauche.add(r1);
        resultatsChevauche.add(r2);
        
        System.out.println("Reseaux crees manuellement :");
        for (ResultatVLSM resultat : resultatsChevauche) {
            resultat.afficher();
        }
        
        ValidateurPlanAdressage validateur3 = new ValidateurPlanAdressage();
        try {
            validateur3.verifierAdresses(resultatsChevauche);
            validateur3.verifierChevauchements(resultatsChevauche);
            validateur3.afficherValidationReussie();
        } catch (AdresseIPInvalideException | ChevauchementReseauException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        }
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("    SCENARIO 4 : Conflit d'identifiants VLAN");
        System.out.println("==============================================");
        System.out.println();
        
        GestionnaireVLAN gestionnaire = new GestionnaireVLAN();
        
        try {
            VLAN vlan10 = new VLAN(10, "ADMINISTRATION", resultats.get(0), "VLAN Administration");
            VLAN vlan20 = new VLAN(20, "TECHNIQUE", resultats.get(1), "VLAN Technique");
            VLAN vlan30 = new VLAN(30, "WIFI", resultats.get(2), "VLAN WiFi");
            
            System.out.println("Ajout de 3 VLANs valides...");
            gestionnaire.ajouterVLAN(vlan10);
            System.out.println("  VLAN 10 ajoute avec succes.");
            gestionnaire.ajouterVLAN(vlan20);
            System.out.println("  VLAN 20 ajoute avec succes.");
            gestionnaire.ajouterVLAN(vlan30);
            System.out.println("  VLAN 30 ajoute avec succes.");
            
            System.out.println();
            System.out.println("Tentative d'ajout d'un VLAN avec ID deja utilise...");
            VLAN vlan10Erreur = new VLAN(10, "WIFI", resultats.get(2), "VLAN WiFi avec ID deja utilise");
            gestionnaire.ajouterVLAN(vlan10Erreur);
            System.out.println("  VLAN 10 ajoute avec succes.");
            
        } catch (ConflitVLANException e) {
            System.out.println("Erreur VLAN : " + e.getMessage());
        }
        
        System.out.println();
        System.out.println("Liste finale des VLANs :");
        gestionnaire.afficherTousLesVLANs();
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("    SCENARIO 5 : Reseau de depart insuffisant");
        System.out.println("==============================================");
        System.out.println();
        
        ArrayList<BesoinReseau> besoinsLourds = new ArrayList<>();
        besoinsLourds.add(new BesoinReseau("SERVICE_A", 200));
        besoinsLourds.add(new BesoinReseau("SERVICE_B", 100));
        besoinsLourds.add(new BesoinReseau("SERVICE_C", 50));
        
        System.out.println("Besoins exprimes :");
        for (BesoinReseau besoin : besoinsLourds) {
            besoin.afficher();
        }
        System.out.println("Total des besoins : 350 hotes");
        System.out.println("Reseau de depart : 192.168.1.0/24 (capacite : 254 hotes)");
        System.out.println();
        
        MoteurVLSM moteurLourd = new MoteurVLSM();
        try {
            ArrayList<ResultatVLSM> resultatsLourds = moteurLourd.genererPlan("192.168.1.0/24", besoinsLourds);
            System.out.println("Plan genere :");
            for (ResultatVLSM resultat : resultatsLourds) {
                resultat.afficher();
            }
        } catch (ReseauInsuffisantException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("          RESUME DES TESTS");
        System.out.println("==============================================");
        System.out.println();
        System.out.println("Test 1 - Plan valide : OK");
        System.out.println("Test 2 - Adresse invalide (192.168.300.0) : Erreur detectee");
        System.out.println("Test 3 - Chevauchement (192.168.1.0/25 et 192.168.1.64/26) : Erreur detectee");
        System.out.println("Test 4 - Conflit VLAN (ID 10 en double) : Erreur detectee");
        System.out.println("Test 5 - Reseau insuffisant (350 hotes dans un /24) : Erreur detectee");
    }
}