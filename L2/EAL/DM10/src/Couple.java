public class Couple{
    public int val;
    public int nbrEnfant;

    public Couple(int val,int nbrEnfant){
        this.val=val;
        this.nbrEnfant=nbrEnfant;
    }

    @Override
    public String toString(){
        return "Couple{"+
                "val="+val+
                ", nbrEnfant="+nbrEnfant+
                '}';
    }
}
