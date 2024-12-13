
import java.awt.Color;
public class InterfaceJoueur{

    



    public void AfficheInterface(){

        StdDraw.setCanvasSize(1024, 720);
        StdDraw.setXscale(-12, 1012);
        StdDraw.setYscale(-10, 710);
        StdDraw.enableDoubleBuffering();

        ZoneMap();
        ZoneLevel();
        ZonePlayer();
        ZoneBoutique();

        

        Carte c1 = new Carte("10-10");
        c1.afficheCarte();;

        StdDraw.show();

        
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