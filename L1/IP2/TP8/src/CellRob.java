public class CellRob {
    private Robot robot;
    private CellRob suivant;
    private CellRob precedent;

    public CellRob(Robot robot,CellRob suivant,CellRob precedent){
        this.robot=robot;
        this.suivant=suivant;
        this.precedent=precedent;
    }

    public CellRob(Robot robot){
        this.robot=robot;
        this.suivant=this;
        this.precedent=this;
    }

    public CellRob getPrecedent() {
        return precedent;
    }

    public CellRob getSuivant() {
        return suivant;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setPrecedent(CellRob precedent) {
        this.precedent = precedent;
    }

    public void setSuivant(CellRob suivant) {
        this.suivant = suivant;
    }

    public void affiche(){
        this.robot.description();
        CellRob tmp=this.suivant;
        while(tmp!=this){
            tmp.robot.description();
            tmp=tmp.suivant;
        }
    }

    public void ajouteRob(Robot robot){
        CellRob res=new CellRob(robot,null,null);
        res.suivant=this;
        res.precedent=this.precedent;
        this.precedent.suivant=res;
        this.precedent=res;
    }

    public void supprimer(int id){
        CellRob tmp=this.suivant;
        while(tmp!=this){
            if(tmp.robot.getId()==id){
                tmp.suivant.precedent=tmp.precedent;
                tmp.precedent.suivant=tmp.suivant;
            }
            tmp=tmp.suivant;
        }
    }

    public void supprimer(String nom){
        CellRob tmp=this.suivant;
        while(tmp!=this){
            if(tmp.robot.getNom().equals(nom)){
                tmp.suivant.precedent=tmp.precedent;
                tmp.precedent.suivant=tmp.suivant;
            }
            tmp=tmp.suivant;
        }
    }
}
