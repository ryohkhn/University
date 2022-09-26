import java.util.LinkedList;

public class Noeud {
    private String etiquette;
    private Noeud gauche;
    private Noeud droite;

    public Noeud(String etiquette, Noeud gauche, Noeud droite){
        this.etiquette = etiquette;
        this.droite = droite;
        this.gauche = gauche;
    }

    public Noeud(String etiquette){
        this(etiquette, null, null);
    }

    public Noeud getDroite() {
        return droite;
    }

    public Noeud getGauche() {
        return gauche;
    }

    public String getEtiquette() {
        return etiquette;
    }

    public void afficheInfixe(){
        if(this.gauche!=null){
            this.gauche.afficheInfixe();
        }
        System.out.print(this.etiquette+ " ");
        if(this.droite!=null){
            this.droite.afficheInfixe();
        }
    }

    public Noeud copieProfonde() {
        Noeud g = null, d = null;
        if (this.droite != null) {
            d = this.droite.copieProfonde();
        }
        if (this.gauche != null) {
            g = this.gauche.copieProfonde();
        }
        return new Noeud(this.etiquette, g, d);
    }

    public boolean verif() {
        if(this.etiquette.equals("+") || this.etiquette.equals("*") || this.etiquette.equals("/")){
            if(this.droite==null || this.gauche==null){
                return false;
            }
        }
        if(this.etiquette.equals("-")){
            if(this.droite==null){
                return false;
            }
        }
        if(!Arbre.estNombre(this.etiquette)){
            return false;
        }
        boolean verifgauche=true;
        boolean verifdroite=true;
        if(this.gauche!=null){
            verifgauche=this.gauche.verif();
        }
        if(this.droite!=null){
            verifdroite=this.droite.verif();
        }
        return (verifgauche && verifdroite);
    }

    public void afficheExpression(){
        if(this.gauche!=null){
            System.out.print("(");
            this.gauche.afficheExpression();
        }
        if(this.etiquette.equals("-")){
            if(this.gauche==null || this.droite==null){
                System.out.print("("+this.etiquette);
            }
            else{
                System.out.print(this.etiquette);
            }
        }
        else{
            System.out.print(this.etiquette);
        }
        if(this.droite!=null){
            this.droite.afficheExpression();
            System.out.print(")");
        }
    }

    public double eval(){
        double res=0;
        if(Arbre.estSymbole(this.etiquette)){
            if(this.etiquette.equals("+")){
                res+=this.gauche.eval()+this.droite.eval();
            }
            if(this.etiquette.equals("/")){
                res+=(this.gauche.eval()/this.droite.eval());
            }
            if(this.etiquette.equals("*")){
                res+=this.gauche.eval()*this.droite.eval();
            }
        }
        if(this.droite==null && this.gauche==null){
            return Double.parseDouble(this.etiquette);
        }
        return res;
    }

    public double evaluer(double z){
        double res=0;
        if(this.etiquette.equals("x")){
            this.etiquette=Double.toString(z);
        }
        if(Arbre.estSymbole(this.etiquette)){
            if(this.etiquette.equals("-")){
                if(this.droite==null || this.gauche==null){
                    res+=-(this.droite.evaluer(z));
                }
                else{
                    res+=this.gauche.evaluer(z)-this.droite.evaluer(z);
                }
            }
            if(this.etiquette.equals("+")){
                res+=this.gauche.evaluer(z)+this.droite.evaluer(z);
            }
            if(this.etiquette.equals("/")){
                res+=(this.gauche.evaluer(z)/this.droite.evaluer(z));
            }
            if(this.etiquette.equals("*")){
                res+=this.gauche.evaluer(z)*this.droite.evaluer(z);
            }
        }
        if(this.droite==null && this.gauche==null){
            return Double.parseDouble(this.etiquette);
        }
        return res;
    }

    public Arbre simplifier(){
        return null;
    }
}