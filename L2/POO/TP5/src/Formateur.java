import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Formateur{
    protected Scanner sc;
    protected LinkedList<Paragraphe> texte;

    public Formateur(String filename){
        sc=null;
        try{
            sc=new Scanner(new File(filename));
        }
        catch(Exception e){
            System.out.println("Erreur de l'ouverture d'un fichier");
            e.printStackTrace();
            System.exit(1);
        }
        texte=new LinkedList<Paragraphe>();
    }

    // fonction de traitement de chaque paragraphe de la suite
    private Paragraphe readParagraphe(){
        Paragraphe paragraphe=new Paragraphe();
        String para=this.sc.next();
        Scanner s=new Scanner(para);

        // on scanne le paragraphe entier
        while(s.hasNext()){
            String ligne=s.next();
            Scanner s2=new Scanner(ligne);
            // on récupère la ligne et on cherche les mots dans la ligne
            while(s2.hasNext()){
                // on les ajoute au paragraphe suivi d'un espace
                paragraphe.addChaine(new Mot(s2.next()));
                paragraphe.addChaine(new Espace());
            }
        }
        return paragraphe;
    }

    // fonction qui traite tous les paragraphes dans le scanner de l'objet et les ajoute au formateur
    public void read(){
        sc.useDelimiter("\n\\s*\n");
        while(sc.hasNext()){
            Paragraphe p=readParagraphe();
            this.texte.add(p);
        }
    }

    // on parcourt tout le texte en affichant chaque paragraphe
    public void print(){
        for(int i=0; i<this.texte.size(); i++){
            System.out.println(this.texte.get(i));
            // on ajoute une ligne vide en fin de paragraphe
            if(i!=this.texte.size()-1){
                Ligne ligne=new Ligne();
                System.out.println(ligne);
            }
        }
    }
}
