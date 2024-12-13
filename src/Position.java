public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    
    public int getX() {
        return x;
    }

    
    public void setX(int x) {
        this.x = x;
    }

    
    public int getY() {
        return y;
    }


    public void setY(int y) {
        this.y = y;
    }

    // Méthode pour calculer la distance entre deux positions
    public double distance(Position autre) {
        return Math.sqrt(Math.pow(this.x - autre.x, 2) + Math.pow(this.y - autre.y, 2));
    }

    /*// Méthode pour vérifier si deux positions sont égales
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return x == position.x && y == position.y;
    }*/
}
