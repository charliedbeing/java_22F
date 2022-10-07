package volume1;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ClientInfoStatus;
import java.util.Comparator;
import java.util.Date;
import java.util.function.IntConsumer;

/** Lambda -> executing code later. Running the code
 * in a separate thread
 * multiple times
 * at the right point in an algorithm (for example, the comparison operation in sorting)
 * when something happens( a button was clicked, data has arrived, and so on)
 * only when necessary (memory collection to release useless part)
 */
public class LambdaExpress {

    public static void main(String[] args) {

        // repeat("charlie",3);

        test_repeat_threads_upgrade();
    }
    public static void test_repeat_threads(){
        repeat_threads(50,()-> System.out.println(new Date().getTime()));
    }

    public static void test_repeat_threads_upgrade(){
        repeat_threads_upgrade(6,(i)-> System.out.println("Countdown" + (9-i)) );
    }

    public static void repeat_threads(int n, Runnable action){
        for(int i=0;i<n;i++){
            action.run();
        }
    }

    public static void repeat_threads_upgrade(int n, IntConsumer action){
        for(int i=0;i<n;i++){
            action.accept(i);
        }
    }



    /*Variable used in lambda expression should be final or effectively final
    *
    * An effectively final variable that is never assigned a new value after it has been initialized.
    * */
    public static void countDown(int start, int delay){
        ActionListener listener = event ->{
//            start --;
//            System.out.println(start);
            System.out.println(String.valueOf(start));
        };
        new Timer(delay, listener).start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    public static void repeat(String text, int count){
        for(int i=1; i <= count; i++){
            ActionListener listener = event ->{
                // here i can not be changed by outer controller, i must key invariables.
               // System.out.println(i+":"+ text);
                System.out.println(":"+ text);

            };
            new Timer(1000, listener).start();
        }

        JOptionPane.showMessageDialog(null,"Quit program?");

        Interfaces.getALlThreads();

        System.exit(0);

    }

    /**
     * The body of a lambda experssion has the same scope of a nested block,
     * The same rules for name conflict and shadowing apply
     */
    public static void nameConflicts(){
        Path first_ = Paths.get("c://");
        Comparator<String> comp = (first,second)->{
            return first.length() - second.length();
        };

    }

    public void init(){
        ActionListener listener = event->{
            // here this refer the object which hold init method. here is LambdaExpress
            System.out.println(this.toString());
        };
    }
}
