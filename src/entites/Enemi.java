package entites;

import map.Case;
import map.Point;
import outils.StdDraw;

import static outils.Omnicient.*;

import java.awt.Color;
import java.util.List;

public class Enemi extends Entite {
    private double Speed;
    private int Reward;
    private Point position;
    public int currentIndex;

    // Constructeur de la classe Enemi
    public Enemi(int PV, int ATK, double ATKSpeed, int Range, Element Element, double Speed, int Reward, Point position) {
        super(PV, ATK, ATKSpeed, Range, Element);
        this.Speed = Speed;
        this.Reward = Reward;
        this.position= position;
        this.currentIndex = 0;
    }

    // Getters et setters
    public double getSpeed() {
        return Speed;
    }

    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }

    public int getReward() {
        return Reward;
    }

    public void setReward(int Reward) {
        this.Reward = Reward;
    }

    
    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void avance(){

        List<Case>path = getChemin();

        if (currentIndex >= path.size() - 1) { // Le monstre a atteint la fin du chemin
            System.out.println("Le monstre est arrivé à la base !");
            return;
        }

        // Position centrale de la prochaine case
        Case nextCase = path.get(currentIndex + 1);
        Point target = new Point(nextCase.getCenterX(), nextCase.getCenterY()); // Position cible (centre de la case)

        // Calcul du vecteur de déplacement
        double dx = target.getX() - position.getX();
        double dy = target.getY() - position.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        // Si le monstre atteint la prochaine case
        if (distance <=Speed) {
            position.setX(target.getX());
            position.setY(target.getY());
            currentIndex++; // Passe à la prochaine case
        } else {
            // Déplace le monstre proportionnellement à sa vitesse
            position.setX((int)(position.getX() + dx / distance * Speed));
            position.setY((int)(position.getY() + dy / distance * Speed));
        }
    }

    public void apparait(){
        
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.circle(position.getX(), position.getY(), 20);

        System.out.println("Arrive la 18");
        StdDraw.show();
        
    }

    
}