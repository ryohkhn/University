import java.util.Scanner;

public abstract class CommandShell{
    protected Dossier racine;
    protected Dossier courant;
    protected String[] param;

    public CommandShell(Dossier racine,Dossier courant,String[] param){
        this.racine=racine;
        this.courant=courant;
        this.param=param;
    }

    public abstract Dossier executer();

    // l'affichage de l'aide de toutes les options
    public static void aide(){
        CommandeCat.aide();
        CommandeCd.aide();
        CommandeEd.aide();
        CommandeLs.aide();
        CommandeMkdir.aide();
        CommandeMv.aide();
        CommandeRm.aide();
        System.out.println("help");
        System.out.println("quit");
    }


    public static void erreurParam(){
        System.out.println("Pas un bon nombre de paramètres.");
        //aide(); // je n'ai pas compris comment implémenter aide dans cette class pour qu'elle appelle la fonction aide de la class concernée
        // si j'override aide() dans CommandeMkdir par exemple, elle ne sera jamais appellée
    }
    
    public static void erreurAffichable(){
        System.out.println("Votre fichier n'est pas affichable.");
    }

    protected Entree acceder(String chemin,boolean creer){
        Dossier res=this.courant;
        Dossier absolutetmp=this.racine;
        // entrée que l'on récupère à chaque avancement dans le dossier
        Entree entreeBoucle;
        Scanner sc=new Scanner(chemin);
        // string pour le chemin que l'on modifie à chaque fois, permet de savoir si on est au dernier mot du chemin
        String cheminmodif=chemin;
        String tmp="";
        boolean changed;
        sc.useDelimiter("/");
        while(sc.hasNext()){
            // boolean qui indique si un changement dans le dossier de mouvement a été fait
            changed=false;
            tmp=sc.next();
            // chemin absolu
            if(chemin.charAt(0)=='/'){
                // on regarde si l'entrée correspondante au nom du chemin existe
                if(absolutetmp.getEntree(tmp,false)!=null){
                    // on stocke cette entrée
                    entreeBoucle=absolutetmp.getEntree(tmp,false);
                    // on regarde si c'est le dernier mot du chemin
                    if(cheminmodif.length()-tmp.length()==0){
                        return entreeBoucle;
                    }
                    // on modifie le chemin (on pense à enlever le slash en plus)
                    cheminmodif=cheminmodif.substring(tmp.length()+1);
                    // on revérifie si c'est le dernier mot
                    if(cheminmodif.length()==0){
                        return entreeBoucle;
                    }
                    // si l'élément n'est pas un dossier on peut pas avancer dans le chemin avec une fichier texte, il faut un dossier
                    if(entreeBoucle.getElement() instanceof FichierTexte){
                        System.out.println("Erreur, le fichier n'est pas un dossier.");
                        return null;
                    }
                    // on avance dans les dossier en réattribuant le dossier courant
                    absolutetmp=(Dossier) entreeBoucle.getElement();
                    // boolean qui indique que le chemin a été changé
                    changed=true;
                }
            }else{
                // on regarde si l'entrée correspondante au nom du chemin existe
                if(res.getEntree(tmp,false)!=null){
                    // on stocke cette entrée
                    entreeBoucle=res.getEntree(tmp,false);
                    // on regarde si c'est le dernier mot du chemin
                    if(cheminmodif.length()-tmp.length()==0){
                        return entreeBoucle;
                    }
                    // on modifie le chemin (on pense à enlever le slash en plus)
                    cheminmodif=cheminmodif.substring(tmp.length()+1);
                    // on revérifie si c'est le dernier mot
                    if(cheminmodif.length()==0){
                        return entreeBoucle;
                    }
                    // si l'élément n'est pas un dossier on ne peut pas avancer dans le chemin avec une fichier texte, il faut un dossier
                    if(entreeBoucle.getElement() instanceof FichierTexte){
                        System.out.println("Erreur, le fichier n'est pas un dossier.");
                        return null;
                    }
                    // on avance dans les dossier en réattribuant le dossier courant
                    res=(Dossier) entreeBoucle.getElement();
                    // boolean qui indique que le chemin a été changé
                    changed=true;
                }
            }
            // si après avoir vérifie dans le dossier courant le fichier n'existe pas, s'il n'est pas à créer on return
            if(!changed && !creer){
                return null;
            }
        }
        // si on doit créer l'entrée
        if(creer){
            Entree cree;
            // si il s'agit d'une entrée via le chemin absolu on utilise absolutetpm
            if(chemin.charAt(0)=='/'){
                cree=new Entree(absolutetmp,tmp,null);
                absolutetmp.getList().add(cree);
            }
            // sinon on utilise res
            else{
                cree=new Entree(res,tmp,null);
                res.getList().add(cree);
            }
            return cree;
        }
        return null;
    }
}
