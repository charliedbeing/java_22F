package lab2;

public class OverLoadMethodDemo {
    public static void main(String[] args) {
        sayHi();
        sayHi("charlie");
        sayHi("fiona","charlie");
    }

    public static  void  sayHi(){
        System.out.println("hello,");
    }

    public static void sayHi(String name){
        System.out.println(name + ",is saying:  How are you?");
    }

    public static void sayHi(String oneName, String anotherName){
        System.out.println(
                oneName +" say hi to " + anotherName + ",  How is going?"
        );
    }


}
