public class Main {

    public static void main(String[] args) {
        Noeud noeud10=new Noeud(10);
        Noeud noeud8=new Noeud(8);
        Noeud noeud9=new Noeud(9,noeud8,noeud10);
        Noeud noeud1=new Noeud(1);
        Noeud noeud2=new Noeud(2,null,noeud1);
        Noeud noeud4=new Noeud(4,noeud2,null);
        Noeud noeud3=new Noeud(3,null,noeud4);
        Noeud noeud6=new Noeud(6,noeud3,null);
        Noeud noeud7=new Noeud(7,noeud6,noeud9);
        Noeud noeud5=new Noeud(5,null,noeud7);
        Arbre arbre=new Arbre(noeud5);
        System.out.println(Rodriguez_Lucas.trasfBinGen(arbre).toString());
    }
}
