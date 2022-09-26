import java.util.ArrayList;

public class Noeud {
    private char c;
    private ArrayList<Noeud> fils;

    public Noeud(){
        this.c='*';
        this.fils=new ArrayList<Noeud>();
    }

    public Noeud(char c){
        this.c=c;
        this.fils=new ArrayList<Noeud>();
    }

    public Noeud aPourEnfant(char a){
        for(Noeud n : fils){
            if(n.c==a){
                return n;
            }
        }
        return null;
    }

    public boolean appartient(String w){
        return this.appartientAux(w.concat("*"));
    }

    public boolean appartientAux(String w){
        if(this.c!=w.charAt(0)){
            return false;
        }
        if(w.equals("*")){
            return true;
        }
        for(Noeud n:fils){
            if(n.c==w.charAt(1)){
                return n.appartientAux(w.substring(1));
            }
        }
        return false;
    }

    public void ajouter(String s){
        if(this.c!=s.charAt(0)){
            return;
        }
        if(s.length()>1){
            for(Noeud n:fils){
                if(n.c==s.charAt(1)){
                    n.ajouter(s.substring(1));
                    return;
                }
            }
            Noeud it=this;
            for (int i = 1; i < s.length(); i++) {
                Noeud nouveau = new Noeud(s.charAt(i));
                it.fils.add(nouveau);
                it=nouveau;
            }
            Noeud n=new Noeud('*');
            it.fils.add(n);
        }
    }
}
