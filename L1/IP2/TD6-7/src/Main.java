public class Main {

    public static void main(String[] args) {
        Liste test=new Liste();
        test.ajouterDebut(10);
        test.ajouterDebut(12);
        test.ajouterFin(99);
        test.ajouterFin(18);
        test.afficher();
        test.trier();
        test.afficher();
    }
}
