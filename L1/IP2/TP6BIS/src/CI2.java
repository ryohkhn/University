public class CI2 {
    static int i=0, j, km=20, mun =20; //0 //1 //2 //3

    static void tirs (){
        System.out.println("␣début␣tirs"); // 100
        for(j=1; j<=5; j++){ // 101 saut condi
            cible (); // 102 saut incondi
        }// 103 j++ // 104 saut incondi
        System.out.println("␣fin␣tirs"); // 105
    }// 106 saut incondi

    static void cible (){
        System.out.println("␣␣cible␣"+j); // 200
        mun --; // 201
    } // 202 saut incondi

    static void tour (){
        System.out.println("dans␣le␣tour␣"+(++i)); // 300 // 301 i++
        km -=4; // 302
    } // saut incondi

    public static void  main(String [] args){
        tour (); // 4 saut incodi
        while(i <=4){ // 5 saut condi
            tirs (); // 6 saut incondi
            tour (); // 7 saut incodi
        }// 8 saut incondi
    }// 9 exit
}
