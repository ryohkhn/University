import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Noeud a=new Noeud(4);
        Noeud b=new Noeud(1,a,null);
        Noeud c=new Noeud(0,null,null);
        Noeud d=new Noeud(7,c,b);
        Noeud e=new Noeud(8,null,null);
        Noeud f=new Noeud(6,null,e);
        Noeud g=new Noeud(2,null,null);
        Noeud h=new Noeud(9,g,f);
        Noeud i=new Noeud(5,h,null);
        Noeud j=new Noeud(3,i,d);
        Arbre arbre=new Arbre(j);

        LinkedList<Noeud> maFile=new LinkedList<>();
        maFile.offer(j);
        maFile.offer(i);
        maFile.offer(d);
        maFile.offer(h);
        maFile.offer(c);
        maFile.offer(b);
        maFile.offer(g);
        maFile.offer(f);
        maFile.offer(a);
        maFile.offer(e);

        System.out.println(i.profondeur());
        System.out.println(d.profondeur());
        //Arbre.afficher(maFile,arbre.profondeur());
    }
}
