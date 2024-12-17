package main;

import static outils.Omnicient.*;
import entites.Enemi;
import entites.Tour;
import logistic.InterfaceJoueur;
import outils.StdDraw;

public class Jeux {

    private static InterfaceJoueur i = new InterfaceJoueur();
    
    public static void BoucleappartionMonstre(){
        for (Enemi e : getPositionMonstre()) {
            e.avance();
            e.apparait();
        }
    }

    public static void BoucleappartionTours(){
        for (Tour t : getPositionTours()) {
            //t.apparait();
        }
    }

    public static void StartGame(){
        
        i.AfficheInterface();
        
    }

    public static void Entitébouge(){
        StdDraw.clear();

        BoucleappartionMonstre();
        BoucleappartionTours();

        i.AfficheDynamique();

        StdDraw.show();

        StdDraw.pause(50);
    }
}
