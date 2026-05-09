/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author b.arnauld
 */
public class Main {
 public static void main(String[] args) {
InfrastructureReseau infrastructure =
new InfrastructureReseau("Infrastructure YFY");
ReseauIP reseauAdmin =
new ReseauIP("192.168.1.0",24,"Réseau Administration"
);
ReseauIP reseauTechnique = new ReseauIP(
"172.16.0.0",
16,
"Réseau Technique"
);
ReseauIP reseauWifi =
new ReseauIP(
"10.0.0.0",
8,
"Réseau WiFi"
);
SousReseau admin =
new SousReseau(
"ADMIN",
reseauAdmin
        );
SousReseau tech =
new SousReseau(
"TECH",
reseauTechnique
);
SousReseau wifi =
new SousReseau(
"WIFI",
reseauWifi
);
infrastructure.ajouterSousReseau(admin);
infrastructure.ajouterSousReseau(tech);
infrastructure.ajouterSousReseau(wifi);
infrastructure.afficher();
}
}

