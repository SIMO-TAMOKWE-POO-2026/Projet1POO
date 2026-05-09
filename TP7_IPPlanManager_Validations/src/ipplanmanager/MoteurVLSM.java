/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MoteurVLSM {
    
    public ArrayList<ResultatVLSM> genererPlan(String adresseDepart, ArrayList<BesoinReseau> besoins) throws ReseauInsuffisantException {
        
        int sommeBesoins = 0;
        for (BesoinReseau besoin : besoins) {
            sommeBesoins = sommeBesoins + besoin.getNombreHotes();
        }
        
        int capaciteTotale = (int) Math.pow(2, 24) - 2;
        String[] parties = adresseDepart.split("/");
        if (parties.length == 2) {
            try {
                int cidrBase = Integer.parseInt(parties[1]);
                capaciteTotale = (int) Math.pow(2, (32 - cidrBase)) - 2;
            } catch (NumberFormatException e) {
                capaciteTotale = (int) Math.pow(2, 24) - 2;
            }
        }
        
        if (sommeBesoins > capaciteTotale) {
            throw new ReseauInsuffisantException(
                "Le reseau de depart est insuffisant ! " +
                "Capacite du reseau : " + capaciteTotale + " hotes, " +
                "Besoins cumules : " + sommeBesoins + " hotes."
            );
        }
        
        ArrayList<ResultatVLSM> resultats = new ArrayList<>();
        
        Collections.sort(besoins, new Comparator<BesoinReseau>() {
            @Override
            public int compare(BesoinReseau b1, BesoinReseau b2) {
                return b2.getNombreHotes() - b1.getNombreHotes();
            }
        });
        
        String adresseSansCIDR = adresseDepart.split("/")[0];
        int adresseCourante = CalculateurReseau.convertirIpEnEntier(adresseSansCIDR);
        
        for (BesoinReseau besoin : besoins) {
            int cidr = CalculateurReseau.calculerCidrPourHotes(besoin.getNombreHotes());
            int capacite = CalculateurReseau.calculerNombreHotes(cidr);
            String masque = CalculateurReseau.obtenirMasqueDecimal(cidr);
            String adresseReseau = CalculateurReseau.convertirEntierEnIp(adresseCourante);
            
            ResultatVLSM resultat = new ResultatVLSM(besoin.getNom(), adresseReseau, cidr, masque, capacite);
            resultats.add(resultat);
            
            int tailleBloc = CalculateurReseau.calculerTailleBloc(cidr);
            adresseCourante = adresseCourante + tailleBloc;
        }
        
        return resultats;
    }
}