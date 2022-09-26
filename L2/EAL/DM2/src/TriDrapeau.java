public class TriDrapeau {

    public static void tri(int[] t){
        int p = 0;
        int m = 0;
        int g = t.length - 1;
        int temp;
        while (m <= g) {
            switch (t[m]) {
                case 0:
                    temp = t[m];
                    t[m] = t[p];
                    t[p] = temp;
                    m += 1;
                    p += 1;
                    break;
                case 1:
                    m += 1;
                    break;
                case 2:
                    temp = t[m];
                    t[m] = t[g];
                    t[g] = temp;
                    g -= 1;
                    break;
            }
        }
        for (int j : t) {
            System.out.print(j + " ");
        }
    }
}
