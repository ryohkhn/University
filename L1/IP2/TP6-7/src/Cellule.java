public class Cellule{
    private Cellule suivante;
    private Cellule precedente;
    private boolean noire;
    private boolean prochaintEtat;

    public Cellule getSuivante() {
        return suivante;
    }

    public Cellule getPrecedente() {
        return precedente;
    }

    public boolean getNoire(){
        return noire;
    }

    public void setSuivante(Cellule suivante) {
        this.suivante=suivante;
    }

    public void setPrecedente(Cellule precedente) {
        this.precedente=precedente;
    }

    public Cellule(boolean noire){
        this.noire=noire;
        this.suivante=null;
        this.precedente=null;
        this.prochaintEtat=false;
    }

    public void afficher(){
        if(noire){
            System.out.print("#");
        }else{
            System.out.print("-");
        }
        if(this.suivante==null){
            return;
        }
        this.suivante.afficher();
    }

    public void afficherProchain(){
        if(this.prochaintEtat){
            System.out.print("#");
        }else{
            System.out.print("-");
        }
        if(this.suivante==null){
            return;
        }
        this.suivante.afficherProchain();
    }

    public void prochaineEtape(){
        if(this.suivante==null && this.precedente==null){
            if (!this.noire){
                this.prochaintEtat=false;
                return;
            }
            else{
                this.prochaintEtat=true;
                return;
            }
        }
        if(this.precedente==null){
            if(this.noire==false && this.suivante.noire==false){
                this.prochaintEtat=false;
            }
            else {
                this.prochaintEtat=true;
            }
        }
        else if(this.suivante==null){
            if (this.noire==false && this.precedente.noire==false){
                this.prochaintEtat=false;
                return;
            }
            else{
                this.prochaintEtat=true;
                return;
            }
        }
        else if(this.precedente.noire==this.noire && this.noire==this.suivante.noire) {
            this.prochaintEtat = false;
        }
        else{
            this.prochaintEtat=true;
        }
        this.suivante.prochaineEtape();
    }

    public void miseAJour(){
        if(this.prochaintEtat==true){
            this.noire=true;
        }
        else{
            this.noire=false;
        }
        if(this.suivante==null){
            return;
        }
        this.suivante.miseAJour();
    }

    public void prochaineEtapeMajorite(){
        int compt=0;
        if(this.suivante==null && this.precedente==null){
            this.noire=false;
            return;
        }
        if(this.precedente==null){
            if(this.noire==false || this.suivante.noire==false){
                this.prochaintEtat=false;
            }
            else {
                this.prochaintEtat=true;
            }
        }
        else if(this.suivante==null){
            if (this.noire==false || this.precedente.noire==false){
                this.prochaintEtat=false;
                return;
            }
            else{
                this.prochaintEtat=true;
                return;
            }
        }
        else if(this.suivante!=null && this.precedente!=null){
            if(this.precedente.noire) compt++;
            else compt--;
            if(this.noire) compt++;
            else compt--;
            if(this.suivante.noire) compt++;
            else compt--;
            if(compt>0) this.prochaintEtat=true;
            else this.prochaintEtat=false;
        }
        this.suivante.prochaineEtapeMajorite();
    }
}
