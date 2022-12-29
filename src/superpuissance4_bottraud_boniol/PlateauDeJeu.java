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

    static Object[][] CellulesJeu;

    static void tasserColonne(int col2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    CelluledeGrille[][] grille = new CelluledeGrille[6][7]; // création d'un tableau à deux dimensions avec 6 lignes et 7 colonnes rempli d'objet Cellule 
    
    /**
     *
     */
    public PlateauDeJeu(){ // constructeur qui à chaque case du tableau crée une référence objet de classe Cellule 
     for (int l=0; l<6; l++){
         for (int c=0; c<7; c++){
             grille[l][c] = new CelluledeGrille();
     }   
   }
 }    

    /**
     *
     * @param unJeton
     * @param c
     * @return
     */
    public boolean ajouterJetonDansColonne(Jeton unJeton, int c ){ // prend en parametre un jeton et une colonne 
    for (int l=0; l<6; l++){ // parcours les lignes 
        if (grille[l][c].jetonCourant == null){ // on affecte le jeton dès qu'une case sur la colonne est vide 
        grille[l][c].affecterJeton(unJeton);
        return true;
        }
    }
return false; // colonne remplie 
}

    /**
     *
     * @return
     */
    public boolean grilleRemplie(){
       for (int l=0; l<6; l++){ //parcours le tableau grille
        for (int c=0;c<7; c++){
            if (grille[l][c] != null){ // si toutes les cases sont remplies
                return true; // grille remplie
            
        }
        }
}

    /**
     *
     */

    
    public void afficherGrilleSurConsole() { // affiche la grille dans la console

    for (int l=5; l>=0; l--){ // boucle décrémentée car l'affichage conventionnel et celui pris par les tableaux est inversé
        for (int c=0; c<7; c++){
            if (grille[l][c].trouNoir != false){
                System.out.print("T"); // T sur la cellule pour signifier sa présence
            }
            else if (grille[l][c].désintegrateur != false){
                System.out.print("D");
            }
            else if (grille[l][c].jetonCourant == null){
                System.out.print("N");
            }
            else if ((grille[l][c].jetonCourant.Couleur)!= "Rouge"){
                    System.out.print("J");
                 }
            else{
                    System.out.print("R");
                }
                  
        }
        System.out.println(" " + (l+1)); // affichage des numéros de lignes (l+1) car tableau commence à 0
    }
    for (int c=0; c<7; c++){
        System.out.print((c+1)); // affichage des colonnes (c+1) car tableau commence à 0
    }
    System.out.println(); // affichage global du tableau
}

    /**
     *
     * @param l
     * @param c
     * @return
     */
    public boolean presenceJeton(int l, int c){ // si la cellule est occupée par un jeton renvoie true, sinon renvoie false 
    
     if (grille[l][c].JetonGrille != null){
        System.out.println("Cellule occupée par jeton");
        return true;
    }
    return false;
}

    /**
     *
     * @param l
     * @param c
     * @return
     */
    public String lireCouleurDuJeton (int l,int c){// retourne la couleur du jeton 
    return grille[l][c].jetonCourant.Couleur;
}

    /**
     *
     * @param unNom
     * @return
     */
    public boolean etreGagnantePourJoueur(joueur unNom){
    // détecte les victoires.si 4 jetons sont alignées sur AU MOINS UNE des drections de l'espace alors renvoie true 
    if (ligneGagnantePourCouleur(unNom.CouleurDuJoueur()) == true || colonneGagnantePourCouleur(unNom.CouleurDuJoueur()) == true || diagonaleMontanteGagnantePourCouleur(unNom.CouleurDuJoueur()) == true || diagonaleDesencanteGagnantePourCouleur(unNom.CouleurDuJoueur()) == true){
        //System.out.println("gagné");
        return true;
    }
    else {
        //System.out.println("pas encore gagné");
    }
    return false;
  }

    /**
     *
     * @param Couleur
     * @return
     */
    public boolean ligneGagnantePourCouleur(String Couleur){ // vérifie l'alignement de 4 jetons sur une ligne
    for (int l=0; l<6; l++){ // spécification de l'espace de définition où on cherche un premier jeton pour pouvoir chercher les suivants
        for (int c=0; c<4 ;c++){ // évite les problèmes de dimension de tableau
            if (grille[l][c].jetonCourant != null && grille[l][c].jetonCourant.Couleur == Couleur){ // 1ère condition : on vérifie que la case sélectionnée n'est pas vide ET que la couleur sélectionnée est la bonne
                int i = 1; // création d'un compteur qui donne le résultat de l'alignement donc initialisé à 1 car jeton aligné avec lui-même
                while (i<4 && grille[l][c+i].jetonCourant != null){ // mise en place d'une boucle qui vérifie les jetons sur la ligne
                    if (grille[l][c].jetonCourant.Couleur != grille[l][c+i].jetonCourant.Couleur ){
                        break; 
                    }
                    i++;
                }
                if (i==4){ // si le jeton arrive à 4 tour de boucle sans y sortir alors il y a alignement
                    return true;
                }
            }
        }
    }   
    return false;
}

    /**
     *
     * @param Couleur
     * @return
     */
    public boolean colonneGagnantePourCouleur(String Couleur){ // même principe que ConditionLigne
    for (int l=0; l<3; l++){
        for (int c=0; c<7 ;c++){
            if (grille[l][c].jetonCourant != null && grille[l][c].jetonCourant.Couleur == Couleur){
                int i = 1;
                while (i<4 && grille[l+i][c].jetonCourant != null){
                    if (grille[l][c].jetonCourant.Couleur != grille[l+i][c].jetonCourant.Couleur ){
                        break; 
                    }
                    i++;
                }
                if (i==4){
                    return true;
                }
            }
        }
    }   
    return false;
}

    /**
     *
     * @param Couleur
     * @return
     */
    public boolean diagonaleMontanteGagnantePourCouleur(String Couleur){
    for (int l=0; l<3; l++){
        for (int c=0; c<4 ;c++){
            if (grille[l][c].jetonCourant != null && grille[l][c].jetonCourant.Couleur == Couleur){
                int i = 1;
                while (i<4 && grille[l+i][c+i].jetonCourant != null){
                    if (grille[l][c].jetonCourant.Couleur != grille[l+i][c+i].jetonCourant.Couleur ){
                        break; 
                    }
                    i++;
                }
                if (i==4){
                    return true;
                }
            }
        }
    }   
    return false;
}

    /**
     *
     * @param Couleur
     * @return
     */
    public boolean diagonaleDesencanteGagnantePourCouleur(String Couleur){
    for (int l=3; l<6; l++){
        for (int c=0; c<4 ;c++){
            if (grille[l][c].jetonCourant != null && grille[l][c].jetonCourant.Couleur == Couleur){
                int i = 1;
                while (i<4 && grille[l-i][c+i].jetonCourant != null){
                    if (grille[l][c].jetonCourant.Couleur != grille[l-i][c+i].jetonCourant.Couleur ){
                        break; 
                    }
                    i++;
                }
                if (i==4){
                    return true;
                }
            }
        }
    }   
    return false;
}

    /**
     *
     * @param l
     * @param c
     */
    public void  tasserColonne(int l, int c){
    // fais descendre de 1 ligne la colonne lorsque celle ci est impacté par l'activation d'un desintegrateur ou trou noir
 
    for (int i=l; i<6; i++){
        if (i==5){
            grille[i][c].jetonCourant = null; // si on est sur la plus haute ligne du tableau, cela ne décale rien. On initialise juste la cellule
        }
        else{
            grille[i][c].jetonCourant = grille[i+1][c].jetonCourant; // sinon on affecte à chaque ligne de la colonne fixée la valeur du jeton au-dessus de lui
        }
    }
}

    /**
     *
     * @param c
     * @return
     */
    public boolean  dernièreLigneLibre(int c){
    //Renvoie true si la colonne est remplie, false sinon
 
    for (int l=0; l<6; l++){
        if (grille[l][c].jetonCourant==null){ // si cellule vide alors colonne non remplie
            return false ;
        }
    }
    return true ; // colonne remplie
}

    /**
     *
     * @param l
     * @param c
     * @return
     */
    public boolean  placerTrouNoir(int l, int c){
   // Si il y a déjà un trou noir, renvoie false, true sinon
 
    if (grille[l][c].trouNoir == false){
        grille[l][c].trouNoir = true;
        System.out.println("Trou Noir placé");
        return true;
    }
    System.out.println("Trou Noir déjà présent");
    return false;
}

    /**
     *
     * @param ligne
     * @param colonne
     */
    public void supprimerTrouNoir(int ligne, int colonne){
        grille[ligne][colonne].supprimerTrouNoir();
    } 

    /**
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public boolean presenceTrouNoir(int ligne, int colonne){
        return grille[ligne][colonne].presenceTrouNoir();
    }

    /**
     *
     * @param l
     * @param c
     * @return
     */
    public boolean  placerDesintegrateur(int l, int c){
    // si il y a déjà un desintegrateur de présent, renvoie false, true sinon
 
    if (grille[l][c].désintegrateur == false){
        grille[l][c].désintegrateur = true;
        System.out.println("Désintégrateur placé");
        return true;
    }
    System.out.println("Désintégrateur déjà présent");
    return false;
}

    /**
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public boolean presenceDesintegrateur(int ligne, int colonne){
        return grille[ligne][colonne].presenceDesintegrateur();
}

    /**
     *
     * @param ligne
     * @param colonne
     */
    public void supprimerDesintegrateur(int ligne, int colonne){
        grille[ligne][colonne].supprimerDesintegrateur();
    }

    /**
     *
     * @param l
     * @param c
     * @return
     */
    public boolean supprimerJeton(int l, int c){
    //Supprime le jeton si il y en a un dans la cellule
 
    if (grille[l][c].jetonCourant == null){
        System.out.println("Pas de Jeton");
        return false;
        }
        else {
        grille[l][c].jetonCourant = null;
        System.out.println("Suppression Jeton effectuée");
        return true;
        }
}

    /**
     *
     * @param l
     * @param c
     * @return
     */
    public Jeton  recupererJeton(int l, int c){
    //recupere le jeton de la coordonnée saisie
    Jeton JetonRecup = grille[l][c].jetonCourant; 
    grille[l][c].jetonCourant = null;
    return JetonRecup;
}

    public void viderGrille(joueur, joueur){ //initialise les données a 0 pour toutes les cellules, les trous noirs et les desintegrateurs 
       for (int l=0; l<6; l++){ 
        for (int c=0;c<7; c++){  
            grille[l][c].jetonCourant = null;
            grille[l][c].TrouNoir = false;
            grille [l][c].désintegrateur= false;
            
                    
        }
}}}