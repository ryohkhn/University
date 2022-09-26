public class Main {

    public static void main(String[] args) {
        int[] tab={2,9,4,6,7,10};
        int[] res=Fusion_Rodriguez_Lucas.fusion(tab);
        for(int i=0;i<tab.length;i++) {
            System.out.print(res[i]+" ");
        }
    }
}
