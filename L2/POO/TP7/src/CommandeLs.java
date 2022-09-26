public class CommandeLs extends CommandShell{
    public CommandeLs(Dossier racine, Dossier courant, String[] param){
        super(racine, courant, param);
    }

    @Override
    public Dossier executer(){
        // ls a soit 0 soit 1 argument
        if(this.param.length>1){
            erreurParam();
            aide();
            return null;
        }
        // affichage du dossier courant si pas d'argument
        if(this.param.length==0){
            this.courant.afficher();
        }
        else{
            Entree tmp=acceder(param[0],false);
            // si l'entrée récuperée est affichable on l'affiche, sinon on affiche une erreur
            if(tmp!=null){
                if(tmp.getElement() instanceof Affichable){
                    ((Affichable)tmp.getElement()).afficher();
                }else{
                    erreurAffichable();
                }
            }else{
                // si l'entrée n'existe pas
                System.out.println("Aucun dossier ou fichier de ce type.");
            }
        }
        return null;
    }

    public static void aide(){
        System.out.println("ls [<name>]");
    }
}
