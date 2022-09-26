public class Liste{
    private Element premier;
    private Element dernier;

    public Liste(){
        this.premier=null;
        this.dernier=null;
    }

    public int longueur(){
        if(this.premier==null){
            return 0;
        }
        return this.premier.longueur();
    }

    public void afficher(){
        if(this.premier==null){
            System.out.println("()");
            return;
        }
        System.out.println("(" + this.premier.afficher() + ")");
    }

    public void afficherInverse(){
        if(this.premier==null){
            System.out.println("()");
            return;
        }
        System.out.println("(" + this.dernier.afficherInverse() + ")");
    }

    public void ajouterDebut(int valeur){
        if(this.premier!=null){
            Element tmp=this.premier;
            this.premier=new Element(valeur,this.premier,null);
            tmp.setPrecedent(this.premier);
            return;
        }
        this.premier=new Element(valeur,null,null);
        this.dernier=this.premier;
    }

    public void ajouterFin(int valeur){
        if(this.dernier!=null){
            Element tmp=this.dernier;
            this.dernier=new Element(valeur,null,this.dernier);
            tmp.setSuivant(this.dernier);
            return;
        }
        this.dernier=new Element(valeur,null,null);
        this.premier=this.dernier;
    }

    public void ajouterAvant(Element e,int valeur){
        if(this.premier==null){
            return;
        }
        if(this.premier.equals(e)){
            this.ajouterDebut(valeur);
            return;
        }
        this.premier.ajouterAvant(e,valeur);
    }

    public void supprimer(Element e) {
        if (this.premier == e && this.dernier == e) {
            premier = null;
            dernier = null;
        } else {
            if (this.dernier == e) {
                this.dernier = this.dernier.getPrecedent();
                this.dernier.setSuivant(null);
            } else {
                if (this.premier == e) {
                    this.premier = this.premier.getSuivant();
                    this.premier.setPrecedent(null);
                } else {
                    if (this.premier != null) {
                        this.premier.supprimer(e);
                    }
                }
            }
        }
    }

    public int somme(){
        if(this.premier==null && this.dernier==null){
            return -1;
        }
        return this.premier.somme();
    }

    public boolean estTriee(){
        if(this.premier==null && this.dernier==null){
            return false;
        }
        return this.premier.estTriee();
    }

    public void inverser(Element e){
        Element f=e.getSuivant();
        if(f==null){
            return;
        }
        if(this.premier==e){
            this.premier=f;
        }
        else{
            e.getPrecedent().setSuivant(f);
        }
        if(this.dernier==f){
            dernier=e;
        }
        else{
            f.getSuivant().setPrecedent(e);
        }
        e.setSuivant(f.getSuivant());
        f.setSuivant(e);
        f.setPrecedent(e.getPrecedent());
        e.setPrecedent(f);
    }

    public boolean passerEnOrdonnant(){
        if(this.premier==null){
            return false;
        }
        boolean res=false;
        Element tmp=this.premier;
        while(tmp.getSuivant()!=null){
            if(tmp.getValeur()>tmp.getSuivant().getValeur()){
                this.inverser(tmp);
                res=true;
            }
            tmp=tmp.getSuivant();
        }
        return res;
    }

    public void trier(){
        while(this.passerEnOrdonnant()){
        }
    }
}
