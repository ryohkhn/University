import javax.imageio.ImageIO;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageEditModel{
    private BufferedImage image;
    public UndoManager undoManager=new UndoManager();

    public ImageEditModel(String chemin){
        try{
            image=ImageIO.read(new File(chemin));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public BufferedImage getImage(){
        return image;
    }

    public void fillZone(Rectangle z, int[][] pixels){
        // on remplace chaque pixel de l'image avec celle du tableau pixels
        for(int i=0; i<z.width; i++){
            for(int j=0; j<z.height; j++){
                image.setRGB(z.x+i,z.y+j,pixels[i][j]);
            }
        }
    }

    public void clearZone(Rectangle z){
        Color white=Color.white;
        int srgb=white.getRGB();
        int[][] pixels=new int[z.width][z.height];
        // on remplit le tableau de pixels de blanc, et on appelle fillzone sur le rectangle correspondant
        for(int i=0; i<z.width; i++){
            for(int j=0; j<z.height; j++){
                pixels[i][j]=srgb;
            }
        }
        fillZone(z,pixels);
    }

    public void saveCut(Rectangle z){
        // on stock l'image découpée et on crée le nouvel objet coupe
        BufferedImage tmpImage=image.getSubimage(z.x,z.y,z.width,z.height);
        Coupe c=new Coupe(z.x,z.y,z.width,z.height,tmpImage);
        // on applique la coupe
        c.doit();
        CutEdit cutEdit=new CutEdit(c);
        undoManager.addEdit(cutEdit);
    }

    public class Coupe{
        private Rectangle z;
        private int[][] pixels;

        public Coupe(int x,int y,int width,int height,BufferedImage image){
            pixels=new int[width][height];
            z=new Rectangle(x,y,width,height);
            // on remplit le tableau de pixels avec les la valeur de chaque pixel de l'image
            for(int i=0; i<width; i++){
                for(int j=0; j<height; j++){
                    pixels[i][j]=image.getRGB(i,j);
                }
            }
        }

        public void doit(){
            clearZone(z);
        }

        public void undo(){
            fillZone(z,pixels);
        }
    }

    public class CutEdit extends AbstractUndoableEdit{
        private Coupe c;

        public CutEdit(Coupe c){
            this.c=c;
        }

        public void undo(){
            c.undo();
        }

        public void redo(){
            c.doit();
        }
    }
}
