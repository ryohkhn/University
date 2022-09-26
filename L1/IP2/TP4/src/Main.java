public class Main {

    public static void main(String[] args) {
        Groupe a=new Groupe();
        Groupe b=new Groupe();
        Robot r=new Robot('a',"yo yo yo");
        Robot r2=new Robot('b',"hoy hoy hoy");
        Robot r2d2=new Robot('c',"hey hey hey");
        Robot r2d3=new Robot('d',"ha ha ha");
        a.prendreTete(r);
        a.ajouteNouveau(r2);
        a.ajouteNouveau(r2d2);
        a.ajouteNouveau(r2d3);
        b.prendreTete(r);
        b.ajouteNouveau(r2);
        GroupeArray test=new GroupeArray(2);
        test.getTab()[0]=a;
        test.getTab()[1]=b;
        for(int i=0;i<test.effectifs().length;i++){
            System.out.println(test.effectifs()[i]);
        }
    }
}
