public class Groupe {
    private Cellule chefDeFile;

    public Groupe(){
        this.chefDeFile=null;
    }

    public void setChefDeFile(Cellule chefDeFile) {
        this.chefDeFile = chefDeFile;
    }

    public Cellule getChefDeFile() {
        return chefDeFile;
    }

    public Groupe(Cellule chefDeFile){
        this.chefDeFile=chefDeFile;
    }

    public void prendreTete(Robot r){
        if(r.nomCorrect()){
            chefDeFile= new Cellule(r,chefDeFile);
        }
    }

    public void ajouteNouveau(Robot r){
        if (r.nomCorrect()){
            this.chefDeFile.ajouteNouveau(r);
        }
    }

    public void affiche(){
        if(this.chefDeFile!=null){
            this.chefDeFile.affiche();
        }
    }

    public int numerologie(){
        if(this.chefDeFile==null) {
            return 0;
        }
        return this.chefDeFile.numerologie();
    }

    public String bandName(){
        if (this.chefDeFile == null){
            return null;
        }
        return this.chefDeFile.bandName();
    }

    public void chantez(){
        if(this.chefDeFile==null){
            return;
        }
        this.chefDeFile.chantez();
    }

    public Groupe couperAPartirDe(char nom){
        if(this.chefDeFile==null){
            return null;
        }
        return this.chefDeFile.couperAPartirDe(nom);
    }

    public Groupe prendrePause(){
        if(this.chefDeFile==null){
            return null;
        }
        return this.chefDeFile.prendePause();
    }

    public int effectifs(){
        if(this.chefDeFile==null){
            return -1;
        }
        return this.chefDeFile.effectifs();
    }
}
