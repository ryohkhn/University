public class Main {

    public static void main(String[] args) {
        ListeDEntiers l=new ListeDEntiers();
        l.add(10);
        l.add(3);
        l.add(4);
        l.add(1);
        System.out.println(l.description());
        System.out.println(l.taille());
        System.out.println(l.somme());
        l.ajouter_en_i(6,4);
        System.out.println(l.description());
    }
}
