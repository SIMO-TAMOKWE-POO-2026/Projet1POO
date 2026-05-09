/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

public class RecommandationServeurs extends RegleRecommandation {
    
    @Override
    public Recommandation analyser(VLAN vlan) {
        if (vlan.getNom().toUpperCase().contains("SERVEUR")) {
            return new Recommandation(
                "Securite des serveurs",
                "ELEVEE",
                "Le VLAN " + vlan.getNom() + " contient des serveurs. Isoler et restreindre les acces."
            );
        }
        return null;
    }
}
