package lab3.exercise3;

import javax.swing.*;

public class ProcessMortgage {
    public static void main(String[] args) {
        Mortgage[] threeMortgage= new Mortgage[3];

        JOptionPane.showMessageDialog(null,"Welcome to use "+Mortgage.backName+"\n"+" you can used 3 times" );

        for(int i=0;i<3;i++){

            Mortgage m =null;

            int term = 1;
            try{
                term = Integer.parseInt(JOptionPane.showInputDialog("times: ["+(i+1)+ "], which term do you want to choose? choose one from [1,3,5]"));
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"you must input number, you can only input once!");
                term =Integer.parseInt(JOptionPane.showInputDialog("times: ["+(i+1)+ "], which term do you want to choose? 1 or 3 or 5 ? "));
            }


            String type = JOptionPane.showInputDialog("times: ["+(i+1)+ "], Are you Business or Personal ?");

            if(type.toLowerCase().contains("p")){
                m = new PersonMortgage(term);
            } else if (type.toLowerCase().contains("b")) {
                m = new BusinessMortgage(term);
            }

            for(int j=0;j<2;j++){
                if(j ==0){
                    String name = JOptionPane.showInputDialog("times: ["+(i+1)+ "], please input your name .");
                    m.setCustomerName(name);
                }else if(j ==1){
                    double mortgageAmount =0;
                    try{
                        mortgageAmount = Double.parseDouble(JOptionPane.showInputDialog("times: ["+(i+1)+ "], please input your mortgage amount .")) ;
                    }
                    catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null,"you must input number, you can only input once!");
                        mortgageAmount = Double.parseDouble(JOptionPane.showInputDialog("times: ["+(i+1)+ "], please input your mortgage amount with number:")) ;
                    }

                    m.setAmountMortgage(mortgageAmount);
                }
           }
            threeMortgage[i] = m;
        }
        for(Mortgage m : threeMortgage){
            JOptionPane.showMessageDialog(null,m.getMortgageInfo());
        }
    }
}
