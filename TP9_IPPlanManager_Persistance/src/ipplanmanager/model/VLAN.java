/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

public class VLAN {
    private int numero;
    private String nom;
    private ResultatVLSM resultat;
    private String description;
    
    public VLAN(int numero, String nom, ResultatVLSM resultat, String description) {
        this.numero = numero;
        this.nom = nom;
        this.resultat = resultat;
        this.description = description;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public String getNom() {
        return nom;
    }
    
    public ResultatVLSM getResultat() {
        return resultat;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void afficher() {
        System.out.println("VLAN " + numero + " - " + nom + " | " + description);
        System.out.print("  ");
        if (resultat != null) {
            resultat.afficher();
        }
    }
}
