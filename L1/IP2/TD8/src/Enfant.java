public class Enfant {
    private String nom;
    private int nbr;

    public Enfant(String nom){
        this.nom=nom;
        this.nbr=0;
    }

    public String getNom() {
        return nom;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }


    public void afficher(){
        System.out.println(this.nom+" a glissé "+this.nbr+" fois");
    }
}
