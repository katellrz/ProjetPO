package logistic;

import static outils.Omnicient.SavetoOmni;

import java.awt.Color;
import java.util.List;

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

        System.out.println("Arrive la 7");

        ZoneMap();
        System.out.println("Arrive la 8");
        ZoneLevel();
        System.out.println("Arrive la 9");
        ZonePlayer();
        System.out.println("Arrive la 10");
        ZoneBoutique();
        System.out.println("Arrive la 11");

        StdDraw.show();
       
    }
    
    public void AfficheDynamique(){
        Carte c1 = new Carte("10-10");

        List<Case> huhu = c1.getChemin();
        SavetoOmni(huhu);

        /* for (Case c : huhu) {
            System.out.println("Case : "+ c.toString());
        } */
        
        System.out.println("Arrive la 12");
        c1.afficheCarte();;
        System.out.println("Arrive la 13");

        StdDraw.show() ;
        System.out.println("Arrive la 14");
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
    }

    public static void ZoneBoutique(){
        Point center = new Point(856, 303);
        Point halfDist = new Point(144, 303);

        StdDraw.setPenColor(Color.BLACK);
        StdDraw.rectangle(center.getX(), center.getY(), halfDist.getX(), halfDist.getY());
    }
}
    //Zone Map
        


    /* //Zone Level
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.rectangle(center.getX(), center.getY(), halfDist.getX(), halfDist.getY());
    
    //Zone Player
        
        //tracer une pièce
        StdDraw.setPenColor(new Color(212, 175,55));
        StdDraw.filledCircle(center.getX(), center.getY(), radius);
        StdDraw.setPenColor(new Color(192, 192,192));
        StdDraw.filledCircle(center.getX(), center.getY(), 0.7 * radius);

         // Draw a heart
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
    }

}
 */