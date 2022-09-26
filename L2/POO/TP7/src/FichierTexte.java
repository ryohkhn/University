import java.util.Scanner;
import java.util.regex.Pattern;

public class FichierTexte extends Element implements Affichable,Editable{
    private String texte;

    public FichierTexte(String texte){
        this.texte=texte;
    }

    @Override
    public String getType(){
        return "texte";
    }

    @Override
    public void afficher(){
        System.out.println(this.texte);
    }

    @Override
    public void editer(Scanner sc, boolean echo){
        // délimiteur pour les lignes
        sc.useDelimiter(Pattern.compile("(\n)|;"));
        String tmp="";
        this.texte="";
        while(sc.hasNext()){
            tmp=sc.next();
            // si c'est un point on arrête la prise en compte du texte
            if(tmp.equals(".")){
               return;
            }
            // on ajoute au texte à chaque ligne ce qui vient d'être entré
            this.texte+=tmp;
            if(echo){
                System.out.println(tmp);
            }
        }
    }
}
