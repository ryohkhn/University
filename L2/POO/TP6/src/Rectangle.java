public class Rectangle extends Figure implements Deformable{
    private final double largeur;
    private final double hauteur;


    public Rectangle(int centreX,int centreY,double largeur,double hauteur){
        super(centreX, centreY);
        this.largeur=largeur;
        this.hauteur=hauteur;
    }

    @Override
    public void affiche(){
        System.out.println("Hauteur: "+this.hauteur+"\nLargeur: "+this.largeur+"\nCentre: ("+super.getPosX()+","+super.getPosY()+")");
    }

    @Override
    public double surface(){
        return largeur*hauteur;
    }

    // Un rectangle est deformable, il a un coefficient vertical et horizontal
    @Override
    public Figure deformation(double coeffH, double coeffV){
        return new Rectangle(super.getPosX(),super.getPosY(),this.largeur*coeffH,this.hauteur*coeffV);
    }
}
