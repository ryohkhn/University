public class Noeud{
    public int valeur;
    public Noeud droit;
    public Noeud gauche;

    public Noeud(int valeur,Noeud droit,Noeud gauche){
        this.valeur=valeur;
        this.droit=droit;
        this.gauche=gauche;
    }

    public Noeud(int valeur){
        this(valeur,null,null);
    }
}
