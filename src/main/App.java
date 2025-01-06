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
             

        boolean mousePressed = false; // Indique si la souris est actuellement pressée

while (true) {
    StdDraw.clear();
    i1.AfficheDynamique();

    // Déplacement des ennemis
    for (Enemi m : getPositionMonstre()) {
        m.avance();
        m.apparait();
    }

    // Détection d'un clic unique
    if (StdDraw.isMousePressed() && !mousePressed) { // Uniquement si clic commence
        mousePressed = true; // Mémorise que la souris est pressée
        Case clickedCase = Detection.detectCaseClick();

        if (clickedCase != null) {
            System.out.println("Case cliquée : " + clickedCase + ", Type : " + clickedCase.getType());
            if (clickedCase.getType() == Casetype.CONSTRUCTIBLE) {
                boolean caseOccupied = getPositionTours().stream()
                    .anyMatch(t -> t.getPosition().equals(clickedCase.getCenterCase()));

                if (!caseOccupied) {
                    // Ajouter une tour sur la case
                    Tour newTour = new Archer(1, 1, 1, 1, Element.NONE, 3, clickedCase.getCenterCase());
                    AddTour(newTour);
                    System.out.println("Tour ajoutée à la case : " + clickedCase);
                } else {
                    System.out.println("Case déjà occupée !");
                }
            } else {
                System.out.println("Case non constructible !");
            }
        }
    } else if (!StdDraw.isMousePressed()) {
        mousePressed = false; // Réinitialise l'état quand la souris est relâchée
    }

    // Affichage des tours
    for (Tour t : getPositionTours()) {
        t.afficheTour(getSize());
    }

    StdDraw.show();
    StdDraw.pause(50);
    }}}
            
        

/*             for (Tour t : getPositionTours()) {
                System.out.println("affiche tour ");
                t.afficheTour(getSize());
            } */
    

