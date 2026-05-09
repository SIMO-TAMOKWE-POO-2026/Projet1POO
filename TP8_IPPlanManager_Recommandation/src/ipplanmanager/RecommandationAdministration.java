/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

public class RecommandationAdministration extends RegleRecommandation {
    
    @Override
    public Recommandation analyser(VLAN vlan) {
        String nom = vlan.getNom().toUpperCase();
        if (nom.contains("ADMIN") || nom.contains("ADMINISTRATION")) {
            return new Recommandation(
                "Acces restreint a l'administration",
                "ELEVEE",
                "Le VLAN " + vlan.getNom() + " est un VLAN d'administration. Limiter l'acces aux administrateurs reseau uniquement."
            );
        }
        return null;
    }
}
