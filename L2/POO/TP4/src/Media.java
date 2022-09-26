public class Media {
    private String titre;
    private final int numeroMedia;
    private static int numero=0;

    public Media(String titre){
        this.titre=titre;
        numeroMedia=numero;
        numero++;
    }

    public String getTitre(){
        return titre;
    }

    public int getNumero(){
        return numeroMedia;
    }

    @Override
    public String toString(){
        return "Media{" + "titre='" + titre + '\'' + ", numeroMedia=" + numeroMedia + '}';
    }

    public boolean plusPetit(Media doc){
        // si this et doc sont des livres on fait le tri entre eux
        if(this.ordreMedia()==1 && doc.ordreMedia()==1){
            if(this.numeroMedia<doc.numeroMedia) return true;
            return false;
        }
        // si l'objet que l'on ajoute est un livre et que l'objet courant de la mediatheque ne l'est pas on return false sans comparer le numero d'ordre
        if(this.ordreMedia()==1 && doc.ordreMedia()!=1) return false;
        // si l'objet que l'on ajoute n'est pas un livre et que l'objet courant de la mediatheque en est un on return true sans comparer le numero d'ordre
        if(this.ordreMedia()!=1 && doc.ordreMedia()==1) return true;
        if(this.numeroMedia<doc.numeroMedia) return true;
        return false;
    }

    // fonction insatisfaisante
    public boolean plusPetit(Livre doc){
        if(this instanceof Dictionnaire) return true;
        if(this.numeroMedia<doc.getNumero()){
            return true;
        }
        return false;
    }

    public int ordreMedia(){
        return -1;
    }
}
