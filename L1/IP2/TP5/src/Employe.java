public class Employe {
    private final String nom;
    private int salaire;

    public Employe(String nom,int salaire){
        this.nom=nom;
        this.salaire=salaire;
    }

    public String getNom() {
        return nom;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public void afficher(){
        System.out.println(nom +", avec un salaire de "+salaire+"€");
    }

    public boolean augmente(String nom, int montant) {
        this.salaire+=montant;
        return true;
    }
}
