public class TableRonde {
    private CellRob courant;

    public TableRonde(Robot robot){
        this.courant=new CellRob(robot);
    }

    public CellRob getCourant() {
        return courant;
    }

    public void affiche(){
        if(this.courant==null){
            return;
        }
        this.courant.affiche();
    }

    public void ajouteRob(Robot r){
        CellRob res=new CellRob(r,null,null);
        if(this.courant==null){
            this.courant = new CellRob(r);
        }else{
            this.courant.ajouteRob(r);
        }
    }

    public void supprimer(int id){
        if(this.courant==null){
            return;
        }
        if(this.courant.getRobot().getId()==id){
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
            this.courant.supprimer(id);
        }
    }

    public void supprimer(String nom){
        if(this.courant==null){
            return;
        }
        if(this.courant.getRobot().getNom().equals(nom)){
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

    public void parle(int n){
        if(this.courant==null){
            return;
        }
        if(n>=5) n=5;
        this.courant.getRobot().parle(n);
        this.courant=this.courant.getSuivant();
        if(this.courant.getPrecedent().getRobot().finiDeParler()){
            this.supprimer(this.courant.getPrecedent().getRobot().getId());
        }
    }
}
