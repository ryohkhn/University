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

    public void affichePenche(){
        if(this.sommet!=null){
            this.sommet.affiche(0);
        }
    }

    public static void afficher(LinkedList<Noeud> list,int hauteur){
        if(!list.isEmpty()) {
            Noeud.afficher(list,hauteur);
        }
    }

    /*public void nouveauLeader(){
        if(this.sommet!=null){
            return;
        }
        if(this.sommet.getDroite()!=null){
            if(this.gauche.gauche!=null){
                this.gauche=this.gauche.gauche;
            }else{
                this.gauche=null;
            }
        }
        if(this.droite!=null) {
            this.droite = this.droite.droite;
            if (this.droite != null) {
                this.droite.nouveauLeader();
            }
        }
    }*/
}
