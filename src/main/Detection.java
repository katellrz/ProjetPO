package main;

import static outils.Omnicient.*;

import map.Case;

public abstract class Detection {

    /**
     * Détecte si une case est cliquée sur la carte.
     * 
     * @return La case cliquée ou null si aucune case n'est cliquée.
     */
    public static Case detectCaseClick() {
        for (int i = 0; i < getCarte().length; i++) {
            for (int j = 0; j < getCarte()[i].length; j++) {
                if (getCarte()[i][j].SourisCliqueCase(getSize())) {
                    return getCarte()[i][j];
                }
            }
        }
        return null; // Aucune case cliquée
    }
    
    

}
