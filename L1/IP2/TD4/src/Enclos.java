public class Enclos{
    private Cellule debut;

    public Enclos(){
        this.debut=null;
    }

    public void ajouter(String regime){
        Cellule x=new Cellule(regime);
        x.setSuivant(this.debut);
        this.debut=x;
    }

    public int compt(){
        if(this.debut==null){
            return 0;
        }
        return this.debut.compt();
    }

    public void transform(){
        if(this.debut==null){
            return;
        }
        this.debut.transform();
    }

    public void afficher(){
        if(this.debut==null){
            return;
        }
        this.debut.afficher();
    }

    public void etapeDeux(){
        if (this.debut == null){
            return;
        }
        this.debut.etapeDeux();
    }
}
