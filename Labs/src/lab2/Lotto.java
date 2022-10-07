package lab2;

import javax.swing.*;
import java.util.Random;

public class Lotto {

        private int[] lottoNums;
        private int chooseNum=0;

        public Lotto(){
            lottoNums = new int[3];
        }


    public  int[]  initLotto(Random r ){
        lottoNums[0] =1+ r.nextInt(9);
        lottoNums[1] =1+ r.nextInt(9);
        lottoNums[2] =1+ r.nextInt(9);
        return this.lottoNums;
    }

    private int getTotalFromLottoNums(int[] ln){
        return   ln[0]+ln[2]+ln[1];
    }

    private String getThreeNumbersFromLottoNums(int[] ln){
        return "["+ln[0]+","+ln[1]+","+ln[2]+"]";
    }



    public void play(){
        String m = JOptionPane.showInputDialog("which number do you want to reach from 3-27 ?");
        chooseNum = Integer.valueOf(m);
        Random r = new Random();
        boolean isComputerWin = true;

        for(int i=0;i<5;i++){
            int[] times = initLotto(r);
            int total = getTotalFromLottoNums(times);
            String result = "times:["+(i+1)+"], three numbers: "+ getThreeNumbersFromLottoNums(times) + "total:"+ total;
            if(total == chooseNum){
                String message ="You Win!"+ result;
                isComputerWin =false;
                JOptionPane.showMessageDialog(null,message);
                break;
            }else{
                JOptionPane.showMessageDialog(null,result);
            }
        }

        if(isComputerWin){
            String message ="Computer Win!,";
            JOptionPane.showMessageDialog(null,message);
        }
    }

    public static void main(String[] args) {
        Lotto l = new Lotto();
        l.play();
    }

}
