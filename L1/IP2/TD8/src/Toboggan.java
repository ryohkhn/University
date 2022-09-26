public class Toboggan{
    private FileToboggan file;

    public Toboggan(int n){
        this.file=new FileToboggan(n);
    }

    public int jouer(){
        int nbrTours=0;
        if(file==null){
            return nbrTours;
        }
        while(file.getCourant()!=null){
            file.unTour();
            nbrTours++;
        }
        return nbrTours;
    }
}
