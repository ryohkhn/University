import java.util.HashMap;
import java.util.Random;

public class Personnage{
    private final String prenom;
    private final String nom;
    public static HashMap<Personnage,Integer> scores;

    public Personnage(String prenom,String nom){
        this.prenom=prenom;
        this.nom=nom;
        Random random=new Random();
        scores=new HashMap<>();
        boolean present=false;
        // si le personnage est présent dans la liste on passe le attribue le booléen à true
        for(Personnage personnage : scores.keySet()){
            if(personnage.equals(this)){
                present=true;
            }
        }
        if(!present){
            scores.put(this, random.nextInt(10)+1);
        }
    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Personnage){
            if(((Personnage) o).getPrenom().equals(prenom) && ((Personnage) o).getNom().equals(nom)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        return 109 * prenom.hashCode() + nom.hashCode();
    }
}
