public class Enemi extends Entite {
    private double Speed;
    private int Reward;
    private Point position;

    // Constructeur de la classe Enemi
    public Enemi(int PV, int ATK, double ATKSpeed, int Range, Element Element, double Speed, int Reward, Point position ) {
        super(PV, ATK, ATKSpeed, Range, Element);
        this.Speed = Speed;
        this.Reward = Reward;
        this.position= position;
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

    public void avance(){

        int x = position.getX();
        int y = position.getY();

        

    }
}