package entites.enemies;

import entites.Enemi;
import map.Point;

public class Minion extends Enemi {

    public Minion(int PV, int ATK, int ATKSpeed, int Range, Element Element, int Speed, int Reward, Point position) {
        super(PV, ATK, ATKSpeed, Range, Element,Speed, Reward, position);
    }

}