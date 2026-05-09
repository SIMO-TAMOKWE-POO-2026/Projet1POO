/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

public class RecommandationWifiInvite extends RegleRecommandation {
    
    @Override
    public Recommandation analyser(VLAN vlan) {
        if (vlan.getNom().toUpperCase().contains("WIFI")) {
            return new Recommandation(
                "Isolation du WiFi",
                "ELEVEE",
                "Le VLAN " + vlan.getNom() + " doit etre isole des VLANs internes sensibles."
            );
        }
        return null;
    }
}