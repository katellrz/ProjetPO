package entites.Tours;


import entites.Tour;
import map.Point;

public class Archer extends Tour{

    public Archer(int PV, int ATK, double ATKSpeed, int Range, Element Element,int cost, Point position){
        super(PV,ATK,ATKSpeed,Range,Element, cost, position);
    }

    @Override
    public int getMaxPV() {
        return MaxPV;
    }




}