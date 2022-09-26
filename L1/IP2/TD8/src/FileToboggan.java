public class FileToboggan {
    private Cellule courant;
    private int nbrMax;

    public FileToboggan(int nbrMax){
        this.courant=null;
        this.nbrMax=nbrMax;
    }

    public Cellule getCourant() {
        return courant;
    }

    public void ajouter(String nom, int nbr){
        Enfant e=new Enfant(nom);
        e.setNbr(nbr);
        if(this.courant==null){
            this.courant=new Cellule(e);
        }else{
            this.courant.ajouter(e);
        }
    }

    public void supprimer(String nom){
        if(this.courant==null){
            return;
        }
        if(this.courant.getEnfant().getNom().equals(nom)){
            if(this.courant==this.courant.getSuivant()){
                this.courant=null;
            }
            else{
                this.courant.getSuivant().setPrecedent(this.courant.getPrecedent());
                this.courant.getPrecedent().setSuivant(this.courant.getSuivant());
                this.courant=this.courant.getSuivant();
            }
        }
        else{
            this.courant.supprimer(nom);
        }
    }

    public void afficher(){
        if(this.courant==null){
            System.out.println("()");
            return;
        }
        this.courant.afficher();
    }

    public Enfant unTour(){
        if(this.courant==null){
            return null;
        }
        Enfant e=this.courant.getEnfant();
        e.setNbr(e.getNbr()+1);
        e.afficher();
        if(e.getNbr()>=nbrMax){
            supprimer(e.getNom());
            return(e);
        }else{
            this.courant=this.courant.getSuivant();
            return null;
        }
    }
}
