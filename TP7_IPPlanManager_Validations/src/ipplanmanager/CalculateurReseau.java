/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author b.arnauld
 */
public class CalculateurReseau {
     public static int calculerNombreHotes(int cidr) {
        if (cidr < 0 || cidr > 32) {
            return 0;
        }
        if (cidr == 32) {
            return 0;
        }
        if (cidr == 31) {
            return 2;
        }
        int bitsHotes = 32 - cidr;
        return (int) Math.pow(2, bitsHotes) - 2;
    }
    
    public static String obtenirClasseReseau(String adresseIP) {
        String[] parties = adresseIP.split("\\.");
        int premierOctet = Integer.parseInt(parties[0]);
        if (premierOctet >= 1 && premierOctet <= 126) {
            return "Classe A";
        }
        if (premierOctet >= 128 && premierOctet <= 191) {
            return "Classe B";
        }
        if (premierOctet >= 192 && premierOctet <= 223) {
            return "Classe C";
        }
        return "Classe inconnue";
    }
    
    public static String obtenirMasqueDecimal(int cidr) {
        if (cidr == 0) return "0.0.0.0";
        
        StringBuilder binaire = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if (i < cidr) {
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
    
    public static boolean estReseauPrive(String adresseIP) {
        String[] parties = adresseIP.split("\\.");
        int premierOctet = Integer.parseInt(parties[0]);
        int deuxiemeOctet = Integer.parseInt(parties[1]);
        
        if (premierOctet == 10) {
            return true;
        }
        if (premierOctet == 172 && deuxiemeOctet >= 16 && deuxiemeOctet <= 31) {
            return true;
        }
        if (premierOctet == 192 && deuxiemeOctet == 168) {
            return true;
        }
        return false;
    }
    
    public static String calculerPremiereAdresseUtilisable(String adresseReseau) {
        String[] parties = adresseReseau.split("\\.");
        int octet1 = Integer.parseInt(parties[0]);
        int octet2 = Integer.parseInt(parties[1]);
        int octet3 = Integer.parseInt(parties[2]);
        int octet4 = Integer.parseInt(parties[3]);
        
        if (octet4 < 255) {
            octet4 = octet4 + 1;
        } else {
            octet4 = 0;
            if (octet3 < 255) {
                octet3 = octet3 + 1;
            } else {
                octet3 = 0;
                if (octet2 < 255) {
                    octet2 = octet2 + 1;
                } else {
                    octet2 = 0;
                    octet1 = octet1 + 1;
                }
            }
        }
        return octet1 + "." + octet2 + "." + octet3 + "." + octet4;
    }
    
    public static String calculerDerniereAdresseUtilisable(String adresseReseau, int cidr) {
        String[] parties = adresseReseau.split("\\.");
        int octet1 = Integer.parseInt(parties[0]);
        int octet2 = Integer.parseInt(parties[1]);
        int octet3 = Integer.parseInt(parties[2]);
        int octet4 = Integer.parseInt(parties[3]);
        
        int nombreAdresses = (int) Math.pow(2, (32 - cidr));
        int adresseBroadcast = nombreAdresses - 1;
        
        long ipEnNombre = ((long) octet1 << 24) | ((long) octet2 << 16) | ((long) octet3 << 8) | (long) octet4;
        long broadcastEnNombre = ipEnNombre + adresseBroadcast;
        long derniereAdresse = broadcastEnNombre - 1;
        
        int o1 = (int) ((derniereAdresse >> 24) & 0xFF);
        int o2 = (int) ((derniereAdresse >> 16) & 0xFF);
        int o3 = (int) ((derniereAdresse >> 8) & 0xFF);
        int o4 = (int) (derniereAdresse & 0xFF);
        
        return o1 + "." + o2 + "." + o3 + "." + o4;
    }
    
    public static int convertirIpEnEntier(String adresseIP) {
        String[] parties = adresseIP.split("\\.");
        int octet1 = Integer.parseInt(parties[0]);
        int octet2 = Integer.parseInt(parties[1]);
        int octet3 = Integer.parseInt(parties[2]);
        int octet4 = Integer.parseInt(parties[3]);
        
        return (octet1 << 24) | (octet2 << 16) | (octet3 << 8) | octet4;
    }
    
    public static String convertirEntierEnIp(int entier) {
        int octet1 = (entier >> 24) & 0xFF;
        int octet2 = (entier >> 16) & 0xFF;
        int octet3 = (entier >> 8) & 0xFF;
        int octet4 = entier & 0xFF;
        
        return octet1 + "." + octet2 + "." + octet3 + "." + octet4;
    }
    
    public static int calculerCidrPourHotes(int nombreHotes) {
        int bitsHotes = 0;
        int hotesMax = 1;
        while (hotesMax - 2 < nombreHotes) {
            bitsHotes++;
            hotesMax = hotesMax * 2;
        }
        return 32 - bitsHotes;
    }
    
    public static int calculerTailleBloc(int cidr) {
        return (int) Math.pow(2, (32 - cidr));
    }
}


