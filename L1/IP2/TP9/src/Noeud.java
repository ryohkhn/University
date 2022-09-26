public class Noeud {
    private int etiquette;
    private Noeud gauche;
    private Noeud droite;

    public Noeud(int etiquette,Noeud gauche,Noeud droite){
        this.etiquette=etiquette;
        this.droite=droite;
        this.gauche=gauche;
    }

    public Noeud(int etiquette){
        this(etiquette,null,null);
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


    public void affichePrefixe(){
        System.out.print(this.etiquette+" ");
        if(this.gauche!=null){
            this.gauche.affichePrefixe();
        }
        if(this.droite!=null){
            this.droite.affichePrefixe();
        }
    }

    public void afficheSuffixe(){
        if(this.gauche!=null){
            this.gauche.afficheSuffixe();
        }
        if(this.droite!=null){
            this.droite.afficheSuffixe();
        }
        System.out.print(this.etiquette+" ");
    }

    public int nbNoeuds(){
        int desDroite=0;
        int desGauche=0;
        if(this.gauche!=null){
            desGauche=this.gauche.nbNoeuds();
        }
        if(this.droite!=null){
            desDroite=this.droite.nbNoeuds();
        }
        return 1+desDroite+desGauche;
    }

    public int somme(){
        int desDroite=0;
        int desGauche=0;
        if(this.gauche!=null){
            desGauche=this.gauche.somme();
        }
        if(this.droite!=null){
            desDroite=this.droite.somme();
        }
        return this.etiquette+desDroite+desGauche;
    }

    public int profondeur(){
        int desDroite=0;
        int desGauche=0;
        if(this.gauche!=null){
            desGauche=this.gauche.profondeur();
        }
        if(this.droite!=null){
            desDroite=this.droite.profondeur();
        }
        return 1+Math.max(desDroite,desGauche);
    }

    public boolean recherche(int e){
        if(e==this.etiquette){
            return true;
        }
        boolean res=false;
        if(this.gauche!=null){
            res |= this.gauche.recherche(e);
        }
        if(this.droite!=null){
            res |= this.droite.recherche(e);
        }
        return res;
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
}
