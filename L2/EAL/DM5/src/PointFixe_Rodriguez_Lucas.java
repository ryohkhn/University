public class PointFixe_Rodriguez_Lucas{

    /*
    Q1.
    T=[-1,0,1,3,4,8]
    Pré-points : -1,0,1,3,4
    Post-points : 3,4,8

    Q2.
    Si un tableau T est trié, alors les points fixes seront entre les pré-points fixes et les post-points fixes.

    Q3.
    La complexité est de log n dans le pire des cas
     */

    // on utilise la dichotomie en regardant si la valeur est fixe ou non, sinon on regarde si elle est inférieure ou supérieure
    public static boolean fixe(int[] t){
        int l=0;
        int r=t.length-1;
        int mid;
        while(l<=r){
            mid=(l+r)/2;
            if(t[mid]==mid){
                return true;
            }
            if(t[mid]<mid){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] t={-1,0,1,3,5,8};
        System.out.println(fixe(t));
    }
}
