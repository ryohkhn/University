import java.util.Scanner;

public class CommandeEd extends CommandShell{
    private Scanner sc;
    private boolean echo;

    public CommandeEd(Dossier racine, Dossier courant, String[] param,Scanner sc,boolean echo){
        super(racine, courant, param);
        this.sc=sc;
        this.echo=echo;
    }

    @Override
    public Dossier executer(){
        // ed a forcément un paramètre
        if(this.param.length!=1){
            erreurParam();
            return null;
        }
        // le scanner prend l'entrée du clavier
        this.sc=new Scanner(System.in);
        Entree tmp=acceder(this.param[0],true);
        // si on crée le fichier on vérifie que le fichier n'existait pas déjà
        if(tmp.getElement()==null){
            FichierTexte texte=new FichierTexte("");
            tmp.remplacer(texte);
        }
        // si un fichier on édite, sinon on print une erreur
        if(tmp.getElement() instanceof FichierTexte){
            ((FichierTexte)tmp.getElement()).editer(this.sc,echo);
        }
        else{
            System.out.println("Votre fichier n'est pas un fichier texte.");
        }
        return null;
    }

    public static void aide(){
        System.out.println("ed <filename>");
    }
}
