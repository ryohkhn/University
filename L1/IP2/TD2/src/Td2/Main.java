package Td2;

public class Main {

    public static void main(String[] args) {
        Confiture peche=new Confiture("peche",40,50);
        System.out.println(peche.description());
        Confiture c1=new Confiture("fraise",50,120);
        Confiture c2=new Confiture("fraise",50,120);
        System.out.println(c1.egal(c2));
        System.out.println(c1==c2);
        Pot p=new Pot(c1,200);
        Pot p2=new Pot(c2,100);
        Pot p3=new Pot(c2,20);
        System.out.println(Pot.getNumero(c1));
    }
}
