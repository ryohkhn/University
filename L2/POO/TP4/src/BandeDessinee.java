public class BandeDessinee extends Livre {
    private String dessinateur;

    public BandeDessinee(String titre, String auteur, int nbDePages,String dessinateur){
        super(titre, auteur, nbDePages);
        this.dessinateur=dessinateur;
    }

    @Override
    public String toString(){
        return "BandeDessinee{" + "dessinateur='" + dessinateur + '\'' + "} " + super.toString();
    }

    @Override
    public int ordreMedia(){
        return 2;
    }
}
