package Td2;

public class Pot {
    private Confiture confiture;
    private int quantite;
    private static int numero=0;

    public Pot(Confiture confiture,int quantite){
        this.confiture=confiture;
        this.quantite=quantite;
        numero++;
    }

    public String description(Pot p){
        return "Ce pot contient "+ this.quantite+"grammes de : " +this.confiture.description();
    }

    public static int getNumero(Confiture c1){
        return numero;
    }
}
