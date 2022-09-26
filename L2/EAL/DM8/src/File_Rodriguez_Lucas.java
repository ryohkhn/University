public class File_Rodriguez_Lucas{
    private int[] tab;
    private final int tailleMax;
    private int head;
    private int last;

    public File_Rodriguez_Lucas(int taille){
        this.tab=new int[taille];
        this.head=0;
        this.last=0;
        this.tailleMax=tab.length-1;
    }

    public void put(int val){
        // si le tableau est vide on ajoute au head, le last ne change pas
        if(empty()){
            tab[head]=val;
        }
        // si le last est en dernière position
        else if(last==tailleMax){
            // si le head n'est pas 0 alors alors on ajoute la valeur au début du tableau, sinon il est plein et on ne fait rien
            if(head!=0){
                tab[0]=val;
                // on change last à la valeur du début du tableau
                last=0;
            }
        }
        // si le tableau n'est pas plein on ajoute la valeur au suivant de last, et on actualise last
        else if(last+1!=head){
            tab[last+1]=val;
            last=last+1;
        }
    }

    public int get(){
        int tmp;
        // si le tableau est vide on ne fait rien
        if(empty()) return 0;
        // si il y'a une seule valeur dans le tableau, on l'enlève mais on ne modifie pas le head
        if(head==last){
            tmp=tab[head];
            tab[head]=0;
            return tmp;
        }
        // si le head se trouve en fin de tableau, on retire la valeur et on met le head à 0
        if(head==tailleMax){
            tmp=tab[head];
            tab[head]=0;
            head=0;
            return tmp;
        }
        // sinon, on retire la valeur du head, et le head se trouve donc à la case suivant
        tmp=tab[head];
        tab[head]=0;
        head=head+1;
        return tmp;
    }

    public boolean empty(){
        // le tableau est vide seulement si le last est au même endroit que le head, et que sa valeur est vide
        if(head==last && tab[head]==0) return true;
        return false;
    }


}
