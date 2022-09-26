import java.io.*;
import java.util.ArrayList;

public class Arbre{
    private Noeud racine;

    public void afficher(){
        int profondeur=2;
        // on affiche le noeud racine
        System.out.println(racine.nom + " ["+racine.taille+"]");
        // on lance récursivement l'affichage sur tous les noeuds fils avec la profondeur de base
        for(Noeud n:racine.fils){
            n.afficher(profondeur);
        }
    }

    public Arbre(Noeud racine){
        this.racine=racine;
    }

    public void map(StringTransformation t){
        // on lance directement la map sur le noeud racine
        this.racine.map(t);
    }

    public void traverser(String extension){
        String[] tmp;
        // on split le nom de la racine par chaque point
        tmp=this.racine.nom.split("\\.");
        // on regarde si l'extension est bien corresondante
        if(tmp[tmp.length-1].equals(extension)){
            // on affiche si la racine contient bien l'extension
            System.out.println(this.racine.nom+" ["+this.racine.taille+"]");
        }
        // on lance récursivement traverser sur le reste de l'arbre
        this.racine.traverser(extension);
    }

    public void supprimer(String extension){
        String[] tmp;
        // on crée un arraylist avec les objets à retirer de la list des enfants de l'objet courant
        ArrayList<Noeud> toRemove=new ArrayList<>();
        // on split le nom pour vérifier l'extension
        tmp=this.racine.nom.split("\\.");
        if(tmp[tmp.length-1].equals(extension)){
            // si c'est le cas le noeud est null
            this.racine=null;
        }else{
            // on vérifie récursivement sur tous les enfants
            for(Noeud n:racine.fils){
                tmp=n.nom.split("\\.");
                // on ajoute à la liste temporaire si ils contiennent l'extension
                if(tmp[tmp.length-1].equals(extension)){
                    toRemove.add(n);
                }
                else{
                    // sinon on rappelle récursivement sur le noeud
                    n.supprimer(extension);
                }
            }
            // à la fin on retire les objets fils qui contiennent l'extension en fin de nom
            this.racine.fils.removeAll(toRemove);
        }
    }

    public static class Noeud{
        private String nom;
        private int taille;
        private boolean repertoire;
        private ArrayList<Noeud> fils;

        public Noeud(File file){
            try{
                // si le fichier n'existe pas on throw l'exception
                if(!file.exists()){
                    throw new FileNotFoundException();
                }
            } catch(FileNotFoundException e){
                e.printStackTrace();
            }
            this.nom=file.getName();
            this.taille=(int) file.length();
            this.repertoire=file.isDirectory();
            if(this.repertoire){
                this.fils=new ArrayList<>();
                if(file.listFiles()!=null){
                    for(File f : file.listFiles()){
                        // on lance ensuite le constructeur récursivement sur tous les fichiers enfants
                        this.fils.add(new Noeud(f));
                    }
                }
            }
        }

        public void afficher(int profondeur){
            // on affiche les espaces correspondant à la profondeur
            for(int i=0; i<profondeur; i++){
                System.out.print(" ");
            }
            // affiche de l'objet courant
            System.out.println(this.nom+" ["+this.taille+"]");
            if(this.fils!=null){
                for(Noeud n:this.fils){
                    // on affiche récursivement les enfants avec une profondeur en plus
                    n.afficher(profondeur+2);
                }
            }
        }

        public void map(StringTransformation t){
            // si ce n'est pas un répertoire on modifie son nom
            if(!this.repertoire){
                this.nom=t.transf(this.nom);
            }
            else{
                // sinon on appelle map sur tous les enfants de la list fils
                this.fils.forEach(m -> m.map(t));
            }
        }

        public void traverser(String extension){
            String[] tmp;
            tmp=this.nom.split("\\.");
            // on vérifie que le fichier courant contient l'extension en fin de nom
            if(tmp[tmp.length-1].equals(extension)){
                System.out.println(this.nom+" ["+this.taille+"]");
            }
            if(this.fils!=null){
                // on avance récursivement sur tous les enfants
                for(Noeud n:this.fils){
                    n.traverser(extension);
                }
            }
        }

        public void supprimer(String extension){
            String[] tmp;
            // list temporaire des objets à retirer
            ArrayList<Noeud> toRemove=new ArrayList<>();
            if(this.fils!=null){
                for(Noeud n:this.fils){
                    tmp=n.nom.split("\\.");
                    // on stocke dans la list les objets à retirer qui contiennent les enfants
                    if(tmp[tmp.length-1].equals(extension)){
                        toRemove.add(n);
                    }
                    else{
                        // on lance la fonction récursivement sur les enfants sinon
                        n.supprimer(extension);
                    }
                }
                // on supprime de la list courante les objets qui doivent l'être
                this.fils.removeAll(toRemove);
            }

        }
    }
}
