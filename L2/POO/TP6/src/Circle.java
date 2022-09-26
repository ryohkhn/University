public class Circle extends Figure{
    private final double rayon;

    public Circle(int centreX, int centreY,double rayon){
        super(centreX, centreY);
        this.rayon=rayon;
    }

    @Override
    public void affiche(){
        System.out.println("Rayon: "+this.rayon+"\nCentre: ("+super.getPosX()+","+super.getPosY()+")");
    }

    @Override
    public double surface(){
        return rayon*rayon*3.141592653589793238462643;
    }
}
