/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4_bottraud_boniol;

/**
 *
 * @author guilenebottraud
 */
public class PlateauDeJeu {
    CelluleDeGrille grille [][] = new CelluleDeGrille [6][7]; // création d'un tableau à deux dimensions avec 6 lignes et 7 colonnes rempli d'objet Cellule 
    
    public Grille(){ // constructeur qui à chaque case du tableau crée une référence objet de classe Cellule 
     for (int l=0; l<6; l++){
         for (int c=0; c<7; c++){
             grille[l][c] = new CelluleDeGrille();
     }   
   }
 }    
public boolean ajouterJetonDansColonne(Jeton, int){ // prend en parametre un jeton et une colonne 
    for (int l=0; l<6; l++){ // parcours les lignes 
        if (grille[l][c].jetonCourant == null){ // on affecte le jeton dès qu'une case sur la colonne est vide 
        grille[l][c].affecterJeton(uneJeton);
        return true;
        }
    }
return false; // colonne remplie 
}
}