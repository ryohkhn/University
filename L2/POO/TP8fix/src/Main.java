import java.io.File;

public class Main {

    public static void main(String[] args) {
        File f=new File("/home/ryoh/Cours/2021/POO/TP8fix/src/test");
        Arbre.Noeud racine=new Arbre.Noeud(f);
        Arbre arbre=new Arbre(racine);
        StringTransformation addBlah=(s1)->(s1+".blaaah");
        //arbre.map(addBlah);
        arbre.supprimer("txt");
        arbre.afficher();
    }
}
