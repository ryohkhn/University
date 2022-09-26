public class CommandeMkdir extends CommandShell{

    public CommandeMkdir(Dossier racine, Dossier courant, String[] param){
        super(racine, courant, param);
    }

    @Override
    public Dossier executer(){
        // mkdir a forcément un seul paramètre
        if(this.param.length!=1){
            erreurParam();
            aide();
            return null;
        }
        // on ne crée pas les dossier entrées spéciales
        if(this.param[0].equals(".") || this.param[0].equals("..")){
            System.out.println("Impossible de créer le répertoire, le fichier existe.");
            return null;
        }
        // si le dossier n'existe pas on le crée et on ajoute un élément dossier avec le bon parent
        if(this.acceder(this.param[0],false)==null){
            Entree tmp=this.acceder(this.param[0], true);
            tmp.remplacer(new Dossier(tmp.getParent()));
        }else{
            // erreur si le fichier existe
            System.out.println("Impossible de créer le répertoire, le fichier existe.");
        }
        return null;
    }

    public static void aide(){
        System.out.println("mkdir <foldername>");
    }
}
