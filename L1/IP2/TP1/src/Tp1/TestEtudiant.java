package Tp1;

public class TestEtudiant {
    public static void main(String[] args){
        Edudiant lu=new Edudiant("Rodriguez","Lucas",22002335,-2);
        Edudiant la=new Edudiant("Benseddiq","Laurence",1234567,0);
        Edudiant.afficher(la);
        Edudiant.afficher(lu);
        System.out.println(Edudiant.mention(lu));
        System.out.println(Edudiant.mention(la));
    }
}
