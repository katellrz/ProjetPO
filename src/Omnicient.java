import map.Case;

import java.util.LinkedList;
import java.util.List;
import entites.Enemi;
import entites.Tours;

public abstract class Omnicient {

    public List<Enemi> positionMonstre = new LinkedList<>();
    public List<Tours> positionTours = new LinkedList<>();

    public Case Spawn;
    public Case Base;

    public List<Case> Chemin;




    public void SavetoOmni (List<Case> chemin){
        this.Chemin=chemin;
    }

    public void SavetoOmni (Enemi e){
        this.positionMonstre.add(e);
    }

    public void SavetoOmni (Tours e){
        this.positionTours.add(e);
    }

    public void SavetoOmniBase (Case base){
        this.Base=base;
    }

    public void SavetoOmniSpawn (Case spawn){
        this.Spawn=spawn;
    }

    

    
}
