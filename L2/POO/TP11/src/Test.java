import java.util.ArrayList;
import java.util.Arrays;

public class Test{
    public static void main(String[] args){
        /*TabSet<Boolean> tabSet=new TabSet<>(5);
        Boolean a=true;
        Boolean b=false;
        ArrayList<Boolean> list=new ArrayList<>();
        list.add(a);
        list.add(b);
        tabSet.addAll(list);
        ArrayList<Boolean> list2=new ArrayList<>();
        list2.add(a);
        list2.add(b);
        System.out.println(tabSet.removeAll(list));

         */

        TabSet<Integer> tabSetInt=new TabSet<>();
        Integer a2=3;
        Integer b2=2;
        Integer c2=1;
        Integer d2=5;
        Integer e2=10;
        ArrayList<Integer> listInt=new ArrayList<>();
        listInt.add(a2);
        listInt.add(b2);
        listInt.add(c2);
        listInt.add(d2);
        listInt.add(e2);
        tabSetInt.addAll(listInt);
        //ArrayList<Integer> listInt2=new ArrayList<>();
        //listInt2.add(b2);
        //listInt2.add(c2);
        //tabSetInt.removeAll(listInt2);
        //tabSetInt.retainAll(listInt2);
        System.out.println(Arrays.toString(tabSetInt.tableau));
    }
}
