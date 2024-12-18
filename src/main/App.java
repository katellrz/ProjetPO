package main;
import static outils.Omnicient.*;

import java.lang.annotation.ElementType;

import entites.Enemi;
import entites.Entite.Element;
import entites.Tour;
import entites.Tours.Archer;
import logistic.InterfaceJoueur;
import map.Case;
import outils.StdDraw;
import main.Detection.*;
import map.Case.Casetype;

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

            // Détection du clic et ajout de tour
            Case clickedCase = detectCaseClick();
            if (clickedCase != null && clickedCase.getType() == Casetype.CONSTRUCTIBLE) {
                // Vérifier si aucune tour n'est déjà sur cette case
                boolean caseOccupied = getPositionTours().stream()
                    .anyMatch(t -> t.getPosition().equals(clickedCase.getCenterCase()));

                if (!caseOccupied) {
                    // Ajouter une nouvelle tour (exemple : Archer)
                    Tour newTour = new Archer(1, 1, 1, 1, Element.NONE, 3, clickedCase.getCenterCase());
                    AddTour(newTour);
                    System.out.println("Tour ajoutée à la case : " + clickedCase);
                }
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
        
    

