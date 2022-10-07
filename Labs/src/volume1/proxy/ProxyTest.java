package volume1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class Person implements Comparable{

    private int age;
    private String name;

    public Person(int a, String n){
        age =a;
        name =n;
    }
    public int getAge(){
        return age;
    }


    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;
        return this.age -p.getAge();
    }

    @Override
    public String toString() {
        return this.name +'-'+this.age;
    }
}



class TraceHandler implements InvocationHandler {
    private Object target;
    public TraceHandler(Object t){
        target =t;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("."+ method.getName() +"(");
        String temp="";
        if(args !=null){
            for(int i=0;i<args.length;i++){
                System.out.print(args[i]);
                temp += args[i].toString();
                if(i<args.length-1) System.out.print(", ");
            }
        }
        System.out.println(")");
        System.out.println("args is :" +temp);

        return method.invoke(target,args);
    }
}


public class ProxyTest {

    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        Object[] elements = new Object[1000];

        Object[] elements2 = new Object[1000];

        for(int i=0;i<elements.length;i++){
            Integer value = i+1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
            elements[i] = proxy;
            elements2[i]= value;
        }

        Integer key = new Random().nextInt(elements.length)+1;
        System.out.println(key);

        int result = Arrays.binarySearch(elements,key);

        if(result >0) System.out.println(elements[result]);

    }

    public static void test2(){

        Object[] elements = new Object[100];

        for(int i=0;i<elements.length;i++){
            Person p = new Person(i+1,"name"+(i+1));

            InvocationHandler handler = new TraceHandler(p);

            Object proxy = Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
            elements[i] = proxy;

        }

        int num = new Random().nextInt(elements.length) +1;
        Person key =new Person(num,"name"+num);


        int result = Arrays.binarySearch(elements,key);

        if(result >0) System.out.println(elements[result]);

    }


}
