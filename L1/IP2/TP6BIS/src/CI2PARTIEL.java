public class CI2PARTIEL {
    public  static  void  main(String [] args){
        int i = 0; // 0
        int  tmp = 1; // 1
        while(i<10){ // 2 saut condi
            tmp *= v(i); // 3 empiler // 4 dépiler
            i++; // 5
        }// 6 saut incondi
        System.out.println(tmp); // 7
    } // exit

    static  int u(int n){
        return  2+n; // 100 set valRet
    } // 101 peek

    static  int v(int n) {
        return u(n); // 200 set valRet
    } // 201 
}
