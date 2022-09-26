public class Main {
    public static void main(String[] args) {
        Enclos a=new Enclos();
        a.ajouter("carnivore");
        a.ajouter("herbivore");
        a.ajouter("herbivore");
        Enclos b=new Enclos();
        b.ajouter("carnivore");
        b.ajouter("herbivore");
        b.ajouter("herbivore");
        b.ajouter("herbivore");
        b.afficher();
        System.out.println("----------");
        b.etapeDeux();
        b.afficher();
    }
}
