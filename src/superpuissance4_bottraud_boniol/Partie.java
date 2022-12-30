package superpuissance4_bottraud_boniol;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author guilenebottraud
 */
import java.util.Random;
import java.util.Scanner;

public final class Partie {

   private joueur[] ListeJoueurs = new joueur[2];
   private joueur JoueurCourant;
   private PlateauDeJeu plateau;
  
public void attribuerCouleursAuxJoueurs(){
    Random alea = new Random(); // attribution des joueurs au hasard
    boolean ChoixJoueur;
    ChoixJoueur = alea.nextBoolean();
    if (ChoixJoueur == true){
        ListeJoueurs[0].couleur = "Jaune";
        ListeJoueurs[1].couleur = "Rouge";
    }
    else {
        ListeJoueurs[0].couleur = "Rouge";
        ListeJoueurs[1].couleur = "Jaune";
    }
}
public void creerEtAffecterJeton (joueur unjoueur) {
    for (int i=0; i<30; i++){
        unjoueur.ajouterJeton( new Jeton(unjoueur.lireCouleur()));
    }

}

 public void inisialiserPartie() {
     plateau = new PlateauDeJeu();
        plateau.viderGrille(); // créé et afficher grille

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du premier joueur :");
        joueur joueur1 = new joueur(sc.nextLine());
        System.out.println("Entrer le nom du deuxième joueur :");
        joueur joueur2 = new joueur(sc.nextLine());
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;

 }
public void lancerPartie() {
        inisialiserPartie();
        while ((plateau.etreGagnantePourJoueur(ListeJoueurs[0]) == false) && (plateau.grilleRemplie() == false) && (plateau.etreGagnantePourJoueur(ListeJoueurs[1]) == false)) {

            plateau.afficherGrilleSurConsole();
            System.out.println("1) Pose un jeton");
            System.out.println("2) Désintégrer un jeton");
            System.out.println("3) Récupérer un jeton");
            Scanner sc = new Scanner(System.in);
            int action = sc.nextInt();
            while (action < 1 && action > 3) {
                System.out.println("Erreur, il faut une des 3 actions");
                action = sc.nextInt();
            }
            if (action == 2) {
                if (JoueurCourant.nombreDesintegrateurs == 0) {
                    System.out.println("Action non valide, plus de désintégrateur");
                    while (action != 1 && action != 3) {
                        System.out.println("Erreur, il faut choisir entre 1 et 3");
                        action = sc.nextInt();
                    }
                }
            }
            switch (action) {
                case 1 -> {
                    boolean result;
                    System.out.println("Quelle colonne jouer ? ");
                    int col = sc.nextInt() - 1;
                    while (col < 0 || col > 6) {
                        System.out.println("Erreur, saisir une colonne");
                        col = sc.nextInt() - 1;
                    }
                    JoueurCourant.nombreJetons_restants--;
                    
                       int i = 0;
                    while (plateau.grille[i][col].jetonCourant != null) {
                        i++;
                        if (i==5){
                            break;
                        }
                    }
                    if (plateau.grille[i][col].presenceDesintegrateur() == true) {
                        plateau.grille[i][col].recupererDésintégrateur();
                        JoueurCourant.nombreDesintegrateurs++;
                    }
                    
                    result = plateau.ajouterJetonDansColonne(JoueurCourant.reserveJetons[JoueurCourant.nombreJetons_restants], col);
                    while (result == false) {
                        System.out.println("Colonne pleine, choisissez une autre colonne");
                        col = sc.nextInt() - 1;
                        result = plateau.ajouterJetonDansColonne(JoueurCourant.reserveJetons[JoueurCourant.nombreJetons_restants], col);
                    }
                 
                    // regarder si on a un désintégrateur sur (i,col)

                    plateau.afficherGrilleSurConsole();
                }

                case 2 -> {
                    // désintégrer jeton
                    System.out.println("Quelle ligne jouer ? ");
                    int lig2 = sc.nextInt() - 1;
                    System.out.println("Quelle colonne jouer ? ");
                    int col2 = sc.nextInt() - 1;
                    while (plateau.grille[lig2][col2].lireCouleurDuJeton() == JoueurCourant.Couleur) {
                        System.out.println("Le jeton est de votre couleur ");
                        System.out.println("Quelle ligne jouer ? ");
                        lig2 = sc.nextInt() - 1;
                        System.out.println("Quelle colonne jouer ? ");
                        col2 = sc.nextInt() - 1;
                    }
                    plateau.supprimerJeton(lig2, col2);
                    plateau.tasserColonne(col2);
                    plateau.afficherGrilleSurConsole();
                    JoueurCourant.nombreDesintegrateurs--;
                    System.out.println("Nombre de désintégrateur : " + JoueurCourant.nombreDesintegrateurs + "du " + JoueurCourant);
                }

                case 3 -> {
                    // récupérer jeton
                    System.out.println("Quelle ligne jouer ? ");
                    int lig3 = sc.nextInt() - 1;
                    System.out.println("Quelle colonne jouer ? ");
                    int col3 = sc.nextInt() - 1;
                    while (plateau.grille[lig3][col3].lireCouleurDuJeton() != JoueurCourant.Couleur) {
                        System.out.println("Le jeton n'est pas de votre couleur ");
                        System.out.println("Quelle ligne jouer ? ");
                        lig3 = sc.nextInt() - 1;
                        System.out.println("Quelle colonne jouer ? ");
                        col3 = sc.nextInt() - 1;
                    }
                    //joueurCourant.ajouterJeton(grilleJeu.recupererJeton(lig3, col3));
                    plateau.supprimerJeton(lig3, col3);
                    plateau.tasserColonne(col3);
                    plateau.afficherGrilleSurConsole();
                }
            }
            if (plateau.etreGagnantePourJoueur(JoueurCourant) == false) {
                if (ListeJoueurs[0] == JoueurCourant) {
                    JoueurCourant = ListeJoueurs[1];
                } else {
                    JoueurCourant = ListeJoueurs[0];
                }

                System.out.println("Tour suivant :" + JoueurCourant.Nom);
                System.out.println("Nombre de jeton de " + JoueurCourant.Nom + " est : " + JoueurCourant.nombreJetons_restants);
                System.out.println("Nombre de désintégrateur de " + JoueurCourant.Nom + " est : " + JoueurCourant.nombreDesintegrateurs);
            }

        }
        System.out.println(JoueurCourant.Nom + " a gagné, le jeu est terminé.");
    }





}
