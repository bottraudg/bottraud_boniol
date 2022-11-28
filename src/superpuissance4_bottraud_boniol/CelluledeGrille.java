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
    boolean trouNoir;
    boolean désintegrateur;

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

    public Jeton récupererJeton() {
        Jeton JetonRécupéré = JetonGrille;
        JetonGrille = null;
        return JetonRécupéré;
    }

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

    public boolean placerTrouNoir() {
        if (trouNoir == false) {
            trouNoir = true;
            System.out.println("Ajout d'un trou noir");
            return true;
        } else {
            System.out.println("Trou noir déjà présent");
            return false;
        }
    }

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

    public boolean présenceTrouNoir() {
        if (trouNoir == true) {
            System.out.println("trou noir présent");
            return true;
        } else {
            System.out.println("pas de trou noir");
            return false;
        }
    }

    public boolean présenceDésintegrateur() {
        if (désintegrateur == true) {
            System.out.println("trou noir présent");
            return true;
        } else {
            System.out.println("pas de désintegrateur");
            return false;
        }
    }

    public String lireCouleurJeton() {
        if (JetonGrille == null) {
            return "cellule vide";
        } else {
            return JetonGrille.LireCouleur();
        }
    }

    public boolean recupererDésintégrateur() {
        if (désintegrateur == true){
        désintegrateur = false;
        System.out.println("Suppresion du désintegrateur");
        return true;
        } else{
            System.out.println("pas de désintegrateur");
            return false;
        }

    
    


        
    
}
    }
