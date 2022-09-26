public class Mot extends ChaineCar{
    private String chaine;

    public Mot(String chaine){
        this.chaine=chaine;
    }

    @Override
    public int len(){
        return this.chaine.length();
    }

    @Override
    public String toString(){
        return this.chaine;
    }
}
