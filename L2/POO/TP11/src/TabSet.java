import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class TabSet<E> implements Iterable<E>, Set<E>{
    public E[] tableau;

    @SuppressWarnings("unchecked")
    public TabSet(){
        tableau=(E[]) new Object[10];
    }

    @Override
    public Iterator<E> iterator(){
        return new TabIter();
    }

    @Override
    public Object[] toArray(){
        // on crée le nouveau tableau et attribue chaque valuer non nulle au tableau
        Object[] res=new Object[size()];
        int compt=0;
        for(E e : tableau){
            if(e!=null){
                res[compt]=e;
                compt++;
            }
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a){
        int compt=0;
        // si le tableau en argument est plus petit que le nombre de valeurs non nulles
        if(a.length<size()){
            Class<?> c=a.getClass().getComponentType();
            T[] tab2=(T[]) Array.newInstance(c,size());
            for(E e : tableau){
                if(e!=null){
                    tab2[compt]=(T)e;
                    compt++;
                }
            }
            return tab2;
        }
        // on remplit le tableau avec les valeurs du tableau
        for(E e : tableau){
            if(e!=null){
                a[compt]=(T)e;
                compt++;
            }
        }
        // on complète le tableau a par des valeurs nulles
        for(int i=compt;i<a.length;i++){
            a[i]=null;
        }
        return a;
    }

    // fonction vérifiant si l'object est contenu dans le tableau
    public boolean contains(Object o){
        for(E e : tableau){
            if(e!=null && e.equals(o)){
                if(e.hashCode()==o.hashCode())
                return true;
            }
        }
        return false;
    }

    public int size(){
        // compteur pour les valeurs non nulles
        int compt=0;
        for(E e : tableau){
            if(e!=null){
                compt++;
            }
        }
        return compt;
    }

    public boolean isEmpty(){
        return (size()==0);
    }

    @SuppressWarnings("unchecked")
    public boolean add(E e){
        // on add que si e n'est pas présent dans le tableau
        if(contains(e)){
            return false;
        }
        // si la taille est plus grande que le tableau on crée un nouveau tableau plus grand et on remplace le tableau
        if(size()>=tableau.length){
            E[] tmp=(E[]) new Object[tableau.length*2];
            tableau=toArray(tmp);
        }
        // on appelle add de tabIter
        TabIter it=(TabIter)iterator();
        it.add(e);
        return true;
    }

    public boolean remove(Object o){
        TabIter it=new TabIter();
        E e;
        // on remove que si l'object est contenu
        if(contains(o)){
            do{
                e=it.next();
            }
            // on parcourt le tableau jusqu'à l'object qui est o et on le remove
            while(e!=null && !e.equals(o));
            it.remove();
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c){
        // appel de contains sur tous les objects de la collection
        for(Object o : c){
            if(!contains(o)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c){
        // appel de add sur tous les objects de la collection
        for(E e : c){
            if(!add(e)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c){
        // on remove que si tous les objects de la collection sont présents dans le tableau
        if(containsAll(c)){
            for(E e : tableau){
                for(Object o : c){
                    // on remove si l'object n'est pas un object de la collection
                    if(e!=null && !e.equals(o)){
                        remove(e);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c){
        // on remove que si tous les objects de la collection sont présents dans le tableau
        if(containsAll(c)){
            for(E e : tableau){
                for(Object o : c){
                    // on remove si l'object est un object de la collection
                    if(e!=null && e.equals(o)){
                        remove(e);
                    }
                }
            }
            return true;
        }
        return false;
    }

    public void clear(){
        // on vide tout le tableau
        for(E e : tableau){
            if(e!=null){
                remove(e);
            }
        }
    }

    public class TabIter implements Iterator<E>{
        private int index=0;

        @Override
        public boolean hasNext(){
            int indexCopy=index;
            if(indexCopy+1==tableau.length) return false;
            // il y'a un next si on trouve un objet différent de null à partir de l'index
            while(tableau[indexCopy]==null && indexCopy+1<tableau.length){
                indexCopy++;
            }
            if(indexCopy+1==tableau.length) return false;
            return true;
        }

        @Override
        public E next(){
            // on return un next seulement s'il il y'a un next
            if(hasNext()){
                index++;
                while(tableau[index]==null){
                    index++;
                }
                return tableau[index];
            }
            return null;
        }

        public void add(E e){
            if(size()==tableau.length){
                throw new IllegalStateException();
            }
            if(e==null){
                throw new NullPointerException();
            }
            // on parcourt la liste jusqu'à trouver une place libre et on ajoute l'élément
            while(tableau[index]!=null){
                index++;
            }
            tableau[index]=e;
        }

        public void remove(){
            // on supprime l'object à l'index
            tableau[index]=null;
        }
    }
}
