package lab3.exercise2;

public class PartTimeGameTester extends GameTester{

    private double hours;

    public PartTimeGameTester(double h){
        hours = h;
        name ="PartTime";
        isFullTime = false;
    }
    @Override
    double salary() {
        return  hours * 20;
    }

    @Override
    public String toString() {
        return "My tester type is " + name + " my each hour salary is 20, my total salary is : "+ salary();
    }

}

