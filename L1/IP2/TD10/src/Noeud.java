public class Noeud {
    private Noeud gauche;
    private Noeud droit;
    private int value;

    public Noeud(Noeud gauche, Noeud droit,int value) {
        this.droit = droit;
        this.gauche = gauche;
        this.value=value;
    }

    public Noeud() {
        this(null, null,0);
    }

    public boolean estFeuille() {
        return (this.gauche == null && this.droit == null);
    }

    public void bourgeons() {
        if (this.estFeuille()) {
            this.gauche = new Noeud();
            this.droit = new Noeud();
        } else {
            if (this.gauche != null) {
                this.gauche.bourgeons();
            }
            if (this.droit != null) {
                this.droit.bourgeons();
            }
        }
    }

    public int bourgeonsBis() {
        if (this.estFeuille()) {
            this.gauche = new Noeud();
            this.droit = new Noeud();
        } else {
            if (this.gauche != null) {
                this.gauche.bourgeons();
            }
            if (this.droit != null) {
                this.droit.bourgeons();
            }
        }
        return 0;
    }

    public void elagage() {
        if (this.gauche != null) {
            if (this.gauche.estFeuille()) {
                this.gauche = null;
            } else {
                this.gauche.elagage();
            }
        }
        if (this.droit != null) {
            if (this.droit.estFeuille()) {
                this.droit = null;
            } else {
                this.droit.elagage();
            }
        }
    }
    public void afficher() {
        System.out.print("n ");
        if (this.gauche != null) {
            this.gauche.afficher();
        }
        if (this.droit != null) {
            this.droit.afficher();
        }
    }

    public void croissance() {
        if(this.gauche!=null){
            Noeud g=this.gauche;
            this.gauche=new Noeud(g,null,0);
            g.croissance();
        }
        if(this.droit!=null){
            Noeud d=this.droit;
            this.droit=new Noeud(null,d,0);
            d.croissance();
        }
    }

    public void decroissance(){
        if(this.gauche!=null){
            if(this.gauche.gauche!=null){
                this.gauche=this.gauche.gauche;
            }else{
                this.gauche=null;
            }
        }
        if(this.droit!=null){
            this.droit=this.droit.droit;
            if(this.droit!=null){
                this.droit.decroissance();
            }
        }
    }

    public int valueCalcul(){
        if(this.gauche==null && this.droit==null){
            return this.value;
        }
        int vg=0;
        int vd=0;
        if(this.gauche!=null){
            vg=this.gauche.valueCalcul();
        }
        if(this.droit!=null) {
            vd = this.droit.valueCalcul();
        }
        return vg+vd;
    }
}