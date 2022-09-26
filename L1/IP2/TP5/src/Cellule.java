public class Cellule {
    private Employe emp;
    private Cellule suivant;

    public Cellule(Employe emp,Cellule suivant){
        this.emp=emp;
        this.suivant=suivant;
    }

    public Cellule(Employe emp){
        this(emp,null);
    }

    public Employe getEmp() {
        return emp;
    }

    public Cellule getSuivant() {
        return suivant;
    }

    public void afficher(){
        this.emp.afficher();
        if(this.suivant==null){
            return;
        }
        this.suivant.afficher();
    }

    public boolean appartient(String n){
        if(this.emp.getNom().equals(n)){
            return true;
        }
        if(this.suivant==null){
            return false;
        }
        return this.suivant.appartient(n);
    }

    public void demission(String n) {
        if(this.suivant==null){
            return;
        }
        if(this.suivant.emp.getNom().equals(n)){
            this.suivant=this.suivant.suivant;
            return;
        }
        this.suivant.demission(n);
    }

    public boolean augmente(String nom,int montant){
        if(!this.appartient(nom)){
            return false;
        }
        if(this.emp.getNom().equals(nom)){
            return this.emp.augmente(nom,montant);
        }
        return this.suivant.augmente(nom,montant);
    }

    public Entreprise choixSalaire(int min,int max,Entreprise res){
        if(this.emp.getSalaire()>=min && this.emp.getSalaire()<=max){
            if(res.getPremier()==null){
                res.ajout(this.emp);
            }
            else{
                res.ajout(this.emp);
            }
        }
        if(this.suivant==null){
            return res;
        }
        return this.suivant.choixSalaire(min,max,res);
    }


    public boolean croissante(){
        if(this.suivant==null){
            return true;
        }
        if(this.emp.getSalaire()<this.suivant.emp.getSalaire()){
            return this.suivant.croissante();
        }
        return false;
    }

    public void ajout(Employe emp){
        if(this.suivant==null){
            this.suivant=new Cellule(emp);
            return;
        }
        if(this.suivant.emp.getSalaire()<=emp.getSalaire()){
            this.suivant.ajout(emp);
        }
        else{
            this.suivant=new Cellule(emp,this.suivant);
            return;
        }
    }

    public void acquisition_Version_1(Entreprise ent){
        Entreprise tmp=new Entreprise("tmp",ent.getPremier().getSuivant());
        this.ajout(tmp.getPremier().getEmp());
        if(tmp.getPremier().suivant==null){
            return;
        }
        this.acquisition_Version_1(tmp);
    }

    public Employe augmente_Version_1(String nom, int montant){
        if(this.emp.getNom().equals(nom)){
            return this.emp;
        }
        if(this.suivant==null){
            return null;
        }
        return this.suivant.augmente_Version_1(nom,montant);
    }

    public void augmente_Version_2(String nom,int montant){
        if(this.emp.getNom().equals(nom)){
            this.emp.setSalaire(this.emp.getSalaire()+montant);
            
            this.pushIt();
            return;
        }
        this.suivant.augmente_Version_2(nom,montant);
    }

    public void pushIt(){
        if(this.suivant==null){
            return;
        }
        if(this.suivant.emp.getSalaire()<=this.emp.getSalaire()){
            Employe tmp=this.emp;
            this.emp=this.suivant.emp;
            this.suivant.emp=tmp;
            this.suivant.pushIt();
        }
        return;
    }

    public Cellule returnFin(){
        if(this.suivant==null){
            return this;
        }
        return this.suivant.returnFin();
    }

    /* Cette méthode ne fonctionne pas

    public void acquisition_Version_2(Entreprise ent){
        if(this.emp.getSalaire()<=ent.getPremier().emp.getSalaire()){
            this.suivant.acquisition_Version_2(ent);
        }
        this.suivant=ent.getPremier();
        this.suivant.returnFin().suivant=this.suivant.suivant;
        this.suivant.pushIt();
        if(this.suivant!=null){
            this.suivant.pushIt();
        }
        return;
        //Entreprise tmp=new Entreprise("tmp",ent.getPremier().getSuivant());
        //this.acquisition_Version_1(tmp);
    }*/
}
