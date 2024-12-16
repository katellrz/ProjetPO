package main;
import entites.Enemi;
import logistic.InterfaceJoueur;
import map.Carte;
import map.Case;
import map.Point;
import outils.Omnicient;
import outils.StdDraw;

import static outils.Omnicient.*;

import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Arrive la 5");
        InterfaceJoueur i1 = new InterfaceJoueur();
        System.out.println("Arrive la 6");
        i1.AfficheInterface();  
        
        System.out.println("Arrive la 4");

        i1.AfficheDynamique();



        // Initialise un monstre
        Enemi monstre = new Enemi(12, 3, 1, 0, null, 6, 0);
       
        System.out.println("Arrive la 2");

        

        // Animation du déplacement
        while (monstre.currentIndex < getChemin().size() - 1) {
            System.out.println("Arrive la ");
            // Efface l'écran avant de redessiner
            StdDraw.clear();

            System.out.println("Position avant déplacement"+ monstre.getPosition().toString());
            // Déplace le monstre
            monstre.avance();

            System.out.println("Position apres déplacement"+ monstre.getPosition().toString());

            i1.AfficheDynamique ();

            // Dessine le monstre
            monstre.apparait();

            // Affiche l'écran mis à jour
            StdDraw.show();

            // Pause pour ralentir l'animation
            StdDraw.pause(50);
        }

        System.out.println("Le monstre a atteint la base !");
    }
        
    
}
