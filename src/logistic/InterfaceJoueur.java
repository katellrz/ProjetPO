package logistic;

import static outils.Omnicient.SaveToOmni;
import static outils.Omnicient.SavetoOmni;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import main.Joueur;

import static main.Joueur.*;
import map.Carte;
import map.Case;
import map.Point;
import outils.StdDraw;
public class InterfaceJoueur{



    public void AfficheInterface(){

        StdDraw.setCanvasSize(1024, 720);
        StdDraw.setXscale(-12, 1012);
        StdDraw.setYscale(-10, 710);
        StdDraw.enableDoubleBuffering();
        StdDraw.show();
       
    }
    
    public void AfficheDynamique(){
        ZoneMap();
        ZoneLevel();
        ZonePlayer();
        ZoneBoutique();

        Carte c1 = new Carte("10-10");
        SaveToOmni(c1.GetCarte());

        List<Case> huhu = c1.getChemin();
        SavetoOmni(huhu);        
        
        c1.afficheCarte();;
        
        StdDraw.show() ;
    
    }

    public static void ZoneMap(){
        Point center = new Point(350, 350);
        Point halfDist = new Point(350, 350);

        StdDraw.setPenColor(Color.BLACK);
        StdDraw.rectangle(center.getX(), center.getY(), halfDist.getX(), halfDist.getY());
    }

    public static void ZoneLevel(){
        Point center = new Point( 856, 688);
        Point halfDist = new Point(144, 12);

        StdDraw.setPenColor(Color.BLACK);
        StdDraw.rectangle(center.getX(), center.getY(), halfDist.getX(), halfDist.getY());
    }

    public static void ZonePlayer(){
        Point center = new Point( 856, 641);
        Point halfDist = new Point( 144, 25);

        StdDraw.setPenColor(Color.BLACK);
        StdDraw.rectangle(center.getX(), center.getY(), halfDist.getX(), halfDist.getY());

        Point centerC = new Point(740,641);
        int radius = 20;

        StdDraw.setPenColor(new Color(212, 175,55));
        StdDraw.filledCircle(centerC.getX(), centerC.getY(), radius);
        StdDraw.setPenColor(new Color(192, 192,192));
        StdDraw.filledCircle(centerC.getX(), centerC.getY(), 0.7 * radius);


        int halfHeight = 20;
        StdDraw.setPenColor(new Color(223, 75, 95));
        double[] listX = new double[]
        {
            center.getX(),
            center.getX()- halfHeight,
            center.getX()- halfHeight,
            center.getX()- 0.66 * halfHeight,
            center.getX()- 0.33 * halfHeight,
            center.getX(),
            center.getX() + 0.33 * halfHeight,
            center.getX() + 0.66 * halfHeight,
            center.getX() + halfHeight,
            center.getX() + halfHeight,
        };
        double[] listY = new double[]
        {
            center.getY()- halfHeight,
            center.getY(),
            center.getY() + 0.5 * halfHeight,
            center.getY() + halfHeight,
            center.getY() + halfHeight,
            center.getY() + 0.5 * halfHeight,
            center.getY() + halfHeight,
            center.getY() + halfHeight,
            center.getY() + 0.5 * halfHeight,
            center.getY(),
        };
        StdDraw.filledPolygon(listX, listY);

        StdDraw.text(radius, halfHeight, Integer.toString(getPV()) );


        
    }

    public  void afficheInfoJoueur() {
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledRectangle(857, 638, 94, 20);
		Point centerPVBase = new Point(925, 638);
		StdDraw.setPenColor(new Color(223, 75, 95));
		StdDraw.setFont(new Font("Serif", Font.PLAIN, 30));
		StdDraw.text(centerPVBase.getX(), centerPVBase.getY(), Integer.toString(getPV()));
		StdDraw.show();
		Point centerPiece = new Point(799, 638);
		StdDraw.setPenColor(new Color(212, 175, 55));
		StdDraw.text(centerPiece.getX(), centerPiece.getY(), Integer.toString(getMoney()));
		StdDraw.show();
	}

    public static void ZoneBoutique(){
        Point center = new Point(856, 303);
        Point halfDist = new Point(144, 303);

        StdDraw.setPenColor(Color.BLACK);
        StdDraw.rectangle(center.getX(), center.getY(), halfDist.getX(), halfDist.getY());
    }
}
