public class Robot {
    private static int nbRob;
    private String nom;
    private int id;
    private int np;

    public Robot(String nom,String texte){
        this.nom=nom;
        nbRob++;
        this.id=nbRob;
        this.np=texte.length();
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getNp() {
        return np;
    }

    public void setNp(int np) {
        this.np = np;
    }

    public boolean finiDeParler(){
        if(this.np<=0){
            return true;
        }
        return false;
    }

    public int parle(int n) {
        this.np-=n;
        return this.np;
    }

    public void description(){
        System.out.println("Robot: "+this.nom+",id: "+this.id+",paroles restantes: "+this.np);
    }
}
