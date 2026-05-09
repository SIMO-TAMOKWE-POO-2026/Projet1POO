/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
System.out.println("===== IPPlan-Manager : TP5 - Moteur VLSM=====");
ArrayList<BesoinReseau> besoins = new ArrayList<>();
besoins.add(new BesoinReseau("TECHNIQUE", 120));
besoins.add(new BesoinReseau("WIFI", 80));
besoins.add(new BesoinReseau("ADMINISTRATION", 50));
besoins.add(new BesoinReseau("SERVEURS", 20));
besoins.add(new BesoinReseau("DIRECTION", 10));
System.out.println();
System.out.println("Besoins exprimés par l'utilisateur :");
for (BesoinReseau besoin : besoins) {
besoin.afficher();
}
MoteurVLSM moteur = new MoteurVLSM();
ArrayList<ResultatVLSM> resultats =
moteur.genererPlan("192.168.1.0", besoins);
System.out.println();
System.out.println("Plan d'adressage proposé :");
for (ResultatVLSM resultat : resultats) {
resultat.afficher();
}
    }
}
