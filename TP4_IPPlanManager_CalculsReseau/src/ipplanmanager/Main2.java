/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author b.arnauld
 */
public class Main2 {
    public static void main(String[] args) {
        InfrastructureReseau infrastructure = new InfrastructureReseau("Infrastructure YFY");
        
        ReseauIP reseauAdmin = new ReseauIP("192.168.1.0", 24, "Réseau Administration");
        ReseauIP reseauTechnique = new ReseauIP("172.16.0.0", 16, "Réseau Technique");
        ReseauIP reseauWifi = new ReseauIP("10.0.0.0", 8, "Réseau WiFi");
        ReseauIP reseauDirection = new ReseauIP("192.168.10.0", 28, "Réseau Direction");
        ReseauIP reseauInvites = new ReseauIP("192.168.20.0", 26, "Réseau Invités");
        ReseauIP reseauServeurs = new ReseauIP("10.10.0.0", 24, "Réseau Serveurs");
        ReseauIP reseauDMZ = new ReseauIP("172.20.0.0", 20, "Réseau DMZ");
        ReseauIP reseauInvalide = new ReseauIP("", 55, "");
        ReseauIP reseauInvalide2 = new ReseauIP("192.168.99.0", -3, null);
        
        SousReseau admin = new SousReseau("ADMIN", reseauAdmin);
        SousReseau tech = new SousReseau("TECH", reseauTechnique);
        SousReseau wifi = new SousReseau("WIFI", reseauWifi);
        SousReseau direction = new SousReseau("DIRECTION", reseauDirection);
        SousReseau invites = new SousReseau("INVITES", reseauInvites);
        SousReseau serveurs = new SousReseau("SERVEURS", reseauServeurs);
        SousReseau dmz = new SousReseau("DMZ", reseauDMZ);
        SousReseau invalide = new SousReseau("", reseauInvalide);
        SousReseau invalide2 = new SousReseau("INVALIDE", reseauInvalide2);
        
        infrastructure.ajouterSousReseau(admin);
        infrastructure.ajouterSousReseau(tech);
        infrastructure.ajouterSousReseau(wifi);
        infrastructure.ajouterSousReseau(direction);
        infrastructure.ajouterSousReseau(invites);
        infrastructure.ajouterSousReseau(serveurs);
        infrastructure.ajouterSousReseau(dmz);
        infrastructure.ajouterSousReseau(invalide);
        infrastructure.ajouterSousReseau(invalide2);
        
        infrastructure.afficher();
        
        System.out.println();
        System.out.println("===== VÉRIFICATION DES CAPACITÉS RÉSEAU =====");
        System.out.println();
        
        verifierCapacite(reseauAdmin);
        verifierCapacite(reseauTechnique);
        verifierCapacite(reseauWifi);
        verifierCapacite(reseauDirection);
        verifierCapacite(reseauInvites);
        verifierCapacite(reseauServeurs);
        verifierCapacite(reseauDMZ);
        verifierCapacite(reseauInvalide);
        verifierCapacite(reseauInvalide2);
        
        System.out.println();
        System.out.println("===== VÉRIFICATION DES CLASSES RÉSEAU =====");
        System.out.println();
        
        verifierClasse(reseauAdmin);
        verifierClasse(reseauTechnique);
        verifierClasse(reseauWifi);
        verifierClasse(reseauDirection);
        verifierClasse(reseauInvites);
        verifierClasse(reseauServeurs);
        verifierClasse(reseauDMZ);
        verifierClasse(reseauInvalide);
        verifierClasse(reseauInvalide2);
        
        System.out.println();
        System.out.println("===== TEST DES MASQUES =====");
        System.out.println();
        
        testerMasques();
    }
    
    public static void verifierCapacite(ReseauIP reseau) {
        int masque = reseau.getMasque();
        int nombreHotes = (int) Math.pow(2, (32 - masque)) - 2;
        if (masque == 32) {
            nombreHotes = 0;
        } else if (masque == 31) {
            nombreHotes = 2;
        }
       
    }
   
    public static void verifierClasse(ReseauIP reseau) {
        String adresse = reseau.getAdresseReseau();
        String classe;
        
        if (adresse.startsWith("0.") || adresse.equals("0.0.0.0")) {
            classe = "Classe A (ou adresse spéciale)";
        } else {
            int premierOctet = extrairePremierOctet(adresse);
            
            if (premierOctet >= 1 && premierOctet <= 126) {
                classe = "Classe A";
            } else if (premierOctet == 127) {
                classe = "Adresse de bouclage (loopback)";
            } else if (premierOctet >= 128 && premierOctet <= 191) {
                classe = "Classe B";
            } else if (premierOctet >= 192 && premierOctet <= 223) {
                classe = "Classe C";
            } else if (premierOctet >= 224 && premierOctet <= 239) {
                classe = "Classe D (Multicast)";
            } else if (premierOctet >= 240 && premierOctet <= 255) {
                classe = "Classe E (Expérimentale)";
            } else {
                classe = "Inconnue";
            }
        }
        
        System.out.println(adresse + " -> " + classe);
    }
    
    public static int extrairePremierOctet(String adresse) {
        try {
            String[] octets = adresse.split("\\.");
            return Integer.parseInt(octets[0]);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public static void testerMasques() {
        int[] masquesATester = {0, 8, 16, 20, 24, 25, 26, 27, 28, 29, 30, 31, 32};
        
        for (int masque : masquesATester) {
            ReseauIP reseauTemp = new ReseauIP("192.168.1.0", masque, "Test /" + masque);
            int nombreHotes;
            if (masque == 32) {
                nombreHotes = 0;
            } else if (masque == 31) {
                nombreHotes = 2;
            } else {
                nombreHotes = (int) Math.pow(2, (32 - masque)) - 2;
            }
            String masqueSousReseau = convertirMasqueEnDecimal(masque);
            System.out.println("CIDR /" + masque + " -> Masque : " + masqueSousReseau + " -> " + nombreHotes + " hôtes");
        }
    }
    
    public static String convertirMasqueEnDecimal(int masque) {
        if (masque == 0) return "0.0.0.0";
        
        StringBuilder binaire = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if (i < masque) {
                binaire.append("1");
            } else {
                binaire.append("0");
            }
        }
        
        int octet1 = Integer.parseInt(binaire.substring(0, 8), 2);
        int octet2 = Integer.parseInt(binaire.substring(8, 16), 2);
        int octet3 = Integer.parseInt(binaire.substring(16, 24), 2);
        int octet4 = Integer.parseInt(binaire.substring(24, 32), 2);
        
        return octet1 + "." + octet2 + "." + octet3 + "." + octet4;
    }
}  


