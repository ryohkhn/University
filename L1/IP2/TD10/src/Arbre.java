public class Arbre {
    private Noeud racine;

    public Arbre(Noeud racine){
        this.racine=racine;
    }

    public Arbre(){
        this(null);
    }

    public void afficher(){
        if (this.racine != null){
            this.racine.afficher();
        }
    }

    public void bourgeons(){
        if(this.racine!=null){
            this.racine.bourgeons();
        }
    }

    public void elagage(){
        if(this.racine.estFeuille()){
            this.racine=null;
        }
        else{
            if(this.racine!=null){
                this.racine.elagage();
            }
        }
    }

    public void croissance(){
        if(this.racine!=null){
            this.racine.croissance();
        }
    }

    public void decroissance(){
        if(this.racine!=null){
            this.racine.decroissance();
        }
    }

    public int valueCalcul(){
        if(this.racine!=null){
            return this.racine.valueCalcul();
        }
        return 0;
    }
}
