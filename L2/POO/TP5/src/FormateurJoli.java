import java.util.Scanner;

public class FormateurJoli extends Formateur{
    private final int len;

    public FormateurJoli(String filename, int len){
        super(filename);
        this.len=len;
    }

    // même fonction que dans formateur, la longueur est dépendante de l'attribut de l'objet courant, et les paragraphes sont des objets ParagrapheJoli
    private ParagrapheJoli readParagraphe(){
        ParagrapheJoli paragraphe=new ParagrapheJoli(this.len);
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

    // fonction qui traite tous les paragraphes jolis dans le scanner de l'objet et les ajoute au formateur
    public void read(){
        sc.useDelimiter("\n\\s*\n");
        while(sc.hasNext()){
            ParagrapheJoli p=readParagraphe();
            this.texte.add(p);
        }
    }
}
