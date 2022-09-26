public class ListeDEntiers {
    private Cellule premier;

    public ListeDEntiers(){
        this.premier=null;
    }

    public void setPremier(Cellule premier) {
        this.premier = premier;
    }

    public void add(int x){
        Cellule res=new Cellule(x,premier);
        this.premier=res;
    }

    public String description(){
        if(this.premier==null){
            return "()";
        }
        return "("+this.premier.description()+")";
    }

    public int taille(){
        if(this.premier==null){
            return 0;
        }
        return this.premier.taille();
    }

    public int somme(){
        if(this.premier==null){
            return 0;
        }
        return this.premier.somme();
    }

    public void ajouter_en_i(int i,int v){
        if(this.premier==null || i<=0){
            add(v);
            return;
        }
        this.premier.ajouter_en_i(i,v);
    }

    public boolean supprimer_en_i(int i){
        if(this.premier==null){
            return false;
        }
        return this.premier.supprimer_en_i(i);
    }
}
