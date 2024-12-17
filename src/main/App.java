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


        InterfaceJoueur i1 = new InterfaceJoueur();
        i1.AfficheInterface();
        
                
        
        i1.AfficheDynamique();

        // Initialise un monstre
        Enemi monstre = new Enemi(12, 3, 1, 0, null, 6, 0);
        Enemi monstre2 =  new Enemi(12, 3, 1, 0, null, 2, 0);
               

        // Animation du déplacement
        while (true) {
            
            // Efface l'écran avant de redessiner
            StdDraw.clear();

            
            // Déplace le monstre
            monstre.avance();
            monstre2.avance();

            i1.AfficheDynamique ();

            // Dessine le monstre
            monstre.apparait();
            monstre2.apparait();

            // Affiche l'écran mis à jour
            StdDraw.show();

            // Pause pour ralentir l'animation
            StdDraw.pause(50);
        }

    }
        
    
}
