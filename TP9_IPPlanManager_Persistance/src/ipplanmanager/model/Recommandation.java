/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

public class Recommandation {
    private String titre;
    private String niveau;
    private String description;
    
    public Recommandation(String titre, String niveau, String description) {
        this.titre = titre;
        this.niveau = niveau;
        this.description = description;
    }
    
    public String getTitre() {
        return titre;
    }
    
    public String getNiveau() {
        return niveau;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void afficher() {
        System.out.println("Recommandation : " + titre);
        System.out.println("Niveau : " + niveau);
        System.out.println("Description : " + description);
        System.out.println();
    }
}