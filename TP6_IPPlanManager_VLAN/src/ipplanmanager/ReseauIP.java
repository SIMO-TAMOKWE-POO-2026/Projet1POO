/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author b.arnauld
 */
public class ReseauIP {
     private String adresseReseau;
    private int masque;
    private String description;
    
    public ReseauIP(String adresseReseau, int masque, String description) {
        if (adresseReseau == null || adresseReseau.isEmpty()) {
            System.out.println("Erreur : adresse réseau invalide, utilisation de 0.0.0.0");
            this.adresseReseau = "0.0.0.0";
        } else {
            this.adresseReseau = adresseReseau;
        }
        
        if (masque < 0 || masque > 32) {
            System.out.println("Erreur : masque invalide (" + masque + "), utilisation de 24");
            this.masque = 24;
        } else {
            this.masque = masque;
        }
        
        if (description == null || description.isEmpty()) {
            System.out.println("Erreur : description invalide, utilisation de 'Réseau sans description'");
            this.description = "Réseau sans description";
        } else {
            this.description = description;
        }
    }
    
    public String getAdresseReseau() {
        return adresseReseau;
    }
    
    public int getMasque() {
        return masque;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setAdresseReseau(String adresseReseau) {
        if (adresseReseau == null || adresseReseau.isEmpty()) {
            System.out.println("Erreur : adresse réseau invalide");
        } else {
            this.adresseReseau = adresseReseau;
        }
    }
    
    public void setMasque(int masque) {
        if (masque < 0 || masque > 32) {
            System.out.println("Erreur : masque invalide (" + masque + ")");
        } else {
            this.masque = masque;
        }
    }
    
    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            System.out.println("Erreur : description invalide");
        } else {
            this.description = description;
        }
    }
    
    public void afficher() {
        System.out.println("Réseau : " + adresseReseau + "/" + masque);
        System.out.println("Description : " + description);
    }
}


