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

    public void afficheInfixe(){
        if(this.sommet==null){
            return;
        }
        this.sommet.afficheInfixe();
    }

    public void affichePrefixe(){
        if(this.sommet==null){
            return;
        }
        this.sommet.affichePrefixe();
    }

    public void afficheSuffixe(){
        if(this.sommet==null){
            return;
        }
        this.sommet.afficheSuffixe();
    }

    public int nbNoeuds(){
        if(this.sommet==null){
            return -1;
        }
        return this.sommet.nbNoeuds();
    }

    public int somme(){
        if(this.sommet==null){
            return -1;
        }
        return this.sommet.somme();
    }

    public int profondeur(){
        if(this.sommet==null){
            return -1;
        }
        return this.sommet.profondeur()-1;
    }

    public boolean recherche(int e){
        if(this.sommet==null){
            return false;
        }
        return this.sommet.recherche(e);
    }
}
