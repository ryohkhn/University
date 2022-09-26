public class CommandeCd extends CommandShell{
    public CommandeCd(Dossier racine, Dossier courant, String[] param){
        super(racine, courant, param);
    }

    @Override
    public Dossier executer(){
        // cd peut avoir 0 comme 1 argument
        if(param.length>1){
            erreurParam();
            return null;
        }
        Dossier res=racine;
        // on va à la racine si pas d'argument
        if(param.length==0){
            return res;
        }
        else{
            // on récupère l'entrée correspondante
            Entree tmp=acceder(this.param[0],false);
            if(tmp==null){
                System.out.println("Dossier inexistant.");
            }
            // on peut seulement cd dans un dossier
            else if(tmp.getElement() instanceof Dossier){
                return (Dossier) tmp.getElement();
            }
        }
        return null;
    }

    public static void aide(){
        System.out.println("cd [<foldername>]");
    }
}
