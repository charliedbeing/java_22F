package volume1.innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AnonymousInnerClass {

    public static void main(String[] args) {

    }
    // 1: anonymous inner class version
    public void start(int interval, boolean beep){
        /** ActionListener named SuperType
         * can be an interface,then the inner class implement that interface,
         * SuperType can be a class, then
         * the inner class extends that class.
         */
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is" + new Date());
                if(beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval,listener);
        t.start();
    }
    //2 lambda version
    public void start2(int interval, boolean beep){

        Timer t = new Timer(interval, event ->{
            System.out.println("At the tone, the time is" + new Date());
            if(beep)  Toolkit.getDefaultToolkit().beep();
        });
         t.start();
        }

}
