public class DictionnaireBilingue extends Dictionnaire{
    String langue2;

    public DictionnaireBilingue(String titre, String langue, int nbDeTomes,String langue2){
        super(titre, langue, nbDeTomes);
        this.langue2=langue2;
    }

    @Override
    public String toString(){
        return "DictionnaireBilingue{" + "langue2='" + langue2 + '\'' + "} " + super.toString();
    }

    @Override
    public int ordreMedia(){
        return 5;
    }
}
