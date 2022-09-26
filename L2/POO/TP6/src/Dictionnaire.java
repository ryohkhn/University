import java.util.Arrays;

public class Dictionnaire implements Triable{
    private String[] tab;

    public Dictionnaire(String[] tab){
        this.tab=tab;
    }

    @Override
    public void echange(int i, int j){
        String tmp=tab[i];
        tab[i]=tab[j];
        tab[j]=tmp;
    }

    // On utilise compareTo qui compare l'odre lexicographique de deux String, la fonction return un nombre positif si le String de l'objet se trouve après celui en argument et inversement.
    @Override
    public boolean plusGrand(int i, int j){
        if(tab[i].compareTo(tab[j])>0){
            return true;
        }
        return false;
    }

    @Override
    public int taille(){
        return this.tab.length;
    }

    @Override
    public String toString(){
        return "Dictionnaire{"+"tab="+Arrays.toString(tab)+'}';
    }
}
