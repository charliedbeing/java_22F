package volume1.innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/** Inner class are a phenomenon of the compiler,not the virtual machine.
 * Inner class are translated into regular class files with $ delimiting outer and inner class names
 * TalkingClock$TimePrinter.class
 */
public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval,boolean beep){
        this.interval =interval;
        this.beep= beep;
    }

    public void test(){
        //TimerPrinter2 just can be used in start method.
        //TimerPrinter2 t ;
    }

    public void start(){


//        class TimerPrinter implements ActionListener{
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("something");
//            }
//        }

        ActionListener listener = new TimerPrinter();
//        ActionListener listener2 = this.new TimerPrinter();
        Timer t = new Timer(interval,listener);
        t.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

        /**
         * Local class's scope is always restricted to the block in which they are declared.
         * They are completely hidden from the outside world.
         */
        class TimerPrinter2 implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("something");
            }
        }


    }

      class TimerPrinter implements ActionListener{
    // an inner class
        /** We just use this to illustrate the mechanism involved in an inner class
        private TalkingClock outer;
        public TimerPrinter(TalkingClock clock){
            outer = clock;
        }
         then in the method of this inner class, we can use outer
         if(outer.beep)
         {

         }
        */

        /**
         * An inner class method gets to access both its own data fields and those of
         * the outer object creating it.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            if(beep){
                Toolkit.getDefaultToolkit().beep();
            }
            // the same thing
//            if(TalkingClock.this.beep){
//                Toolkit.getDefaultToolkit().beep();
//            }
        }
    }


}
