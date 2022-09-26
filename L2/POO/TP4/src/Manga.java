public class Manga extends Livre{
    private String genre;
    private int tome;

    public Manga(String titre, String auteur, int nbDePages,String genre,int tome){
        super(titre, auteur, nbDePages);
        this.genre=genre;
        this.tome=tome;
    }

    @Override
    public String toString(){
        return "Manga{" + "genre='" + genre + '\'' + ", tome=" + tome + "} " + super.toString();
    }

    @Override
    public int ordreMedia(){
        return 3;
    }
}
