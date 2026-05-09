/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

public class RecommandationGrandVLAN extends RegleRecommandation {
    
    @Override
    public Recommandation analyser(VLAN vlan) {
        if (vlan.getResultat() != null && vlan.getResultat().getCapacite() > 200) {
            return new Recommandation(
                "VLAN de grande taille",
                "MOYENNE",
                "Le VLAN " + vlan.getNom() + " possede une grande capacite. Il faut surveiller les broadcasts."
            );
        }
        return null;
    }
}