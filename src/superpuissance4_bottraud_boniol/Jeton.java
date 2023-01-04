/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4_bottraud_boniol;

/**
 *
 * @author guilenebottraud
 */
public class Jeton {
    String Couleur; // le couleur Jaune et Rouge definit le jeton 
    

public Jeton (String uneCouleur){ // création d'un constructeur qui met en paramètre son attribut couleur
    Couleur = uneCouleur;
}

public String LireCouleur (){
    return Couleur; // renvoie la couleur du jeton
}

}


