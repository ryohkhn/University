public class Entree{
    private Element element;
    private String nom;
    private Dossier parent;

    public Entree(Dossier p,String n,Element e){
        this.parent=p;
        this.nom=n;
        this.element=e;
    }

    public String toString(){
        String res="";
        if(this.element==null){
            res="entrée vide";
        }
        else if(element.getType().equals("dossier")){
            res="dossier";
        }
        else if(element.getType().equals("texte")){
            res="texte";
        }
        return this.nom+" ("+res+")";
    }

    public String getNom(){
        return this.nom;
    }

    public Element getElement(){
        return this.element;
    }

    public Dossier getParent(){
        return parent;
    }

    public void supprimer(){
        // si le parent est déjà null on ne fait rien
        if(this.parent==null){
            return;
        }
        // on retire l'entrée de la list du parent et on retire la référence au parent
        this.parent.getList().remove(this);
        this.parent=null;
    }

    // setter pour l'élément
    public void remplacer(Element e){
        this.element=e;
    }
}
