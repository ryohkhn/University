import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Cadre extends JFrame implements MouseInputListener{
    public JPanel panel;
    public Random random=new Random();
    private Modele modele=new Modele();
    private JPanel etiquette=new JPanel();
    private boolean gameEnded=false;

    public Cadre(){
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel=new JPanel(null);
        setContentPane(panel);
        // on génère le nombre de carrés aléatoirement
        for(int i=0; i<random.nextInt(10)+1; i++){
            panel.add(new Carre());
        }
        panel.add(etiquette);
        addMouseListener(this);
    }

    // fonction faisant le déplacement de coordonnées du carré quand il est déplacé
    public void setCarreLocation(MouseEvent e,Carre carre){
        int x=e.getXOnScreen()-this.getInsets().left-this.getX()-carre.oldX;
        int y=e.getYOnScreen()-this.getInsets().top-this.getY()-carre.oldY;
        carre.setLocation(x,y);
    }

    // on gagne seulement si tous les carrés sont de même couleur
    public boolean gagne(){
        for(Color c:modele.list.values()){
            if(c.getRGB()!=modele.list.get(0).getRGB()){
                return false;
            }
        }
        return true;
    }

    // si tous les carrés sont de la même couleur on ajoute l'étiquette et on met le booléen à true
    public void finJeu(){
        if(gagne()){
            etiquette.add(new JLabel("Vous avez gagné!"),BorderLayout.CENTER);
            gameEnded=true;
        }
    }

    // Mouse Listener pour la fin de la partie, si on clique et que la partie est gagnée on ferme la fenêtre
    // si on exit le component et que la partie est gagnée on ferme la fenêtre aussi

    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println("clickOutside");
        if(gameEnded){
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){
        System.out.println("exited");
        if(gameEnded){
            System.exit(0);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e){

    }

    @Override
    public void mouseMoved(MouseEvent e){

    }

    public class Carre extends JPanel implements MouseInputListener{
        private boolean moving=false;
        public int oldX;
        public int oldY;
        private static int count;
        private final int id;

        // génération aléatoire des couleurs et de la position
        public Carre(){
            id=count++;
            modele.list.put(id,new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
            setBackground(modele.list.get(id));
            // position maximum en 550 car le carré fait 50 de largeur, il ne faut pas qu'il sorte de la fenêtre
            setBounds(random.nextInt(551),random.nextInt(551),50,50);
            addMouseListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e){
            System.out.println("click!");
            // on change la couleur dans le modele et la couleur de carré
            modele.list.replace(id,modele.list.get(id),Color.green);
            setBackground(Color.green);
            // on vérifie si la partie est gagnée, si c'est le cas on ferme la fenêtre
            finJeu();
            if(gameEnded){
                System.exit(0);
            }
        }

        // si on reste appuyé sur un carré on stocke les valeurs de départ pour les utiliser dans le calcul de déplacement
        @Override
        public void mousePressed(MouseEvent e){
            moving=true;
            oldX=e.getX();
            oldY=e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e){
            moving=false;
            setCarreLocation(e,this);
        }

        // on met le carré en vert si on passe par dessus
        @Override
        public void mouseEntered(MouseEvent e){
            System.out.println("Mouse hover!");
            modele.list.replace(id,modele.list.get(id),new Color(0x1A4B60));
            setBackground(new Color(0x1A4B60));
            finJeu();
        }

        @Override
        public void mouseExited(MouseEvent e){

        }

        @Override
        public void mouseDragged(MouseEvent e){

        }

        @Override
        public void mouseMoved(MouseEvent e){
        }
    }
}
