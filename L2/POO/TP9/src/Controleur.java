import java.awt.*;

public class Controleur{
    private Modele modele;
    private Vue vue;
    private Color memory;

    public Controleur(Modele modele,Vue vue){
        this.modele=modele;
        this.vue=vue;
    }

    // setter de vue pour le constructeur de palette
    public void setVue(Vue vue){
        this.vue=vue;
    }

    public void sliderMoved(){
        // on récupère les valeurs de tous les sliders et on change la couleur du modèle
        modele.color=new Color(vue.getSlider1().getValue(),vue.getSlider2().getValue(),vue.getSlider3().getValue());
        // on met à jour la vue pour changer le background et le code hexadécimale
        vue.miseAJour();
    }

    public void memorise(){
        // on stocke la couleur récuperée via les sliders dans un objet Color du controleur
        this.memory=new Color(vue.getSlider1().getValue(),vue.getSlider2().getValue(),vue.getSlider3().getValue());
    }

    public void replace(){
        // on remplace la couleur de l'objet par celle mémorisée
        modele.color=memory;
        // on adapte les valeurs des sliders en conséquence
        vue.getSlider1().setValue(memory.getRed());
        vue.getSlider2().setValue(memory.getGreen());
        vue.getSlider3().setValue(memory.getBlue());
        vue.miseAJour();
    }

    public void complementary(){
        // on crée une couleur temporaire et une couleur pour changer celle du modèle
        // sans créer ces couleurs, le fait de changer directement la couleur du modèle ne fonctionnait pas
        Color tmp=modele.color;
        // on crée la couleur complémentaire en récupérant la couleur actuelle
        Color res=new Color(255-tmp.getRed(),255-tmp.getGreen(),255-tmp.getBlue());
        modele.color=res;
        // on change les valeurs des sliders
        vue.getSlider1().setValue(res.getRed());
        vue.getSlider2().setValue(res.getGreen());
        vue.getSlider3().setValue(res.getBlue());
        vue.miseAJour();
    }
}
