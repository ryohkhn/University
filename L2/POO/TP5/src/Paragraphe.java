import java.util.LinkedList;

public class Paragraphe extends ChaineCar{
    protected LinkedList<Ligne> suite;

    public Paragraphe(){
        suite=new LinkedList<>();
    }

    public boolean isEmpty(){
        for(Ligne ligne:suite){
            if(!ligne.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public void addChaine(ChaineCar chaine){
        if(this.suite.isEmpty()){
            Ligne first=new Ligne();
            first.addChaine(chaine);
            this.suite.add(first);
        }
        else{
            this.suite.getLast().addChaine(chaine);
        }
    }

    @Override
    public String toString(){
        String res="";
        // on affiche la ligne et on ajoute un saut de ligne dans le string pour l'affichage correct des paragraphes
        for(Ligne ligne:suite){
            res+=ligne.toString();
            res+="\n";
        }
        return res;
    }
}
