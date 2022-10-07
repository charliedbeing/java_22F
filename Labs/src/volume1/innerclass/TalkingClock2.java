package volume1.innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

// volume1.innerclass.TalkingClock2$1TimerPrinter
public class TalkingClock2 {

    public static void main(String[] args) {

    }

    public void start(int interval, boolean beep){

        class TimerPrinter implements ActionListener{

            /** since this method will be executed after start method finished, and then beep is lost his environment,
             * so The TimePrinter class must have copied the beep field as a local variable of the start method,before
             * the beep parameter value went away.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");
                if(beep){
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        ActionListener listener = new TimerPrinter();
        Timer t = new Timer(interval,listener);
        t.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    public static void effectivelyFinal(){
        Date[] dates = new Date[100];
        int[] counter = new int[1];
        //  int counter2 =0;
        for(int i=0;i<dates.length;i++){
            dates[i] = new Date(){
                public int compareTo(Date other){
                 counter[0]++;

                   // counter2++; //Variable 'counter2' is accessed from within inner class, needs to be final or effectively final
                 return super.compareTo(other);
                }
            };

        }
    }

}
