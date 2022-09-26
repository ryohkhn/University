import java.awt.*;

public class Launcher{
    public Launcher(){
        ImageEditModel model=new ImageEditModel("/home/ryoh/Images/defaultanimal.png");
        ImageEditView view=new ImageEditView(model);
        view.pack();
        view.setVisible(true);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(
            new Runnable(){
                public void run(){
                    Launcher l=new Launcher();
                }
        }
        );
    }
}
