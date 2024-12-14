package entites;

import java.awt.Point;

public class Tours extends Entite {
    private int Cost;

    // Constructeur de la classe TOURS
    public Tours(int PV, int ATK, double ATKSpeed, int Range, Element Element, Point Position, String Icone, int Cost) {
        super(PV, ATK, ATKSpeed, Range, Element);
        this.Cost = Cost;
    }

    // Getters et setters
    public int getMoney() {
        return Cost;
    }

    public void setMoney(int Money) {
        this.Cost = Money;
    }    
}