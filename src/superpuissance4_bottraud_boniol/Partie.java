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
public void creerEtAffecterJeton (joueur ; unjoueur)static {
    for (int i=0; i<30; i++){
        unjoueur.ajouterJeton( new Jeton(unjoueur.lireCouleur()));}

}

 public void inisialiserPartie() {
        PlateauDeJeu.viderGrille(); // créé et afficher grille

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
        while ((PlateauDeJeu.etreGagnantePourJoueur(ListeJoueurs[0]) == false) && (PlateauDeJeu.grilleRemplie() == false) && (PlateauDeJeu.etreGagnantePourJoueur(ListeJoueurs[1]) == false)) {

            PlateauDeJeu.afficherGrilleSurConsole();
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
                    JoueurCourant.nombreJetonRestants--;
                    
                       int i = 0;
                    while (PlateauDeJeu.grille[i][col].jetonCourant != null) {
                        i++;
                        if (i==5){
                            break;
                        }
                    }
                    if (PlateauDeJeu.CellulesJeu[i][col].presenceDesintegrateur() == true) {
                        PlateauDeJeu.CellulesJeu[i][col].recupererDesintegrateur();
                        JoueurCourant.nombreDesintegrateurs++;
                    }
                    
                    result = grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonRestants], col);
                    while (result == false) {
                        System.out.println("Colonne pleine, choisissez une autre colonne");
                        col = sc.nextInt() - 1;
                        result = grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonRestants], col);
                    }
                 
                    // regarder si on a un désintégrateur sur (i,col)

                    grilleJeu.afficherGrilleSurConsole();
                }

                case 2 -> {
                    // désintégrer jeton
                    System.out.println("Quelle ligne jouer ? ");
                    int lig2 = sc.nextInt() - 1;
                    System.out.println("Quelle colonne jouer ? ");
                    int col2 = sc.nextInt() - 1;
                    while (grilleJeu.CellulesJeu[lig2][col2].lireCouleurDuJeton() == joueurCourant.Couleur) {
                        System.out.println("Le jeton est de votre couleur ");
                        System.out.println("Quelle ligne jouer ? ");
                        lig2 = sc.nextInt() - 1;
                        System.out.println("Quelle colonne jouer ? ");
                        col2 = sc.nextInt() - 1;
                    }
                    grilleJeu.supprimerJeton(lig2, col2);
                    grilleJeu.tasserGrille(col2);
                    grilleJeu.afficherGrilleSurConsole();
                    joueurCourant.nombreDesintegrateurs--;
                    System.out.println("Nombre de désintégrateur : " + joueurCourant.nombreDesintegrateurs + "du " + joueurCourant);
                }

                case 3 -> {
                    // récupérer jeton
                    System.out.println("Quelle ligne jouer ? ");
                    int lig3 = sc.nextInt() - 1;
                    System.out.println("Quelle colonne jouer ? ");
                    int col3 = sc.nextInt() - 1;
                    while (grilleJeu.CellulesJeu[lig3][col3].lireCouleurDuJeton() != joueurCourant.Couleur) {
                        System.out.println("Le jeton n'est pas de votre couleur ");
                        System.out.println("Quelle ligne jouer ? ");
                        lig3 = sc.nextInt() - 1;
                        System.out.println("Quelle colonne jouer ? ");
                        col3 = sc.nextInt() - 1;
                    }
                    //joueurCourant.ajouterJeton(grilleJeu.recupererJeton(lig3, col3));
                    grilleJeu.supprimerJeton(lig3, col3);
                    grilleJeu.tasserGrille(col3);
                    grilleJeu.afficherGrilleSurConsole();
                }
            }
            if (grilleJeu.etreGagnantePourJoueur(joueurCourant) == false) {
                if (ListeJoueurs[0] == joueurCourant) {
                    joueurCourant = ListeJoueurs[1];
                } else {
                    joueurCourant = ListeJoueurs[0];
                }

                System.out.println("Tour suivant :" + joueurCourant.Nom);
                System.out.println("Nombre de jeton de " + joueurCourant.Nom + " est : " + joueurCourant.nombreJetonRestants);
                System.out.println("Nombre de désintégrateur de " + joueurCourant.Nom + " est : " + joueurCourant.nombreDesintegrateurs);
            }

        }
        System.out.println(joueurCourant.Nom + " a gagné, le jeu est terminé.");
    }





}
