public class Triangle extends Figure implements Deformable{
    private final double hauteur;
    private final double base;

    public Triangle(int centreX, int centreY,double hauteur,double base){
        super(centreX, centreY);
        this.hauteur=hauteur;
        this.base=base;
    }

    @Override
    public void affiche(){
        System.out.println("Hauteur: "+this.hauteur+"\nBase: "+this.base+"\nCentre: ("+super.getPosX()+","+super.getPosY()+")");
    }

    @Override
    public double surface(){
        return (base*hauteur)/2;
    }

    // Un triangle est deformable, il a un coefficient vertical et horizontal
    @Override
    public Figure deformation(double coeffH, double coeffV){
        return new Triangle(super.getPosX(),super.getPosY(),this.hauteur*coeffV,this.base*coeffH);
    }
}
