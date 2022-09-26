import java.util.Arrays;

public class Espace extends ChaineCar{
    private int size=1;

    @Override
    public int len(){
        return this.size;
    }

    @Override
    public String toString(){
        char[] array=new char[this.size];
        Arrays.fill(array, ' ');
        return new String(array);
    }

    public void setSize(int size){
        this.size=size;
    }
}
