package map;

import static outils.Omnicient.*;

import java.util.ArrayList;
import java.util.List;

import logistic.FileExtraction;
import outils.StdDraw;

public class Carte {

    private String nom;
    private Case[][] MatriceCarte2D;
    // private int rows;
    // private int cols;
    private int tailleCase;
    
    private List<Case> Chemin;



    /**
     * Constructeur de classe
     * @param nom le nom de la carte (celui present sur le fichier)
     */
    public Carte(String nom){
        this.nom=nom;
        this.MatriceCarte2D = ConvertiCase();
        if (this.MatriceCarte2D == null){
            System.out.println("Construteur , matrice carte null");
        }
        // this.rows = MatriceCarte2D.length;
        // this.cols = MatriceCarte2D[0].length;
        this.Chemin = ConstruitChemin();
    }

    public List<Case> getChemin(){
        return Chemin;
    }

    public String GetNom(){
        return nom;
    }

    public Case[][] GetCarte(){
        return MatriceCarte2D;
    }

    public void SetTailleCase(int tailleCase){
        this.tailleCase = tailleCase;
    }

    public int getTailleCase(){
        return this.tailleCase;
    }


    /**
     * Extrait une carte depuis un fichier de type .mtp et la convertit en une liste (Arrays list) de String, ou une String corespond a une ligne.
     *
     * @return Une List de String représentant les lignes de la carte.
     * 
     * Ici l'IA a été utilisé pour corriger le code qui ne fonctionait l'IA a sugeré de rajouter les viriable rows et cols 
     */
    public Case[][] ConvertiCase(){
        String filePath="resources/maps/"+this.nom+".mtp";
        List <String> tabStrings = FileExtraction.ExtraireFichier(filePath);//on utilise la fonction qui nous permet de lire la fonction précédente 
        
        if (tabStrings == null || tabStrings.isEmpty()) {//verification et Debug
            System.out.println("Erreur: fichier de carte introuvable ou vide.");
            return null;
        }


        int rows = tabStrings.size();//compte le nombre de Ligne 
        int cols = tabStrings.get(0).length();//compte le nombre de Colone 

        //calcul des dimention globale pour centrer la carte 
        int tailleCase = 700 / Math.max(rows, cols);
        this.SetTailleCase(tailleCase);//on initialise la taille de chaque case 
        int startX = (cols > rows) ? (Math.abs(cols - rows) / 2) * tailleCase : 0;
        int startY = (rows > cols) ? (Math.abs(rows - cols) / 2) * tailleCase : 0;


        Case[][] MatriceCarte = new Case[rows][cols];

        try {//ajout d'un try catch en debug 
            for (int i = 0; i < rows; i++) {
                String ligne = tabStrings.get(i);
                for (int j = 0; j < cols; j++) {
                    //calcul des coordonnée pour avoir le cenrte de chaque case 
                    int centerX = startX + j * tailleCase + tailleCase / 2;
                    int centerY = startY + (rows - 1 - i) * tailleCase + tailleCase / 2;

                    MatriceCarte[i][j] = new Case(ligne.charAt(j), i, j, centerX, centerY);
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la conversion des cases: " + e.getMessage());
            e.printStackTrace();
            return null;
        } 
        return MatriceCarte;
    }//on return la matrice de Case
    

       


    /**
     * Affiche la carte en appelant un fonction qui dessine chaque cas
     * 
     */
    public void afficheCarte(){ 
        for (int i = 0; i<MatriceCarte2D.length;i++) {//pour chaque ligne 
            for(int j = 0; j<MatriceCarte2D[0].length; j++){// pour chaque colone 
                MatriceCarte2D[i][j].afficheCase(this.tailleCase);
            }
        }       
    }

    /**
     * Cherche la case suivate a partitr d'un tableaux de case cette direction est chercher sur les case autour de la case actuelle sans prendre en compte le diagonale 
     * @param current case actuelle dont on veux trouver la case suivante
     * @param chemin liste des case deja visité (qui corrspondent au case du chamin déja construit )
     * @return la case suivante a devoir être ajouté au chemin
     * Cette fonction a été soumise a l'IA pour la structure et l'utilisation du tableau de direction qui ne fonctionait pas en raison d'une mauvais initialisation et utilisation par la suite 
     *
     */
    private Case TrouveCaseSuivante(Case current, List<Case> chemin) {
        int row = current.rows; // Coordonnées actuelles
        int col = current.cols;
    
        // Directions possibles : Haut, Bas, Gauche, Droite
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
    
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
    
            // Vérifie si la case voisine est valide (pas forcement nécéssaire car les case sont entoure er de decor)
            if (newRow >= 0 && newRow < MatriceCarte2D.length && newCol >= 0 && newCol < MatriceCarte2D[0].length) {
                Case nextCase = MatriceCarte2D[newRow][newCol];
                if ((!chemin.contains(nextCase)) && nextCase.getType() == Casetype.ROUTE||nextCase.getType() == Casetype.BASE ) {
                    return nextCase; // Retourne la première case valide
                }
            }
        }
        return null; // Aucun voisin route ou base trouvé
    }


    public List<Case> ConstruitChemin(){
        List<Case> chemin = new ArrayList<>();

        Case start = Spawn();//Trouve la case depart
        SavetoOmniSpawn(start);

        if (start == null) {    
            System.out.println("Pas de case SPAW trouvée la carte n'est pas valide");
            return chemin;
        }

        chemin.add(start);
        return ConstruitCheminRecursive(start, chemin);
    }

    /**
     * Fonction recursive qui construit le chemin petit a petit, 
     * @return la liste chemin 
     */
    private List<Case> ConstruitCheminRecursive(Case current, List<Case> chemin) {
        if(current.getType()==Casetype.BASE){
            //System.out.println("Arrive la ");
            SavetoOmniBase(current);
            return chemin;
        }else{
            //System.out.println("Arrive la ");
            Case nextCase = TrouveCaseSuivante(current, chemin);
            if (nextCase != null) {
                //System.out.println("Arrive la vrl");
                chemin.add(nextCase);
                return ConstruitCheminRecursive(nextCase, chemin);
            }else{
                return null;
            }
        }
    }
    
    /**
     * Trouve le spawn de la map et le return 
     * Cette fonction e été soumise a chat GPT pour la solifier( géré les cas ou )
     * @return une case de type Spawn
     */
    public Case Spawn() {
        if (MatriceCarte2D == null) {
            System.out.println("MatriceCarte2D est null");
            return null;
        }
    
        for (int i = 0; i < MatriceCarte2D.length; i++) {
            if (MatriceCarte2D[i] == null) continue; // Vérifiez si la ligne est null
    
            for (int j = 0; j < MatriceCarte2D[i].length; j++) {
                if (MatriceCarte2D[i][j] != null && MatriceCarte2D[i][j].getType() == Casetype.SPAWN) {
                    //System.out.println("trouvé");
                    return MatriceCarte2D[i][j];
                }
            }
        }
        //System.out.println("null");
        return null;
    }
}
