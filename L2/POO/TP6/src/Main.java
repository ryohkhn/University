public class Main {

    public static void main(String[] args) {
        /*
        Rectangle rectangle=new Rectangle(2,2,5,8);
        Ellipse ellipse=new Ellipse(6,6,8,6);
        Carre carre=new Carre(1,1,3);
        Circle cercle=new Circle(-5,-5,10);
        Triangle triangle=new Triangle(0,0,4,3);
        rectangle.affiche();
        System.oFut.println();
        ellipse.affiche();
        System.out.println();
        carre.affiche();
        System.out.println();
        cercle.affiche();
        System.out.println();
        triangle.affiche();
        System.out.println();
        System.out.println(cercle.estDistanteDe(triangle));
         */
        //int[] tab={0,1,1,0,0,0,1,1,0,1};
        //String[] tab={"1110","1111","001","1001","00","011","110","10001","0111","000"};
        String[] tab={"abca","aabc","klm","jd","zzz","zc","za"};
        Triable tabint=new Dictionnaire(tab);
        Triable.triBulles(tabint);
        System.out.println(tabint);
    }
}
