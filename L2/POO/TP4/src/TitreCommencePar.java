public class TitreCommencePar extends Predicat{
    public char lettre;

    public TitreCommencePar(char lettre){
        this.lettre=Character.toLowerCase(lettre);
    }

    public boolean estVrai(Media m){
        if(Character.toLowerCase(m.getTitre().charAt(0))==this.lettre) return true;
        return false;
    }
}
