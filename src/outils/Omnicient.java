package outils;
import map.Case;

import java.util.LinkedList;
import java.util.List;
import entites.Enemi;
import entites.Tours;

public abstract class Omnicient {

    private static List<Enemi> positionMonstre = new LinkedList<>();
    private static List<Tours> positionTours = new LinkedList<>();
    private static Case Spawn;
    private static Case Base;
    private static List<Case> Chemin;

    
    public static void SavetoOmni(List<Case> chemin) {
        Chemin = chemin;
    }

    public static void SavetoOmni(Enemi e) {
        positionMonstre.add(e);
    }

    public static void SavetoOmni(Tours e) {
        positionTours.add(e);
    }

    public static void SavetoOmniBase(Case base) {
        Base = base;
    }

    public static void SavetoOmniSpawn(Case spawn) {
        Spawn = spawn;
    }

    
    public static List<Enemi> getPositionMonstre() {
        return positionMonstre;
    }

    public static List<Tours> getPositionTours() {
        return positionTours;
    }

    public static Case getSpawn() {
        return Spawn;
    }

    public static Case getBase() {
        return Base;
    }

    public static List<Case> getChemin() {
        return Chemin;
    }



    
}
