package lab2;

import javax.swing.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;



public class Exercise1 {
    class QuestionAndAnswer{
        private String question;
        private String[] answers;
        private int answerKey;

        public QuestionAndAnswer(String q, String[] a, int k){
            question =q;
            answers =a;
            answerKey =k;
        }
        
        public String getQuestionWithOptionalAnswers(){
            String allAnswer ="";
            for(String a :answers){
                allAnswer +=a+" , ";
            }
            return question +"["+allAnswer+"]";
        }
        
        public String getKey(){
            String result="";

            if(this.answerKey ==0){
                result="A";
            } else if (this.answerKey ==1) {
                result="B";
            }else if (this.answerKey ==2) {
                result="C";
            }else if (this.answerKey ==3) {
                result="D";
            }
            return result;
        }

    }
    
    private final static String[] congratulatoryMessages= {"Excellent!","Good!","Keep up the good work!","Nice work!"};
    private final static String[] incorrectlyMessages= {"No. Please try again", "Don't give up!", "Wrong. Try once more","No. Keep trying.."};
    private final static Random random_gernerator = new Random();

    private List<QuestionAndAnswer> questsionAndAnswers;
    private int correctAnswerAmount =0;

    public int getCorrectAnswerAmount() {
        return correctAnswerAmount;
    }

    public int getWrongAnswerAmount() {
        return wrongAnswerAmount;
    }

    private int wrongAnswerAmount=0;

    public void setCorrectAnswerAmount(){
        correctAnswerAmount +=1;
    }

    public void setWrongAnswerAmount(){
        wrongAnswerAmount +=1;
    }


    public Exercise1(){
        questsionAndAnswers= new ArrayList<>();
        // "1: java ",new String[]{"A:yes","B:no","C:yes","D:no","key:0"}
        questsionAndAnswers.add(new QuestionAndAnswer("1: java ",new String[]{"A:yes","B:no","C:yes","D:no"},0));
        questsionAndAnswers.add(new QuestionAndAnswer("2: java ",new String[]{"A:yes","B:no","C:yes","D:no"},1));
        questsionAndAnswers.add(new QuestionAndAnswer("3: java ",new String[]{"A:yes","B:no","C:yes","D:no"},1));
        questsionAndAnswers.add(new QuestionAndAnswer("4: java ",new String[]{"A:yes","B:no","C:yes","D:no"},2));
        questsionAndAnswers.add(new QuestionAndAnswer("5: java ",new String[]{"A:yes","B:no","C:yes","D:no"},3));
    }

    public Exercise1(List<QuestionAndAnswer> questsionAndAnswers){
        this.questsionAndAnswers = questsionAndAnswers;
    }
    
    private void simulateQuestion(){
        String m = JOptionPane.showInputDialog("Are you right to answer questions?");
        
        if("yes".equalsIgnoreCase(m) || "y".equals(m)){
            for(QuestionAndAnswer q : this.questsionAndAnswers){

                String questionAndAnswers = q.getQuestionWithOptionalAnswers();
                String solution = JOptionPane.showInputDialog(questionAndAnswers);

                String response = checkAnswer(q,solution);
                JOptionPane.showMessageDialog(null,response);

            }
            String finalResult ="Correct times: "+ this.getCorrectAnswerAmount() + "Wrong times: "+ this.getWrongAnswerAmount();

            JOptionPane.showMessageDialog(null,finalResult);

        }

    }

    private String checkAnswer(QuestionAndAnswer q, String resposne){
        String response ="";
        if(resposne.equalsIgnoreCase(q.getKey())){
            response = generateMessage(true);
            setCorrectAnswerAmount();
        }else{
            response = generateMessage(false);
            setWrongAnswerAmount();
        }
        return response;
    }

    private String generateMessage(boolean isCorrect)
    {
        String result="";
        if(isCorrect){
            result= congratulatoryMessages[random_gernerator.nextInt(4)];
        }else{
            result= incorrectlyMessages[random_gernerator.nextInt(4)];
        }
        return result;
    }

    public void inputAnswer(){
        simulateQuestion();
    }


    public static void main(String[] args) {
        Exercise1 e = new Exercise1();
        e.inputAnswer();

    }

    public static void test1(){

        String[] options = {"abc", "def", "ghi", "jkl"};
        //Integer[] options = {1, 3, 5, 7, 9, 11};
        //Double[] options = {3.141, 1.618};
        //Character[] options = {'a', 'b', 'c', 'd'};
        int x = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        System.out.println(x);


//        String m = JOptionPane.showInputDialog("Anyone there?");
//        System.out.println(m);
//
//        JOptionPane.showOptionDialog()
//
//
//        for(int i=0;i<10000;i++){
//            int num = random_gernerator.nextInt(4);
//            if(num==3){
//                System.out.println("--");
//            }
//
//        }
    }




}
