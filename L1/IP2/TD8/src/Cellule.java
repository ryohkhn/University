public class Cellule {
    private Enfant enfant;
    private Cellule suivant;
    private Cellule precedent;

    public Cellule(Enfant e){
        this.enfant=e;
        this.suivant=this;
        this.precedent=this;
    }

    public Cellule getSuivant() {
        return suivant;
    }

    public Cellule getPrecedent() {
        return precedent;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public void setSuivant(Cellule suivant) {
        this.suivant = suivant;
    }

    public void setPrecedent(Cellule precedent) {
        this.precedent = precedent;
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    public void ajouter(Enfant e){
        Cellule c=new Cellule(e);
        c.suivant=this;
        c.precedent=this.precedent;
        this.precedent.suivant=c;
        this.precedent=c;
    }

    public void supprimer(String nom){
        Cellule tmp=this.suivant;
        while(tmp!=this){
            if(tmp.enfant.getNom().equals(nom)){
                tmp.suivant.precedent=tmp.precedent;
                tmp.precedent.suivant=tmp.suivant;
            }
            tmp=tmp.suivant;
        }
    }

    public void afficher(){
        this.enfant.afficher();
        Cellule tmp=this.suivant;
        while(tmp!=this){
            tmp.enfant.afficher();
            tmp=tmp.suivant;
        }
    }
}
