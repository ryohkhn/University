import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Noeud a=new Noeud("3");
        Noeud b=new Noeud("6");
        Noeud c=new Noeud("x");
        Noeud d=new Noeud("/",b,a);
        Noeud e=new Noeud("2");
        Noeud f=new Noeud("1");
        Noeud g=new Noeud("-",d,c);
        Noeud h=new Noeud("+",f,e);
        Noeud i=new Noeud("*",h,g);
        Noeud j=new Noeud("-",null,i);
        Arbre arbre=new Arbre(j);

        j.afficheExpression();
        System.out.println(j.evaluer(-2));
    }
}
