package volume1.generic;

import java.util.Comparator;
import java.util.function.Supplier;

/**
 * 1:There are no generics in the virtual machine,only ordinary classes and mehtods
 * 2:All type parameters are replaced by their bounds
 * 3:Bridge methods are synthesized to preserve polymorphism
 * 4:Casts are inserted as necessary to preserve type safety.
 */
public class Pair <T extends Comparable>{
    private T first;
    private T second;
    public Pair(){
        first=null;
        second=null;

      //  first = new T();
    }
    public Pair(T f, T s){
        first =f;
        second =s;
    }


    public static <T extends Comparable> Pair<T> makePair(Supplier<T> constr){
        return new Pair<>(constr.get(),constr.get());
    }


    public T getFirst(){return first;}
    public T getSecond(){return second;}
    public void setFirst(T newValue){first =newValue;}
    public void setSecond(T newValue){second= newValue;}
}
