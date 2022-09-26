import java.util.LinkedList;

public class Ligne extends ChaineCar{
    private LinkedList<ChaineCar> suite;

    public Ligne(){
        this.suite=new LinkedList<>();
    }

    // on additionne les longueurs de tous les mots dans la suite
    @Override
    public int len(){
        int res=0;
        for(ChaineCar chaine:suite){
            res+=chaine.len();
        }
        return res;
    }

    // on crée un string avec tous les mots de la suite de mots additionnés
    @Override
    public String toString(){
        String res="";
        for(ChaineCar chaine:suite){
            res+=chaine.toString();
        }
        return res;
    }

    public boolean isEmpty(){
        if(suite==null || suite.isEmpty()) return true;
        return false;
    }

    public void addChaine(ChaineCar chaine){
        suite.add(chaine);
    }

    public LinkedList<ChaineCar> getSuite(){
        return suite;
    }
}
