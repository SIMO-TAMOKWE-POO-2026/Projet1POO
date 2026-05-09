/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("===== IPPlan-Manager : TP7 - Validations avancées =====");
        
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
        
        System.out.println();
        System.out.println("Plan généré :");
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
        System.out.println("Test de conflit VLAN :");
        GestionnaireVLAN gestionnaire = new GestionnaireVLAN();
        try {
            VLAN vlan10 = new VLAN(10, "ADMINISTRATION", resultats.get(0), "VLAN Administration");
            VLAN vlan20 = new VLAN(20, "TECHNIQUE", resultats.get(1), "VLAN Technique");
            VLAN vlan10Erreur = new VLAN(10, "WIFI", resultats.get(2), "VLAN WiFi avec ID déjà utilisé");
            gestionnaire.ajouterVLAN(vlan10);
            gestionnaire.ajouterVLAN(vlan20);
            gestionnaire.ajouterVLAN(vlan10Erreur);
            gestionnaire.afficherTousLesVLANs();
        } catch (ConflitVLANException e) {
            System.out.println("Erreur VLAN : " + e.getMessage());
        }
    }
}