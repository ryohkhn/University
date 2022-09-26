public class Main {

    public static void main(String[] args) {
        int[] t={1,3,6,7};
        int[] t2={2,4,6};
        int[] t3={2,12,36,7};
        String s="yo le rap";
        //Ex2.affiche(Ex2.multiplication(t,t2));
        //System.out.println(s.length());
        //Ex2.split(t);
        //Ex2.affiche(Ex2.split(t3));
        //Ex3.Shift(args);
        //Ex4.evaluation(3);
        Personnage Lucas=new Personnage("Lucas");
        Personnage Vincent=new Personnage("Vincent");
        Vincent.getActuel().setForce(12);
        Vincent.getActuel().setAgilite(8);
        Lucas.lutteRec(Vincent);
    }
}
