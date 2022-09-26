public class Cellule {
    private int valeur;
    private Cellule suivante;

    public Cellule(int valeur,Cellule suivante){
        this.valeur=valeur;
        this.suivante=suivante;
    }

    public int getValeur() {
        return valeur;
    }

    public Cellule getSuivante() {
        return suivante;
    }

    public void setSuivante(Cellule suivante) {
        this.suivante = suivante;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Cellule(int valeur){
        this(valeur,null);
    }

    public String description(){
        String res=Integer.toString(this.valeur);
        if(this.suivante==null){
            return res;
        }
        return res+";"+this.suivante.description();
    }

    public int taille(){
        int res=0;
        res++;
        if(this.suivante==null){
            return res;
        }
        return res+this.suivante.taille();
    }

    public int somme(){
        int res=this.valeur;
        if (this.suivante == null){
            return res;
        }
        return res+this.suivante.somme();
    }

    public void ajouter_en_i(int i,int v){
        if(this.suivante!=null && i>1){
            this.suivante.ajouter_en_i(i-1,v);
        }
        else{
            this.suivante= new Cellule(v,this.suivante);
        }
    }

    public boolean supprimer_en_i(int i){
        return true;
    }
}
