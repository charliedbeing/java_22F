package lab3.exercise1;

import javax.swing.*;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

        Insurance [] insurances = inputInsurance(5);

        alertInsuranceRandom(insurances);


    }

    public static void alertInsuranceRandom(Insurance [] insurances){
        Random r = new Random();

        for(Insurance insurance : insurances){

            String message = insurance.getType() +" original monthlyCost is " + insurance.getMonthlyCost() +"\n";
            double additionalFee = (double)r.nextInt(100);
            double finalFee = insurance.getMonthlyCost() +additionalFee;
            message += " additional fee is " + additionalFee +"\n"+ "final :" + finalFee;
            insurance.setInsuranceCost(insurance.getMonthlyCost() +additionalFee);
            JOptionPane.showMessageDialog(null, message);
        }

    }

    public static Insurance [] inputInsurance(int times){

        Insurance [] insurances = new Insurance[times];
        JOptionPane.showMessageDialog(null,"Welcome to input insurances, your can input[ " +times + "]times");

        for(int i=0;i<times;i++){

            String type = JOptionPane.showInputDialog("["+(i+1)+"]  times , Please input your insurance type (health, or , life)?");
            double cost = Double.valueOf(JOptionPane.showInputDialog("Please input your insurance monthly cost?"));

            Insurance insurance =null;
            if("health".equalsIgnoreCase(type)){
                insurance = new Health();
                insurance.setInsuranceCost(cost);

            }else if ("life".equalsIgnoreCase(type)){
                insurance = new Life();
                insurance.setInsuranceCost(cost);
            }
            insurances[i] = insurance;

        }
        return insurances;
    }
}
