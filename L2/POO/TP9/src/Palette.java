public class Palette{
    private Vue view;
    private Modele modele;
    private Controleur controleur;

    public Palette(){
        modele=new Modele(0,0,0);
        controleur=new Controleur(modele,null);
        view = new Vue(modele,controleur);
        view.setVisible(true);
        controleur.setVue(view);
    }

    public static void main(String[] args){
        Palette palette=new Palette();
    }
}
