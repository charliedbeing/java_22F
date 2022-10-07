package volume1;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

class TimerPrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone,the time is " +new Date());
        java.awt.Toolkit.getDefaultToolkit().beep();
    }

}

class Greeter{
    public void greet(Object t){
        System.out.println("hello world");
        System.out.println(t);
    }
//    public void greet(){
//        System.out.println("hello world");
//    }
}

class TimedGreeter extends Greeter{
    public void greet(){
        Timer t = new Timer(1000, super::greet);
        t.start();
    }
}


public class Interfaces {

    public static void main(String[] args) {
       // lambdaTest();
        //t();

        //testMethodReference();

       repeatMessage("Hello, charlie",2000);

       // interfaceCallback();


      //  getALlThreads();
    }


    public static void getALlThreads(){
        Set<Thread> threads = Thread.getAllStackTraces().keySet();
        System.out.printf("%-15s \t %-15s \t %-15s \t %s\n", "Name", "State", "Priority", "isDaemon");
        for (Thread t : threads) {
            System.out.printf("%-15s \t %-15s \t %-15d \t %s\n", t.getName(), t.getState(), t.getPriority(), t.isDaemon());
        }
    }

    /**
     *Name            	 State           	 Priority        	 isDaemon
     * Reference Handler 	 RUNNABLE        	 10              	 true
     * AWT-Windows     	 RUNNABLE        	 6               	 true
     * Attach Listener 	 RUNNABLE        	 5               	 true
     * AWT-EventQueue-0 	 WAITING         	 6               	 false
     * AWT-Shutdown    	 TIMED_WAITING   	 5               	 false
     * Monitor Ctrl-Break 	 RUNNABLE        	 5               	 true
     * main            	 RUNNABLE        	 5               	 false
     * Signal Dispatcher 	 RUNNABLE        	 9               	 true
     * Image Fetcher 0 	 TIMED_WAITING   	 8               	 true
     * Java2D Disposer 	 WAITING         	 10              	 true
     * Finalizer       	 WAITING         	 8               	 true
     * Common-Cleaner  	 TIMED_WAITING   	 8               	 true
     * TimerQueue      	 TIMED_WAITING   	 5               	 true
     */
    public static void repeatMessage(String text,int delay){

        ActionListener listener =  event ->{
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };
//        ActionListener listener = new TimerPrinter();

        Timer t =  new Timer(delay,listener);
         t.start();

        JOptionPane.showMessageDialog(null,"Quit program?");

        getALlThreads();

        System.exit(0);
    }


    public static void testMethodReference(){
        TimedGreeter t = new TimedGreeter();
        t.greet();
    }

    public static void  interfaceCallback(){

        ActionListener listener = new TimerPrinter();
        Timer t = new Timer(1000,listener);
        t.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    public static void lambdaTest(){
        String[] planets =new String[]{"Mercury", "Venus", "Earth", "Mars",
                 "Jupiter", "Saturn", "Uranus", "Neptune" };
        System.out.println(Arrays.toString(planets));
//        System.out.println("Sorted in dictionary order");
//        Arrays.sort(planets);
//        System.out.println(Arrays.toString(planets));
//        System.out.println("Sort by length");
//        Arrays.sort(planets,(first, second)->{
//            return first.length()-second.length();
//        });

        Arrays.sort(planets,String::compareToIgnoreCase);

        System.out.println(Arrays.toString(planets));

//        Timer t = new Timer(1000, event -> {
//            System.out.println(event);
//            System.out.println("The time is " + new Date());
//        });

        Timer t = new Timer(1000, System.out::println);

        t.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    public static void t() {
        ArrayList<String> l = new ArrayList<>();
        l.add("abac");
        l.add("a");
        l.removeIf(s->s.length() >2);

        System.out.println(l);
    }

}
