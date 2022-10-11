package volume1.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RestrictionsAndLimitationsForGenerics {
    public static void main(String[] args) {
//        runtimeTypeInquiryRawTypes();

        noArrayOfParameterizedType();
    }

    // eight primitive type must use their wrapper types
    public static void noPrimitiveType(){
        // Pair<int> p1; after erasure , jvm use Object to store value ,
        Pair<Integer> p2;
    }

    public static void runtimeTypeInquiryRawTypes(){
        Pair<Integer> a = new Pair<Integer>();
//Type parameter 'java.lang.Number' is not within its bound; should implement 'java.lang.Comparable'
//        if(a instanceof Pair<Number>){
//            System.out.println("yes");
//        }
        if(a instanceof Pair<Integer>){
            System.out.println("yes");
        }
        Pair<String> stringPair = new Pair<>();
        Pair<Empolyee> empolyeePair = new Pair<>();

        if(stringPair.getClass() == empolyeePair.getClass()){
            System.out.println(stringPair.getClass().getName());
        }

    }

    public static void noArrayOfParameterizedType(){
        //Pair<String>[] table = new Pair<String>[10];

//        Pair<String>[] table = new Pair<>[10];
//
//        Object[] a= table;
//
//        a[0]="String";
//
//        System.out.println(a);

        Pair<String>[] table = (Pair<String>[])new Pair<?>[10];

        table[0] = new Pair<String>();

        System.out.println(table);

        //the best way is using ArrayList  => safe and effective


        ArrayList<Pair<String>> list = new ArrayList<>();

        list.add(new Pair<String>());
       //  list.add(new Pair<Integer>());

    }
    private static <T> void addAll(Collection<T> coll, T... ts){

        for(T t :ts) {
            coll.add(t);
        }


    }
    public static void varargsWarnings(){
//
//        Collection<String> collection = new Collection<String>();
    }

    public static void canNotInstantiateTypeVariables(){

    }

















}
