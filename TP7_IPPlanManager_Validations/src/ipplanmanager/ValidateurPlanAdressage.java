/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

import java.util.ArrayList;

public class ValidateurPlanAdressage {
    
    public void verifierAdresses(ArrayList<ResultatVLSM> resultats) throws AdresseIPInvalideException {
        for (ResultatVLSM resultat : resultats) {
            if (resultat.getAdresseReseau() == null || resultat.getAdresseReseau().isEmpty()) {
                throw new AdresseIPInvalideException("Adresse réseau invalide pour " + resultat.getNomBesoin());
            }
            if (resultat.getAdresseReseau().equals("0.0.0.0")) {
                throw new AdresseIPInvalideException("Adresse réseau par défaut détectée pour " + resultat.getNomBesoin());
            }
        }
    }
    
    public void verifierChevauchements(ArrayList<ResultatVLSM> resultats) throws ChevauchementReseauException {
        for (int i = 0; i < resultats.size(); i++) {
            for (int j = i + 1; j < resultats.size(); j++) {
                ResultatVLSM r1 = resultats.get(i);
                ResultatVLSM r2 = resultats.get(j);
                if (chevauchement(r1, r2)) {
                    throw new ChevauchementReseauException("Chevauchement détecté entre " + r1.getNomBesoin() + " et " + r2.getNomBesoin());
                }
            }
        }
    }
    
    private boolean chevauchement(ResultatVLSM r1, ResultatVLSM r2) {
        long debut1 = ipVersLong(r1.getAdresseReseau());
        long fin1 = debut1 + (long) Math.pow(2, (32 - r1.getCidr())) - 1;
        long debut2 = ipVersLong(r2.getAdresseReseau());
        long fin2 = debut2 + (long) Math.pow(2, (32 - r2.getCidr())) - 1;
        
        return !(fin1 < debut2 || fin2 < debut1);
    }
    
    private long ipVersLong(String adresseIP) {
        String[] parties = adresseIP.split("\\.");
        long octet1 = Long.parseLong(parties[0]);
        long octet2 = Long.parseLong(parties[1]);
        long octet3 = Long.parseLong(parties[2]);
        long octet4 = Long.parseLong(parties[3]);
        
        return (octet1 << 24) | (octet2 << 16) | (octet3 << 8) | octet4;
    }
    
    public void afficherValidationReussie() {
        System.out.println("Validation réussie : aucune erreur détectée.");
    }
}