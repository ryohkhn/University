public class Ellipse extends Figure implements Deformable{
    private final double grand_rayon;
    private final double petit_rayon;

    public Ellipse(int centreX, int centreY,double grand_rayon,double petit_rayon){
        super(centreX, centreY);
        this.grand_rayon=grand_rayon;
        this.petit_rayon=petit_rayon;
    }

    @Override
    public void affiche(){
        System.out.println("Grand rayon: "+this.grand_rayon+"\nPetit rayon: "+this.petit_rayon+"\nCentre: ("+super.getPosX()+","+super.getPosY()+")");
    }

    @Override
    public double surface(){
        return 3.141592653589793238462643*grand_rayon*petit_rayon;
    }

    // Une ellipse est deformable, elle a un coefficient vertical et horizontal
    @Override
    public Figure deformation(double coeffH, double coeffV){
        return new Ellipse(super.getPosX(),super.getPosY(),this.grand_rayon*coeffH,this.petit_rayon*coeffV);
    }
}
