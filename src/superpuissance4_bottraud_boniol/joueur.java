/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4_bottraud_boniol;

/**
 *
 * @author Benjamin
 */
public class joueur {

    static String lireCouleur() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static String Couleur() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    String nom;
    String couleur;
    Jeton [] reserveJetons = new Jeton[21];
    int nombreDesintegrateurs;
    int nombreJetons_restants;
    String Nom;
    String Couleur;


public joueur (String unNom) { // constructeur qui passe le nom en paramètre et initialise les attributs
    nom = unNom;
    nombreDesintegrateurs = 0;
    nombreJetons_restants = 0;
}  
public void affecterCouleur (String uneCouleur){ // affecte la couleur en paramètre au joueur
    couleur = uneCouleur ;
}
public String CouleurDuJoueur(){ // création de cette méthode pour récupérer la couleur dans la classe grille
    return couleur;
}
 public boolean ajouterJeton(Jeton unJeton) {
        //int i = 0;
        if (nombreJetons_restants==21){
            return false;
        }
        else{
             reserveJetons[nombreJetons_restants] = unJeton;
             nombreJetons_restants++;
             return true;
        }
    }
public void obtenirDesintegrateur() {
        nombreDesintegrateurs++;
    }
    
    public boolean utiliserDesintegrateur() {
        if (nombreDesintegrateurs==0){
            return false;
        }
        else{
            nombreDesintegrateurs=nombreDesintegrateurs-1;
            return true;
        }
    }
}
 

