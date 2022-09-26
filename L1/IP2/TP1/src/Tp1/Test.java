package Tp1;

public class Test{

    public static void main(String[] args) {
        Fruit f= new Fruit("pamplemousse", 330);
        Fruit g= new Fruit("pamplemousse", 350);
        Fruit i= new Fruit("poire", 50);
        Fruit j= new Fruit("pomme", 100);
        Fruit h= f;
        Fruit []tab= new Fruit[3];
        tab[0]=f;
        tab[1]=j;
        tab[2]=i;
        Panier a= new Panier(tab);
        Panier p= new Panier(g,a);
        Panier.afficher(Panier.hybridePanier(f,p));
        System.out.println("Test terminé");
    }
}
