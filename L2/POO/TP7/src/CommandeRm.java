public class CommandeRm extends CommandShell{
    public CommandeRm(Dossier racine, Dossier courant, String[] param){
        super(racine, courant, param);
    }

    @Override
    public Dossier executer(){
        // rm ne prend q'un paramètre
        if(this.param.length!=1){
            erreurParam();
            return null;
        }
        Entree tmp=this.acceder(this.param[0],false);
        // on récupère l'entrée et on vérifie qu'elle existe
        if(tmp!=null){
            // s'il s'agit d'un dossier ou d'un texte on utilise la méthode supprimer
            if(tmp.getElement() instanceof Dossier || tmp.getElement() instanceof FichierTexte){
                tmp.supprimer();
            }
            else{
                // si ce n'est ni un dossier ni un fichier texte
                System.out.println("Impossible de supprimer cette entrée.");
            }
        }
        else{
            // si l'entrée que l'on souhaite supprimer est inexisstante
            System.out.println("Entrée non existante.");
        }
        return null;
    }

    public static void aide(){
        System.out.println("rm <name>");
    }
}
