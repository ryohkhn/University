import java.util.ArrayList;
import java.util.LinkedList;

public class Mediatheque {
    LinkedList<Media> baseDeDonnees;

    public Mediatheque(){
        baseDeDonnees=new LinkedList<>();
    }

    public void ajouter(Media doc){
        for(int i=0; i<baseDeDonnees.size(); i++){
            Media m=baseDeDonnees.get(i);
            if(doc.plusPetit(m)){
                baseDeDonnees.add(i,doc);
                return;
            }
        }
        baseDeDonnees.add(doc);
    }

    @Override
    public String toString(){
        String res="";
        for(Media media : baseDeDonnees){
            res += media.toString() + "\n";
        }
        return res;
    }

    public void tousLesDictionnaires(){
        for(Media media : baseDeDonnees){
            if(media instanceof Dictionnaire){
                System.out.println(media);
            }
        }
    }

    public ArrayList<Media> recherche(Predicat p){
        ArrayList<Media> res=new ArrayList<>();
        for(Media media:this.baseDeDonnees){
            if(p.estVrai(media)){
                res.add(media);
            }
        }
        return res;
    }

    public static void main(String[] args){
        Mediatheque gibert=new Mediatheque();
        Livre test=new Livre("1984","George Orwell",300);
        Dictionnaire test2=new Dictionnaire("Larousse","Français",4);
        Manga test3=new Manga("One Piece","Oda",200,"Shonen",1);
        DictionnaireBilingue test4=new DictionnaireBilingue("Larousse Français-Anglais","Français",2,"Anglais");
        BandeDessinee test5=new BandeDessinee("Tintin","Hergé",150,"Hergé");
        Livre test6=new Livre("Les fleurs du mal","Baudelaire",350);
        Livre test8=new Livre("Salut","f",300);
        Livre test9=new Livre("salutation","f",200);
        Manga test10=new Manga("Salutation","f",120,"f",1);
        gibert.ajouter(test8);
        gibert.ajouter(test5);
        gibert.ajouter(test2);
        gibert.ajouter(test4);
        gibert.ajouter(test6);
        gibert.ajouter(test3);
        gibert.ajouter(test);
        gibert.ajouter(test9);
        gibert.ajouter(test10);
        System.out.println(gibert);

        TitreCommencePar S=new TitreCommencePar('s');
        EstUnLivre livre=new EstUnLivre();
        Et et=new Et(S,livre);
        System.out.println(gibert.recherche(et));
    }

    /*
    Exercice 4:

    Q2. Oui les livres sont séparés mais les objets héritants de Livre sont aussi séparés.

    Q4. Cette version n'est pas satisfaisante car on la surcharge dans la class Media, donc la valeur courante est toujours un Media.

    Q5. La méthode peut être static ou non, mais il s'agirait de deux implémentations différentes.
    Une méthode non static est plus rapide à implémenter car on l'override dans chaque class.

    */
}
