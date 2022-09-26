public class Noeud{
    public String value;
    public Noeud droit=null;
    public Noeud gauche=null;

    public Noeud(String value,Noeud droit,Noeud gauche){
        this.value=value;
        this.droit=droit;
        this.gauche=gauche;
    }

    public Noeud(String value){
        this(value,null,null);
    }
}
