import java.util.LinkedList;

public class Dossier extends Element implements Affichable{
    private LinkedList<Entree> list;
    private Dossier parent;

    public Dossier(){
        this.parent=null;
        this.list=new LinkedList<>();

        EntreeSpeciale point=new EntreeSpeciale(this,".",this);
        this.list.add(point);
    }

    public Dossier(Dossier parent){
        this.parent=parent;
        this.list=new LinkedList<>();

        EntreeSpeciale point=new EntreeSpeciale(this,".",this);
        this.list.add(point);
        // si le dossier parent est null on ne crée pas l'objet spéciale .., cela peut créer des problèmes
        if(parent!=null){
            EntreeSpeciale doublepoint=new EntreeSpeciale(this,"..",parent);
            this.list.add(doublepoint);
        }
    }

    public Dossier getParent(){
        return parent;
    }

    public void setParent(Dossier parent){
        this.parent=parent;
    }

    public LinkedList<Entree> getList(){
        return list;
    }

    @Override
    public String getType(){
        return "dossier";
    }

    public Entree getEntree(String nom,boolean creer){
        // on regarde dans toutes les entrées de la list courante si l'entrée est présente
        for(Entree entree : this.list){
            if(entree.getNom().equals(nom)){
                // on retourne l'entrée si c'est le cas
                return entree;
            }
        }
        // si l'entrée est à créer on le fait et on retourne l'entrée
        if(creer){
            list.add(new Entree(this,nom,null));
            return list.getLast();
        }
        return null;
    }

    @Override
    //  affichage de toutes les entrées
    public void afficher(){
        for(Entree entree : this.list){
            System.out.println(entree);
        }
    }

    public boolean estEnfantDe(Dossier o){
        // si le parent est null on ne peut pas remonter pour récupérer l'entrée correspondante au dossier
        if(this.parent==null){
            return false;
        }
        Entree tmp=null;
        for(Entree entree : this.parent.list){
            // on regarde si l'objet dossier est présent dans les entrées du parent
            if(entree.getElement().equals(o)){
                tmp=entree;
            }
        }
        if(tmp==null) return false;
        // si c'est le cas on return true
        if(o.getEntree(tmp.getNom(),false)!=null){
            return true;
        }
        return false;
    }
}
