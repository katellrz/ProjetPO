package map;
import java.awt.Color;

import outils.StdDraw;

enum Casetype {DECOR, CONSTRUCTIBLE, ROUTE, BASE, SPAWN}

public class Case {

    protected Casetype type;
    protected Color couleur;
    protected int rows;
    protected int cols;
    protected Point centre;


    public Case(char c, int rows, int cols,int centerX,int centerY){
        this.type = TypedeCase(c);
        this.couleur = SetCouleur(c);
        this.rows = rows;
        this.cols = cols;
        this.centre= new Point(centerX, centerY);
    }
    

    public Casetype TypedeCase(char casetype){
        switch (casetype) {
            case 'S' :
                return Casetype.SPAWN;
                
            case 'B' :
                return Casetype.BASE;
                
            case 'R' :
                return Casetype.ROUTE;
                
            case 'C' :
                return Casetype.CONSTRUCTIBLE;
                
            case 'X':
                return Casetype.DECOR;
                
            default:
                return null;
        }
    }


    public Casetype getType() {
        return type;
    }


    public Color getCouleur() {
        return couleur;
    }

    
    public int getRows() {
        return rows;
    }


    public int getCols() {
        return cols;
    }

    

    public double getCenterX() {
        return centre.getX();
    }

    public double getCenterY() {
        return centre.getY();
    }



    public Color SetCouleur(char casetype){
        switch (casetype) {
            case 'S' :
                return Color.RED;
                
            case 'B' :
                return Color.ORANGE;
                
            case 'R' :
                return new Color(194,178,128);
                
            case 'C' :
                return Color.LIGHT_GRAY;
                
            case 'X':
                return new Color(11,102,35);
                
            default:
                return Color.WHITE;
                
        }
    }


    public void afficheCase(double size){

        boolean Sourissurvole = Sourissurvole(this.centre.getX(), this.centre.getY(), size);


        Color couleur = this.couleur;//couleur de base 

        if(Sourissurvole&&SourisClique()) couleur = Color.YELLOW;//Si la case est cliquer
        //dessin de la case
        StdDraw.setPenColor(couleur);
        StdDraw.filledSquare(this.centre.getX(), this.centre.getY(), size / 2.0);

        

        //dessine le tour de la case et en couleur si cliquer
        if(Sourissurvole) couleur = Color.YELLOW;
        else couleur = Color.BLACK;
        StdDraw.setPenColor(couleur);
        StdDraw.square(this.centre.getX(), this.centre.getY(), size / 2.0);
    }


    // Vérifier si la souris est au-dessus de cette case
    public boolean Sourissurvole(double CentreX, double CentreY, double size) {
        return StdDraw.mouseX() > CentreX - size / 2.0 && StdDraw.mouseX() < CentreX + size / 2.0 && StdDraw.mouseY() > CentreY - size / 2.0 && StdDraw.mouseY() < CentreY + size / 2.0;
    }

    public boolean SourisClique(){
        if(StdDraw.isMousePressed()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Case [type=" + type + ", couleur=" + couleur + ", rows=" + rows + ", cols=" + cols + " position "+centre.toString()+"]";
    }

    
    
}
