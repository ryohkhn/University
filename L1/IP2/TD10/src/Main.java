public class Main {

    public static void main(String[] args) {
        Noeud n1=new Noeud();
        Noeud n2=new Noeud(n1,null,2);
        Noeud n3=new Noeud();
        Noeud n4=new Noeud(n3,n2,3);
        Noeud n5=new Noeud();
        Noeud n6=new Noeud(null,n5,6);
        Noeud n7=new Noeud(n4,n6,0);
        Arbre a=new Arbre(n7);

        System.out.println(a.valueCalcul());
    }
}
