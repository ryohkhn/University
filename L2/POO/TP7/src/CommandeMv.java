public class CommandeMv extends CommandShell{
    public CommandeMv(Dossier racine, Dossier courant, String[] param){
        super(racine, courant, param);
    }

    @Override
    public Dossier executer(){
        // mv prend 2 paramètres obligatoirement
        if(this.param.length!=2){
            erreurParam();
            return null;
        }
        // on récupère les entrées source et destination
        Entree dest=this.acceder(this.param[1],false);
        Entree src=this.acceder(this.param[0],false);
        Entree res;
        // si l'entrée n'existe source n'existe pas
        if(src ==null){
            System.out.println("Dossier source inexistant.");
            return null;
        }
        // on ne déplace pas les entrées spéciales
        if(src instanceof EntreeSpeciale){
            System.out.println("Impossible de déplacer ce type de fichier.");
            return null;
        }
        // si l'entrée destination existe
        if(dest!=null){
            // on vérifie que le dossier n'est pas l'enfant de l'autre
            if(dest.getElement() instanceof Dossier){
                if(src.getElement() instanceof Dossier){
                    if(((Dossier) dest.getElement()).estEnfantDe((Dossier) src.getElement())){
                        System.out.println("Pas possible de déplacer un dossier dans lui même");
                        return null;
                    }
                }
                // on crée l'entrée avec le nom précédent
                res=((Dossier) dest.getElement()).getEntree(src.getNom(),true);
                res.remplacer(src.getElement());
                // si la source est un dossier on réattribue le parent de l'élément au nouvel élément
                if(src.getElement() instanceof Dossier){
                    if(((Dossier) src.getElement()).getParent()!=null){
                        ((Dossier)res.getElement()).setParent(((Dossier) src.getElement()).getParent());
                    }
                }
                // on supprime à la fin du déplacement
                src.supprimer();
            }
            else{
                // si l'entrée destination existe mais que ce n'est pas un dossier
                System.out.println("Votre fichier ne peut se déplacer que dans un dossier.");
            }
        }else{
            // sinon on crée le fichier que l'on déplace et on réattribue le parent s'il s'agit d'un dossier à l'origine
            res=this.acceder(this.param[1],true);
            res.remplacer(src.getElement());
            if(src.getElement() instanceof Dossier){
                if(((Dossier) src.getElement()).getParent()!=null){
                    ((Dossier)res.getElement()).setParent(((Dossier) src.getElement()).getParent());
                }
            }
            // on supprime l'entrée originelle
            src.supprimer();
        }
        return null;
    }

    public static void aide(){
        System.out.println("mv <src> <dst>");
    }
}
