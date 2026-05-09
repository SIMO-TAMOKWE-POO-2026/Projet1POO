/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

import java.util.ArrayList;

public class GestionnaireVLAN {
    private ArrayList<VLAN> vlans;
    
    public GestionnaireVLAN() {
        vlans = new ArrayList<>();
    }
    
    public void ajouterVLAN(VLAN vlan) throws ConflitVLANException {
        for (VLAN v : vlans) {
            if (v.getNumero() == vlan.getNumero()) {
                throw new ConflitVLANException("Conflit : le VLAN " + vlan.getNumero() + " est déjà utilisé par " + v.getNom());
            }
        }
        vlans.add(vlan);
    }
    
    public VLAN rechercherVLAN(int numero) {
        for (VLAN vlan : vlans) {
            if (vlan.getNumero() == numero) {
                return vlan;
            }
        }
        return null;
    }
    
    public int getNombreVLANs() {
        return vlans.size();
    }
    
    public void afficherVLANsPlusDe100Hotes() {
        boolean trouve = false;
        for (VLAN vlan : vlans) {
            if (vlan.getResultat().getCapacite() > 100) {
                vlan.afficher();
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun VLAN ne contient plus de 100 hôtes.");
        }
    }
    
    public void afficherVLANsCritiques() {
        boolean trouve = false;
        for (VLAN vlan : vlans) {
            if (vlan.getResultat().getCapacite() > 100) {
                System.out.println("VLAN critique détecté :");
                System.out.println("VLAN " + vlan.getNumero() + " - " + vlan.getNom() + " - " + vlan.getResultat().getCapacite() + " hôtes");
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun VLAN critique détecté.");
        }
    }
    
    public VLAN getVLANPlusGrandeCapacite() {
        if (vlans.isEmpty()) {
            return null;
        }
        VLAN vlanMax = vlans.get(0);
        for (VLAN vlan : vlans) {
            if (vlan.getResultat().getCapacite() > vlanMax.getResultat().getCapacite()) {
                vlanMax = vlan;
            }
        }
        return vlanMax;
    }
    
    public void afficherTousLesVLANs() {
        for (VLAN vlan : vlans) {
            vlan.afficher();
        }
    }
    public ArrayList<VLAN> getVlans() {
return vlans;
}
}