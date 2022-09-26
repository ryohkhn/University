public class Dictionnaire extends Media{
    private final String langue;
    private final int nbDeTomes;

    public Dictionnaire(String titre,String langue,int nbDeTomes){
        super(titre);
        this.langue=langue;
        this.nbDeTomes=nbDeTomes;
    }

    @Override
    public String toString(){
        return "Dictionnaire{" + "langue='" + langue + '\'' + ", nbDeTomes=" + nbDeTomes + "} " + super.toString();
    }

    @Override
    public int ordreMedia(){
        return 4;
    }
}
