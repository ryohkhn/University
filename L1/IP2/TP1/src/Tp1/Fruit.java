package Tp1;

public class Fruit {
    public String nom;
    public int poids;

    public Fruit(String nom, int poids){
        this.nom=nom;
        this.poids=poids;
    }

    public static void afficher(Fruit f){
        System.out.println("Ce fruit est un(e) "+ f.nom +" et pèse "+ f.poids + " grammes.");
    }

    static Fruit hybridation(Fruit f1, Fruit f2){
        String nom= "(" + f1.nom + f2.nom + ")";
        int poids= f1.poids + f2.poids;
        return new Fruit(nom,poids);
    }


}
