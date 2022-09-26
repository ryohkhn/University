public abstract class Figure{
    private int posX;
    private int posY;

    public Figure(int x,int y){
        this.posX=x;
        this.posY=y;
    }

    public final int getPosX(){
        return posX;
    }

    public final int getPosY(){
        return posY;
    }

    public abstract void affiche();

    // On utilise pythagore pour calculer la distance entre deux points
    public double estDistanteDe(Figure fig){
        double x=Math.abs(this.posX-fig.posX);
        double y=Math.abs(this.posY-fig.posY);
        double res=Math.pow(x,2)+Math.pow(y,2);
        return Math.sqrt(res);
    }

    public abstract double surface();

    public void deplacement(int x,int y){
        this.posX=x;
        this.posY=y;
    }
}
