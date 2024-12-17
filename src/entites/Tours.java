package entites;

import static outils.Omnicient.*;

import java.awt.Point;

import map.Case;

public class Tours extends Entite {
    private int Cost;

    // Constructeur de la classe TOURS
    public Tours(int PV, int ATK, double ATKSpeed, int Range, Element Element, Point Position) {
        super(PV, ATK, ATKSpeed, Range, Element);
    }

    // Getters et setters
    public int getMoney() {
        return Cost;
    }

    public void PlacerTour(){
        for (Case[] c : getCarte()) {
            for (Case cs : c) {
                if(cs.SourisClique()){
                    AddTour(new Tours(1, 12, 1, 1, null, null));
                }                
            }
            
        }
    }


  
}