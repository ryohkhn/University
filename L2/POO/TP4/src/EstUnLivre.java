public class EstUnLivre extends Predicat{
    @Override
    public boolean estVrai(Media m){
        if(m.ordreMedia()==1) return true;
        return false;
    }
}

