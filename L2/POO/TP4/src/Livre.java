public class Livre extends Media{
    private final String auteur;
    private final int nbDePages;

    public Livre(String titre,String auteur,int nbDePages){
        super(titre);
        this.auteur=auteur;
        this.nbDePages=nbDePages;
    }

    @Override
    public String toString(){
        return "Livre{" + "auteur='" + auteur + '\'' + ", nbDePages=" + nbDePages + "} " + super.toString();
    }

    /*public boolean plusPetit(Media doc){
        if(doc instanceof Livre){
            return super.plusPetit(doc);
        }
        return false;
    }*/

    @Override
    public int ordreMedia(){
        return 1;
    }
}
