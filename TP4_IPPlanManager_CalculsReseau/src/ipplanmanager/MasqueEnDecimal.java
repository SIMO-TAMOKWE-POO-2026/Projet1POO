/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author b.arnauld
 */
public class MasqueEnDecimal {
    public static String convertirMasqueEnDecimal(int masque) {
    if (masque == 0) {
        return "0.0.0.0";
    }
    
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
