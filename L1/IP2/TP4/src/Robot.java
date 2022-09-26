public class Robot {
    private final char nom;
    private int energie;
    private final String texte;

    public Robot(char nom, String paroles){
        this.nom=nom;
        energie=10+(int)(Math.random()*11);
        texte=paroles;
    }

    public char getNom() {
        return nom;
    }

    public int getEnergie() {
        return energie;
    }

    public String getTexte() {
        return texte;
    }

    public void setEnergie(int energie) {
        this.energie = energie;
    }

    public String description(){
        return "Robot " + this.nom +" dit "+this.texte+" quand il parle et a "+this.energie+ " points d'énergie";
    }

    public boolean nomCorrect(){
        if(this.nom>='a' && this.nom<='z'){
            return true;
        }
        return false;
    }

    public void chante(){
        if(this.energie<=10){
            this.energie=0;
        }
        else {
            this.energie-=10;
        }
        int n=this.nom-'a'+1;
        while(n>0){
            System.out.print(this.texte);
            n--;
        }
    }
}
