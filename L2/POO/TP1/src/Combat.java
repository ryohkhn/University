public class Combat {
    Personnage p1;
    Personnage p2;

    public Combat(String nomPerso1,String nomPerso2){
        // comme la force et l'agilité est la même lors de la création, si un combat est lancé comme tel le problème expliqué en commentaire de l'exercice 4 est présent
        p1=new Personnage(nomPerso1);
        p2=new Personnage(nomPerso2);
        p2.getActuel().setForce(12);
    }

    public void combatStart(){
        p1.lutteRec(p2);
    }

    public static void main(String[] args){
        Combat test=new Combat("Lucas","Vincent");
        test.combatStart();
    }
}
