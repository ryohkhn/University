import java.util.Iterator;

public class TestIter<E> implements Iterator<E>{
    private final E[] tableau;
    private int index;

    public TestIter(E[] tableau){
        this.tableau=tableau;
        index=-1;
    }

    @Override
    public boolean hasNext(){
        if(index+1==tableau.length){
            return false;
        }
        return true;
    }

    @Override
    public E next(){
        if(hasNext()){
            index++;
            return tableau[index];
        }
        return null;
    }
}
