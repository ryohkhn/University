import java.util.Arrays;

public class TabEntiersTriable implements Triable{
    private int[] tab;

    public TabEntiersTriable(int[] tab){
        this.tab=tab;
    }

    @Override
    public void echange(int i, int j){
        int tmp=tab[i];
        tab[i]=tab[j];
        tab[j]=tmp;
    }

    @Override
    public boolean plusGrand(int i, int j){
        if(tab[i]>tab[j]) return true;
        return false;
    }

    @Override
    public int taille(){
        return this.tab.length;
    }

    @Override
    public String toString(){
        return "TabEntiersTriable{"+"tab="+Arrays.toString(tab)+'}';
    }
}
