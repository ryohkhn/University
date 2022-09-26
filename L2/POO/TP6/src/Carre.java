public class Carre extends Figure{
    private final double cote;

    public Carre(int centreX, int centreY,double cote){
        super(centreX, centreY);
        this.cote=cote;
    }

    @Override
    public void affiche(){
        System.out.println("Côté: "+this.cote+"\nCentre: ("+super.getPosX()+","+super.getPosY()+")");
    }

    @Override
    public double surface(){
        return cote*cote;
    }
}
