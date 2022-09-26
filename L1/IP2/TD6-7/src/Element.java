public class Element {
    private int valeur;
    private Element suivant;
    private Element precedent;

    public Element(int valeur,Element suivant,Element precedent){
        this.valeur=valeur;
        this.suivant=suivant;
        this.precedent=precedent;
    }

    public void setPrecedent(Element precedent) {
        this.precedent = precedent;
    }

    public void setSuivant(Element suivant) {
        this.suivant = suivant;
    }

    public Element getSuivant() {
        return suivant;
    }

    public Element getPrecedent() {
        return precedent;
    }

    public int getValeur() {
        return valeur;
    }

    public int longueur(){
        if(this.suivant==null){
            return 1;
        }
        return 1+this.suivant.longueur();
    }

    public String afficher(){
        if(this.suivant==null){
            return Integer.toString(this.valeur);
        }
        return this.valeur+","+this.suivant.afficher();
    }

    public String afficherInverse(){
        if(this.precedent==null){
            return Integer.toString(this.valeur);
        }
        return this.valeur+","+this.precedent.afficher();
    }

    public void ajouterAvant(Element e,int valeur){
        if(this.suivant==null){
            return;
        }
        if(this.suivant.equals(e)){
            Element res=new Element(valeur,this.suivant,this);
            this.suivant.precedent=res;
            this.suivant=res;
        }
        this.suivant.ajouterAvant(e,valeur);
    }

    public void supprimer(Element e){
        if(e==this) {
            if (this.precedent != null) {
                this.precedent.suivant = this.suivant;
            } else {
                this.suivant.precedent = null;
            }
        }
        else{
            if(this.suivant==null){
                return;
            }
            this.suivant.supprimer(e);
        }
    }

    public int somme(){
        if(this.suivant==null){
            return this.valeur;
        }
        return this.valeur+this.suivant.somme();
    }

    public boolean estTriee(){
        if(this.suivant==null){
            return true;
        }
        if(this.valeur>this.suivant.valeur){
            return false;
        }
        return this.suivant.estTriee();
    }
}