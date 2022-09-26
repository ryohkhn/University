import java.io.InputStream;
import java.util.Scanner;

public class Shell{
    private final Dossier racine;
    private Dossier courant;

    public Shell(Dossier d){
        this.racine=d;
        this.courant=d;
    }

    public void interagir(InputStream in){
        Scanner sc=new Scanner(in);
        String tmp;
        String[] tmpSplit;
        String[] param;
        while(sc.hasNext()){
            // on récupère ligne par ligne les commandes
            tmp=sc.nextLine();
            // on utilise split pour séparer chaque mot contenant des espaces
            tmpSplit=tmp.split(" ");
            param=new String[tmpSplit.length-1];
            // ici on copie le tableau reçu dans celui des paramètres, mais sans la première commande. Pour les commandes vides le tableau sera vide
            if(tmpSplit.length>1){
                for(int i=1; i<tmpSplit.length; i++){
                    param[i-1]=tmpSplit[i];
                }
            }
            switch(tmpSplit[0]){
                case ("quit"):
                    return;
                case ("help"):
                    CommandShell.aide();
                    break;
                case ("cd"):
                    Dossier cdFolder;
                    CommandeCd cd=new CommandeCd(racine, courant, param);
                    cdFolder=cd.executer();
                    if(cdFolder!=null){
                        // on change de dossier courant
                        this.courant=cdFolder;
                    }
                    break;
                case ("ed"):
                    CommandeEd ed=new CommandeEd(racine, courant, param, sc, (in!=System.in));
                    ed.executer();
                    break;
                case ("cat"):
                    CommandeCat cat=new CommandeCat(racine, courant, param);
                    cat.executer();
                    break;
                case ("ls"):
                    CommandeLs ls=new CommandeLs(racine, courant, param);
                    ls.executer();
                    break;
                case ("mkdir"):
                    CommandeMkdir mkdir=new CommandeMkdir(racine, courant, param);
                    mkdir.executer();
                    break;
                case ("mv"):
                    CommandeMv mv=new CommandeMv(racine, courant, param);
                    mv.executer();
                    break;
                case ("rm"):
                    CommandeRm rm=new CommandeRm(racine, courant, param);
                    rm.executer();
                    break;
            }
        }
    }
}
