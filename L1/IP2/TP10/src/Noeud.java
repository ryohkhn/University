import java.util.LinkedList;

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

    public Noeud getDroite() {
        return droite;
    }

    public Noeud getGauche() {
        return gauche;
    }

    public static void afficher(LinkedList<Noeud> list, int hauteur){
        while (!list.isEmpty()){
            System.out.print(list.poll().etiquette);
        }
    }

    public int getEtiquette() {
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

    public static Noeud test(){
        Noeud[] n=new Noeud[10];
        n[4]=new Noeud(4);
        n[1]=new Noeud(1,n[4],null);
        n[0]=new Noeud(0,null,null);
        n[7]=new Noeud(7,n[0],n[1]);
        n[8]=new Noeud(8,null,null);
        n[6]=new Noeud(6,null,n[8]);
        n[2]=new Noeud(2,null,null);
        n[9]=new Noeud(9,n[2],n[6]);
        n[5]=new Noeud(5,n[9],null);
        n[3]=new Noeud(3,n[5],n[7]);
        return n[3];
    }

    public void espace(int n){
        while(n>=0){
            System.out.print(" ");
            n--;
        }
    }

    public void affiche(int p){
        if(this.droite!=null){
            this.droite.affiche(p+1);
        }
        espace(p-1);
        System.out.println(this.etiquette);
        if(this.gauche!=null) {
            this.gauche.affiche(p+1);
        }
    }


}