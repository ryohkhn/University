import java.util.LinkedList;

public class Arbre{
    private Noeud sommet;

    public Arbre(Noeud sommet){
        this.sommet=sommet;
    }

    public Arbre(Arbre a){
        if(a.sommet==null){
            this.sommet=null;
        }
        else{
            this.sommet=a.sommet.copieProfonde();
        }
    }

    public static boolean estSymbole(String s){
        if(s.charAt(0)=='+' || s.charAt(0)=='-' || s.charAt(0)=='/' || s.charAt(0)=='*'){
            return true;
        }
        else{
            return false;
        }
    }

    public void afficheInfixe(){
        if(this.sommet==null){
            return;
        }
        this.sommet.afficheInfixe();
    }

    public void afficheExpression(){
        if(this.sommet==null){
            return;
        }
        this.sommet.afficheExpression();
    }

    public static boolean estNombre(String s){
        if (s.charAt(0)!='0' && s.charAt(0)!='1' && s.charAt(0)!='2' && s.charAt(0)!='3' && s.charAt(0)!='4' && s.charAt(0)!='5' && s.charAt(0)!='6' && s.charAt(0)!='7'
                && s.charAt(0)!='8' && s.charAt(0)!='9' && s.charAt(0)!='+' && s.charAt(0)!='-' && s.charAt(0)!='/' && s.charAt(0)!='*' && s.charAt(0)!='x') {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)=='.' && s.charAt(i+1)=='.'){
                return false;
            }
            if((Character.getNumericValue(s.charAt(i))<0 || Character.getNumericValue(s.charAt(i))>9) && s.charAt(i)!='.'){
                return false;
            }
        }
        return true;
    }

    public double eval(){
        if(this.sommet==null){
            return 0;
        }
        return this.sommet.eval();
    }

    public double evaluer(double z){
        if(this.sommet==null){
            return 0;
        }
        return this.sommet.evaluer(z);
    }

    public boolean verif(){
        if(this.sommet==null){
            return false;
        }
        return this.sommet.verif();
    }

    // incomplète
    public Arbre simplifier(){
        if(this.sommet==null){
            return null;
        }
        Arbre res=new Arbre(this);
        return res.sommet.simplifier();
    }
}
