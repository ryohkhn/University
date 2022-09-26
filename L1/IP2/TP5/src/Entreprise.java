public class Entreprise {
    private String nom;
    private Cellule premier;

    public Entreprise(String nom,Cellule premier){
        this.nom=nom;
        this.premier=premier;
    }

    public Entreprise(String nom){
        this(nom,null);
    }

    public Cellule getPremier() {
        return premier;
    }

    public void afficher(){
        if(this.premier==null){
            return;
        }
        this.premier.afficher();
    }

    public boolean appartient(String n){
        if(this.premier==null){
            return false;
        }
        return this.premier.appartient(n);
    }

    public void ajout(Employe emp){
        if(this.premier==null || this.premier.getEmp().getSalaire()>emp.getSalaire()){
            this.premier=new Cellule(emp,this.premier);
            return;
        }
        this.premier.ajout(emp);
    }

    public void demission(String n){
        if(this.premier==null){
            return;
        }
        if(this.premier.getEmp().getNom().equals(n)){
            this.premier=this.premier.getSuivant();
            return;
        }
        this.premier.demission(n);
    }

    public boolean augmente(String nom,int montant){
        if(this.premier==null){
            return false;
        }
        return this.premier.augmente(nom,montant);
    }

    public Entreprise choixSalaire(int min,int max){
        Entreprise res=new Entreprise("Sorted");
        if(this.premier==null){
            return res;
        }
        return this.premier.choixSalaire(min,max,res);
    }

    public boolean croissante(){
        if(this.premier==null){
            return false;
        }
        return this.premier.croissante();
    }

    public void acquisition_Version_1(Entreprise ent){
        if(this.premier==null || ent.premier==null){
            return;
        }
        this.ajout(ent.premier.getEmp());
        this.premier.acquisition_Version_1(ent);
    }

    public void augmente_Version_1(String nom,int montant){
        if(this.premier==null || !this.appartient(nom)){
            return;
        }
        Employe res=this.premier.augmente_Version_1(nom,montant);
        res.setSalaire(res.getSalaire()+montant);
        this.demission(nom);
        this.ajout(res);
    }

    public void augmente_Version_2(String nom,int montant){
        if(this.premier==null || !this.appartient(nom)){
            return;
        }
        this.premier.augmente_Version_2(nom,montant);
    }

    /* Cette méthode ne fonctionne pas

    public void acquisition_Version_2(Entreprise ent){
        if(this.premier==null || ent.premier==null){
            return;
        }
        this.premier.acquisition_Version_2(ent);
    }*/
}
