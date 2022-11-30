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
public boolean ajouterJetonDansColonne(Jeton unJeton, int c){ // prend en parametre un jeton et une colonne 
    for (int l=0; l<6; l++){ // parcours les lignes 
        if (grille[l][c].jetonCourant == null){ // on affecte le jeton dès qu'une case sur la colonne est vide 
        grille[l][c].affecterJeton(unJeton);
        return true;
        }
    }
return false; // colonne remplie 
}
public boolean grilleRemplie(){
       for (int l=0; l<6; l++){ //parcours le tableau grille
        for (int c=0;c<7; c++){
            if (grille[l][c] != null){ // si toutes les cases sont remplies
                return true; // grille remplie
            
        }
        }
}
public void viderGrille(Joueur, Joueur){ //initialise les données a 0 pour toutes les cellules, les trous noirs et les desintegrateurs 
       for (int l=0; l<6; l++){ 
        for (int c=0;c<7; c++){  
            grille[l][c].jetonCourant = null;
            grille[l][c].TrouNoir = false;
            grille [l][c].desintegrateur= false;
            
                    
        }
}
public void GrilleSurConsole() { // afficher le grille dans la console 
    for(int l=5; l=0; l>=0); l--){ // bloucle décrémentée car l'affichage conventionnel et celui dans les tableaux sont inversé 
    for (int c=0; c<7; c++){
        if (grille[l][c].TrouNoir != false{
            System.out.print("T"); // T sur la cellule pour signifier sa presence
        }
        else if(grille [l][c].desintegrateur !=false){
            System.out.print("D");
        }
        else if (grille[l][c].jetonCourant == null){
            System.out.print("N");
        }
        else if ((grille[l][c].jetonCourant.Couleur)!= "Rouge"){
            System.out.print("J");
        }
        else{ System.out.print("R");
        }
    }
    System.out.println(""+ (l+1)); // affichage des numéros de lignes (l+1)car le tableau est initié a 0
}
    for (int c=0; c<7; c++){
        System.out.print((c+1)); //affichage des colonnes (c+1) car tableau commence à 0
    }
    System.out.println();// affichage global du tableau    
}

}
