public class GroupeArray {
    private Groupe[] tab;

    public GroupeArray(int nbr){
        this.tab=new Groupe[nbr];
    }

    public Groupe[] getTab() {
        return tab;
    }

    //La fonction attribuera -1 à la case si jamais il n'y a aucun robot dans le groupe de l'objet

    public int[] effectifs(){
        if(this.tab==null){
            return null;
        }
        int[] res=new int[this.tab.length];
        for(int i=0;i<res.length;i++){
            res[i]=this.tab[i].effectifs();
        }
        return res;
    }
}
