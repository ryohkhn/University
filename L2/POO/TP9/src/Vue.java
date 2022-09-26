import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class Vue extends JFrame{
    private JPanel panneauColor=new JPanel();
    private JPanel panneauChoix=new JPanel();
    private JLabel etiqCouleur=new JLabel();
    // les slider ont été mis en argument pour permettre de récupérer leur valeur dans le controleur sans avoir à passer pas les JPanel
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;
    private Container contentPane;
    private Modele modele;
    private Controleur controleur;

    public Vue(Modele modele,Controleur controleur){
        this.modele=modele;
        this.controleur=controleur;
        this.setTitle("Palette");
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane=getContentPane();

        // on met la couleur de attribuée au modèle lors de la construction en background
        panneauColor.setBackground(modele.color);
        // affichage de la couleur en hexadécimal
        String hex="#"+Integer.toHexString(modele.color.getRGB()).substring(2);
        etiqCouleur.setText(hex);
        etiqCouleur.setHorizontalAlignment(0);
        contentPane.setLayout(new GridLayout());
        // les deux panneaux sont en borderlayout, on insèrera ensuite d'autre panneaux à l'intérieur
        panneauColor.setLayout(new BorderLayout());
        panneauChoix.setLayout(new BorderLayout());

        // création de la label table permettant d'afficher les labels de 0 à 100, en faisant en sorte que le slider aille de 0 à 255
        Hashtable<Integer,JLabel> dictionnary=new Hashtable<>();
        dictionnary.put(0,new JLabel("0"));
        dictionnary.put(63,new JLabel("25"));
        dictionnary.put(127,new JLabel("50"));
        dictionnary.put(191,new JLabel("75"));
        dictionnary.put(255,new JLabel("100"));
        // slider allant de 0 à 255
        slider1=new JSlider(0,255,0);
        slider2=new JSlider(0,255,0);
        slider3=new JSlider(0,255,0);
        // on affiche le ticking et on attribue la label table aux sliders
        slider1.setMinorTickSpacing(10);
        slider2.setMinorTickSpacing(10);
        slider3.setMinorTickSpacing(10);
        slider1.setLabelTable(dictionnary);
        slider2.setLabelTable(dictionnary);
        slider3.setLabelTable(dictionnary);
        slider1.setPaintTicks(true);
        slider2.setPaintTicks(true);
        slider3.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider2.setPaintLabels(true);
        slider3.setPaintLabels(true);

        // création des trois boutons
        Button button1=new Button("Mémoriser");
        Button button2=new Button("S'en rappeler");
        Button button3=new Button("Complémentaire");

        // JPanel pour les boutons et pour les sliders
        JPanel topSliders=new JPanel();
        JPanel bottomButtons=new JPanel();

        // panel des sliders est un gridlayout pour permettre des les mettre les uns sur les autres
        topSliders.setLayout(new GridLayout(3,1));
        // panel des boutons en flow layout pour qu'ils soient en ligne
        bottomButtons.setLayout(new FlowLayout());

        topSliders.add(slider1);
        topSliders.add(slider2);
        topSliders.add(slider3);
        bottomButtons.add(button1);
        bottomButtons.add(button2);
        bottomButtons.add(button3);

        // on ajoute au contentPane les JPanel, et au panneauChoix les panneaux de sliders et de boutons
        contentPane.add(panneauChoix);
        contentPane.add(panneauColor);
        panneauColor.add(etiqCouleur,BorderLayout.CENTER);
        panneauChoix.add(topSliders);
        panneauChoix.add(bottomButtons,BorderLayout.PAGE_END);

        // les sliders lancent la fonction sliderMoved() à chaque changement
        slider1.addChangeListener((event)->controleur.sliderMoved());
        slider2.addChangeListener((event)->controleur.sliderMoved());
        slider3.addChangeListener((event)->controleur.sliderMoved());
        // chaque bouton lance sa fonction respective dans controleur à chaque fois qu'il est appuyé
        button1.addActionListener((event)->controleur.memorise());
        button2.addActionListener((event)->controleur.replace());
        button3.addActionListener((event)->controleur.complementary());
    }

    public void miseAJour(){
        // on change le background avec la couleur du modele, et le code hexadécimal
        panneauColor.setBackground(modele.color);
        String hex="#"+Integer.toHexString(modele.color.getRGB()).substring(2);
        etiqCouleur.setText(hex);
    }

    // Getter des sliders
    public JSlider getSlider1(){
        return slider1;
    }

    public JSlider getSlider2(){
        return slider2;
    }

    public JSlider getSlider3(){
        return slider3;
    }
}