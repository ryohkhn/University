import java.util.Arrays;

public class TriBinaire implements Triable{
    private String[] tab;

    public TriBinaire(String[] tab){
        this.tab=tab;
    }

    // permet de convertir un nombre binaire en nombre décimal, pour ensuite le comparer
    private static int binaryToDecimal(String n){
        int res=0;
        int base=1;
        int temp=Integer.parseInt(n);
        while (temp>0) {
            int last_digit=temp%10;
            temp=temp/10;
            res+=last_digit*base;
            base=base*2;
        }
        return res;
    }

    @Override
    public void echange(int i, int j){
        String tmp=tab[i];
        tab[i]=tab[j];
        tab[j]=tmp;
    }

    @Override
    public boolean plusGrand(int i, int j){
        if(binaryToDecimal(tab[i])>binaryToDecimal(tab[j])){
            return true;
        }
        return false;
    }

    @Override
    public int taille(){
        return this.tab.length;
    }

    @Override
    public String toString(){
        return "TriBinaire{"+"tab="+Arrays.toString(tab)+'}';
    }
}
