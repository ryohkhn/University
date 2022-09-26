public class CommandeCat extends CommandShell{
    public CommandeCat(Dossier racine, Dossier courant, String[] param){
        super(racine, courant, param);
    }

    @Override
    public Dossier executer(){
        // ici le nombre de paramètre est obligatoire, donc s'il y en a plus que 1 on affiche l'erreur
        if(this.param.length!=1){
            erreurParam();
            aide();
            return null;
        }
        // on récupère l'entrée via la fonction acceder
        Entree tmp=this.acceder(this.param[0],false);
        // si elle n'existe pas on return
        if(tmp==null){
            System.out.println("Aucun dossier ou fichier de ce type");
            return null;
        }
        // on n'affiche que des éléments affichables
        if(tmp.getElement() instanceof Affichable){
            ((Affichable)tmp.getElement()).afficher();
        }
        else{
            erreurAffichable();
        }
        return null;
    }

    public static void aide(){
        System.out.println("cat <name>");
    }
}