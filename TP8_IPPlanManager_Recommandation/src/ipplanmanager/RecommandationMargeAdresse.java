/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

public class RecommandationMargeAdresse extends RegleRecommandation {
    
    @Override
    public Recommandation analyser(VLAN vlan) {
        if (vlan.getResultat() != null) {
            int capacite = vlan.getResultat().getCapacite();
            
            if (capacite > 0 && capacite <= 30) {
                int besoinEstime = estimerBesoin(capacite);
                int marge = capacite - besoinEstime;
                int pourcentageMarge = (marge * 100) / capacite;
                
                if (pourcentageMarge < 20) {
                    return new Recommandation(
                        "Marge d'adresses insuffisante",
                        "MOYENNE",
                        "Le VLAN " + vlan.getNom() + " a une capacite de " + capacite + 
                        " hotes avec une marge estimee de seulement " + marge + 
                        " hotes (" + pourcentageMarge + "%). Prevoir une plage plus large si le reseau doit evoluer."
                    );
                }
            }
        }
        return null;
    }
    
    private int estimerBesoin(int capacite) {
        if (capacite == 14) return 10;
        if (capacite == 30) return 20;
        if (capacite == 62) return 50;
        if (capacite == 126) return 120;
        if (capacite == 254) return 250;
        if (capacite == 510) return 500;
        if (capacite == 1022) return 1000;
        return (capacite * 80) / 100;
    }
}
