public class TriDrapeauBicolore {

    public static void tri(int[] t){
        int m=0;
        int g=t.length-1;
        int temp;
        while(m<=g){
            switch (t[m]){
                case 0:
                    m+=1;
                    break;
                case 1:
                    temp=t[m];
                    t[m]=t[g];
                    t[g]=temp;
                    g-=1;
                    break;
            }
        }
        for(int j : t){
            System.out.print(j+" ");
        }
    }

}
