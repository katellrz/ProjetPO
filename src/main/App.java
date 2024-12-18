package main;
import static outils.Omnicient.*;

import entites.Enemi;
import entites.Entite.Element;
import entites.Tour;
import entites.Tours.Archer;
import logistic.InterfaceJoueur;
import map.Case;
import outils.StdDraw;

public class App {

    public static void main(String[] args) throws Exception {


        InterfaceJoueur i1 = new InterfaceJoueur();
        i1.AfficheInterface();
        
                
        
        i1.AfficheDynamique();

        // Initialise un monstre
        Enemi monstre = new Enemi(12, 3, 1, 0, null, 6, 0);
        AddEnemi(monstre);

               

        // Animation du déplacement
        while (true) {
            
            // Efface l'écran avant de redessiner
            StdDraw.clear();

            i1.AfficheDynamique ();
            
            // Déplace le monstre
            for (Enemi m : getPositionMonstre()) {
                m.avance();
                m.apparait();
            }



            
            
        

/*             for (Tour t : getPositionTours()) {
                System.out.println("affiche tour ");
                t.afficheTour(getSize());
            } */

            // Dessine le monstre

            // Affiche l'écran mis à jour
            StdDraw.show();

            // Pause pour ralentir l'animation
            StdDraw.pause(50);
        }

    }
}
        
    

