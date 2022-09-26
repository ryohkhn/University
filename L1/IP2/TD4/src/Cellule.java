public class Cellule {
    private Animal animal;
    private Cellule suivant;

    public Cellule(String s) {
        this.animal = new Animal(s);
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public Cellule getSuivant() {
        return this.suivant;
    }

    public void setSuivant(Cellule suivant) {
        this.suivant = suivant;
    }

    public int compt() {
        int res = 0;
        Cellule tmp = this;
        while (tmp != null) {
            tmp = tmp.suivant;
            res++;
        }
        return res;
    }

    public void transform() {
        Cellule tmp = this;
        while (tmp != null) {
            tmp.animal.transform();
            tmp = tmp.suivant;
        }
    }

    public void afficher(){
        Cellule tmp=this;
        while (tmp!=null){
            tmp.animal.afficher();
            tmp=tmp.suivant;
        }
    }

    public void etapeDeux(){
        Cellule tmp=this;
        Cellule res=new Cellule(this.animal.getRegime());
        Cellule fin=res;
        while(tmp.suivant!=null){
            if(tmp.animal.isHerb() && tmp.suivant.animal.isHerb()){
                fin.suivant=new Cellule("herbivore");
                fin=fin.suivant;
            }
            fin.suivant=new Cellule(tmp.suivant.animal.getRegime());
            fin=fin.suivant;
            tmp=tmp.suivant;
        }
        this.animal=res.animal;
        this.suivant=res.suivant;
    }
}

