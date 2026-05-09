/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

import java.util.ArrayList;
public class Main2 {
    public static void main(String[] args) {
        System.out.println("===== IPPlan-Manager : TP5 - Moteur VLSM =====");
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
        besoins1.add(new BesoinReseau("DIRECTION", 10));
        
        System.out.println("Besoins exprimés par l'utilisateur :");
        for (BesoinReseau besoin : besoins1) {
            besoin.afficher();
        }
        
        MoteurVLSM moteur1 = new MoteurVLSM();
        ArrayList<ResultatVLSM> resultats1 = moteur1.genererPlan("192.168.1.0", besoins1);
        
        System.out.println();
        System.out.println("Plan d'adressage proposé :");
        for (ResultatVLSM resultat : resultats1) {
            resultat.afficher();
        }
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("         SCÉNARIO 2 : Petite Entreprise");
        System.out.println("==============================================");
        System.out.println();
        
        ArrayList<BesoinReseau> besoins2 = new ArrayList<>();
        besoins2.add(new BesoinReseau("ADMIN", 25));
        besoins2.add(new BesoinReseau("COMPTABILITE", 12));
        besoins2.add(new BesoinReseau("WIFI_INVITES", 40));
        besoins2.add(new BesoinReseau("SERVEURS", 8));
        
        System.out.println("Besoins exprimés par l'utilisateur :");
        for (BesoinReseau besoin : besoins2) {
            besoin.afficher();
        }
        
        MoteurVLSM moteur2 = new MoteurVLSM();
        ArrayList<ResultatVLSM> resultats2 = moteur2.genererPlan("10.0.0.0", besoins2);
        
        System.out.println();
        System.out.println("Plan d'adressage proposé :");
        for (ResultatVLSM resultat : resultats2) {
            resultat.afficher();
        }
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("           SCÉNARIO 3 : Campus");
        System.out.println("==============================================");
        System.out.println();
        
        ArrayList<BesoinReseau> besoins3 = new ArrayList<>();
        besoins3.add(new BesoinReseau("ETUDIANTS", 500));
        besoins3.add(new BesoinReseau("PERSONNEL", 120));
        besoins3.add(new BesoinReseau("LABORATOIRE", 60));
        besoins3.add(new BesoinReseau("ADMINISTRATION", 40));
        besoins3.add(new BesoinReseau("WIFI_PUBLIC", 200));
        
        System.out.println("Besoins exprimés par l'utilisateur :");
        for (BesoinReseau besoin : besoins3) {
            besoin.afficher();
        }
        
        MoteurVLSM moteur3 = new MoteurVLSM();
        ArrayList<ResultatVLSM> resultats3 = moteur3.genererPlan("172.16.0.0", besoins3);
        
        System.out.println();
        System.out.println("Plan d'adressage proposé :");
        for (ResultatVLSM resultat : resultats3) {
            resultat.afficher();
        }
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("          COMPARAISON DES SCÉNARIOS");
        System.out.println("==============================================");
        System.out.println();
        System.out.println("Scénario 1 (Moyenne Entreprise) :");
        System.out.println("  - Adresse de base : 192.168.1.0");
        System.out.println("  - Nombre de sous-réseaux : " + resultats1.size());
        System.out.println("  - Plage d'adresses : privée (192.168.x.x)");
        System.out.println();
        System.out.println("Scénario 2 (Petite Entreprise) :");
        System.out.println("  - Adresse de base : 10.0.0.0");
        System.out.println("  - Nombre de sous-réseaux : " + resultats2.size());
        System.out.println("  - Plage d'adresses : privée (10.x.x.x)");
        System.out.println();
        System.out.println("Scénario 3 (Campus) :");
        System.out.println("  - Adresse de base : 172.16.0.0");
        System.out.println("  - Nombre de sous-réseaux : " + resultats3.size());
        System.out.println("  - Plage d'adresses : privée (172.16.x.x)");
        System.out.println();
        System.out.println("Analyse :");
        System.out.println("  - Le scénario 3 utilise des CIDR plus petits (/23)");
        System.out.println("    à cause du grand nombre d'hôtes nécessaires.");
        System.out.println("  - Les scénarios 1 et 2 utilisent des CIDR plus");
        System.out.println("    grands (/24, /25, /26) adaptés à leurs besoins.");
        System.out.println("  - Le VLSM optimise l'espace d'adressage en");
        System.out.println("    attribuant le masque le plus adapté à chaque besoin.");
    }
} 

