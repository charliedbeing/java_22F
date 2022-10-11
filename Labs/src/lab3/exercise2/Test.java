package lab3.exercise2;

import javax.swing.*;

public abstract class Test {

    public static void main(String[] args) {
        inputTester();
    }

    public static void inputTester(){
        JOptionPane.showMessageDialog(null,"Welcome to input Tester!, you can use 2 times");

        GameTester tester = null;

        for(int i=0;i<2;i++){

            String type = JOptionPane.showInputDialog("times : [" + (i+1)  +"] What is your tester type ? FullTime or PartTime");

            if("FullTime".equalsIgnoreCase(type)){
                tester = new FullTimeGameTester();

            }else if("PartTime".equalsIgnoreCase(type)){
                double hours = Double.valueOf(JOptionPane.showInputDialog("What are your hours?")).doubleValue();
                tester = new PartTimeGameTester(hours);

            }
            JOptionPane.showMessageDialog(null,tester.toString());

        }

    }
}
