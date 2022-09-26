public class Groupe extends TabSet<Personnage>{

    public int score(){
        int res=0;
        for(Personnage personnage:tableau){
            res+=Personnage.scores.get(personnage);
        }
        return res;
    }

}
