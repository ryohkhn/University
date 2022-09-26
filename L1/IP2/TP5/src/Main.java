public class Main {

    public static void main(String[] args) {
        Employe e1=new Employe("Lucas",2400);
        Employe e2=new Employe("Antoine",2500);
        Employe e3=new Employe("Pierre",3000);
        Employe e4=new Employe("Paul",2650);
        Employe e5=new Employe("Edgar",2800);
        Entreprise e=new Entreprise("Sony");
        Entreprise b=new Entreprise("test");
        e.ajout(e1);
        e.ajout(e2);
        e.ajout(e3);
        b.ajout(e4);
        b.ajout(e5);
        //e.acquisition_Version_2(b);
        e.afficher();
    }
}
