/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4_bottraud_boniol;

/**
 *
 * @author Benjamin
 */
public class CelluledeGrille {

    Jeton JetonGrille;
    boolean TrouNoir;
    boolean désintegrateur;
    Jeton jetonCourant;
    boolean trouNoir;

    /**
     * Affecte un jeton à une celulle
     *
     * @param JetonCellule
     * @return true si le jeton à bien été affecté sinon return false
     */
    public boolean affecterJeton(Jeton JetonCellule) {
        if (JetonGrille == null) {
            JetonGrille = JetonCellule;
            System.out.println("jeton affecté");
            return true;
        } else {
            System.out.println("un jeton est déjà affecté");
            return false;
        }
    }

    /**
     * Récupère le jeton d'une cellule
     *
     * @return le jeton récupéré
     */
    public Jeton récupererJeton() {
        Jeton JetonRécupéré = JetonGrille;
        JetonGrille = null;
        return JetonRécupéré;
    }

    /**
     * Supprime le jeton d'une cellule
     * @return true si le jeton à bien été supprimé et return false s'il n'y a
     * pas de jeton
     */
    public boolean supprimerJeton() {
        if (JetonGrille == null) {
            System.out.println("case vide");
            return false;
        } else {
            JetonGrille = null;
            System.out.println("Jeton supprimé");
            return true;
        }
    }

    /**
     * Place un trou noir sur une cellule
     *
     * @return true si le trou noir à bien été placé et sinon return false s'il
     * y a déjà un trou noir
     */
    public boolean placerTrouNoir() {
        if (TrouNoir == false) {
            TrouNoir = true;
            System.out.println("Ajout d'un trou noir");
            return true;
        } else {
            System.out.println("Trou noir déjà présent");
            return false;
        }
    }

    /**
     * Supprime le trou noir d'une cellule
     * @return true si le trou noir est supprimé sinon false si la case est vide
     */
    public boolean supprimerTrouNoir() {
        if (TrouNoir == false) {
            System.out.println("case vide");
            return false;
        } else {
            TrouNoir = true;
            System.out.println("Trou noir supprimé");
            return true;
        }
    }

    /**
     * Place un désintégrateur sur une cellule
     *
     * @return true si le désintegrateur à bien été placé et sinon return false
     * s'il y a déjà un désintegrateur
     */
    public boolean placerDésintegrateur() {
        if (désintegrateur == false) {
            désintegrateur = true;
            System.out.println("Ajout d'un désintegrateur");
            return true;
        } else {
            System.out.println("désintegrateur déjà présent");
            return false;
        }
    }

    /**
     * Vérifie la présence d'un trou noir
     *
     * @return true si un trou noir est présent sinon return false
     */
    public boolean présenceTrouNoir() {
        if (TrouNoir == true) {
            System.out.println("trou noir présent");
            return true;
        } else {
            System.out.println("pas de trou noir");
            return false;
        }
    }

    /**
     * Vérifie la présence d'un désintegrateur
     *
     * @return true si un désintegrateur est présent sinon return false
     */
    public boolean présenceDésintegrateur() {
        if (désintegrateur == true) {
            System.out.println("trou noir présent");
            return true;
        } else {
            System.out.println("pas de désintegrateur");
            return false;
        }
    }

    /**
     * Verifie la présence d'un jeton
     *
     * @return true s'il y a un jeton sinon false
     */
    public boolean presenceJeton() {
        if (JetonGrille == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Lit la couleur d'un jeton
     *
     * @return la couleur du jeton
     */
    public String lireCouleurDuJeton() {
        if (JetonGrille == null) {
            return "cellule vide";
        } else {
            return JetonGrille.LireCouleur();
        }
    }

    /**
     * Récupère le désintegrateur
     *
     * @return true si le
     */
    public boolean recupererDésintégrateur() {
        if (désintegrateur == true) {
            désintegrateur = false;
            System.out.println("Suppresion du désintegrateur");
            return true;
        } else {
            System.out.println("pas de désintegrateur");
            return false;
        }
    }

    /**
     * Utilise un trou noir
     *
     * @return
     */
    public boolean utiliserTrouNoir() {
        if (TrouNoir == true) {
            JetonGrille = null;
            TrouNoir = false;
            System.out.println("Trou noir utilisé");
            return true;
        } else {
            System.out.println("pas de trou noir");
            return false;
        }
    }

    @Override
    public String toString() {
        return "CelluledeGrille{" + "JetonGrille=" + JetonGrille + ", TrouNoir=" + TrouNoir + ", d\u00e9sintegrateur=" + désintegrateur + '}';
    }

    boolean presenceDesintegrateur() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void supprimerDesintegrateur() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean presenceTrouNoir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
