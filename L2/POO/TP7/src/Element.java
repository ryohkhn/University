abstract class Element{
   public abstract String getType();

    @Override
    public String toString(){
        return "fichier de type " + getType();
    }
}
