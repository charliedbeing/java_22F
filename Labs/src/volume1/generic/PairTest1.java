package volume1.generic;

import java.util.Arrays;

public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Mary","had","a","little","lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());

        String middle = ArrayAlg.<String>getMiddle("Charlie","Fiona","Daniel","dad");
        System.out.println(middle);

        double middle2 = ArrayAlg.getMiddle(3.12,343.9,0.8);
        System.out.println(middle2);

    }

}
class ArrayAlg{
    public static Pair<String> minmax(String[] a){
        if(a==null || a.length ==0) return null;
        String min = a[0];
        String max = a[0];

        for(int i=0;i<a.length;i++){
            if(min.compareTo(a[i])>0) min= a[i];
            if(max.compareTo(a[i])<0) max = a[i];
        }
        return new Pair<>(min,max);
    }

    public static <T> T getMiddle(T... a){
        return a[a.length/2];
    }
}
