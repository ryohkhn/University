import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ImageEditView extends JFrame{
    private JButton cutButton;
    private JButton undoButton;
    private JButton redoButton;
    private ImagePane imagePane;
    private ImageEditModel model;

    public ImageEditView(ImageEditModel model){
        this.model=model;
        setTitle("Mon editeur");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar bar=new JMenuBar();
        cutButton=new JButton("Cut");
        undoButton=new JButton("Undo");
        redoButton=new JButton("Redo");
        cutButton.setEnabled(false);
        undoButton.setEnabled(false);
        redoButton.setEnabled(false);
        bar.add(cutButton);
        bar.add(undoButton);
        bar.add(redoButton);
        setJMenuBar(bar);
        imagePane=new ImagePane();
        setContentPane(imagePane);
        // action listener de tous les boutons
        cutButton.addActionListener(
                (ActionEvent e)->{
                    model.saveCut(imagePane.selection.getRectangle());
                    imagePane.repaint();
                    cutButton.setEnabled(false);
                    undoButton.setEnabled(true);
                    redoButton.setEnabled(true);
                }
        );
        undoButton.addActionListener(
                (ActionEvent e)->{
                    if(model.undoManager.canUndo()){
                        model.undoManager.undo();
                        imagePane.repaint();
                    }
                }
        );
        redoButton.addActionListener(
                (ActionEvent e)->{
                    if(model.undoManager.canRedo()){
                        model.undoManager.redo();
                        imagePane.repaint();
                    }
                }
        );
    }

    public class ImagePane extends JPanel{
        private Selection selection=new Selection();

        public ImagePane(){
            setPreferredSize(new Dimension(model.getImage().getWidth(),model.getImage().getHeight()));
            addMouseListener(selection);
            addMouseMotionListener(selection);
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(model.getImage(),0,0,this);
            ((Graphics2D) g).draw(selection.getRectangle());
        }

        public class Selection extends MouseAdapter implements MouseMotionListener{
            private int x1,y1,x2,y2;

            public Rectangle getRectangle(){
                return new Rectangle(x1,y1,x2-x1,y2-y1);
            }

            public void mousePressed(MouseEvent event){
                x1=event.getX();
                y1=event.getY();
                cutButton.setEnabled(false);
                imagePane.repaint();
            }

            public void mouseDragged(MouseEvent event){
                x2=event.getX();
                y2=event.getY();
                if(x1!=x2 && y1!=y2){
                    cutButton.setEnabled(true);
                }
                imagePane.repaint();
            }

            public void mouseMoved(MouseEvent event){

            }
        }
    }
}
