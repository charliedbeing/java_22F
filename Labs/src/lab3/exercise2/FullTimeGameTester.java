package lab3.exercise2;

public class FullTimeGameTester extends GameTester{

    public FullTimeGameTester(){
        name="FullTime";
        isFullTime =true;
    }
    @Override
    double salary() {
        return 3000;
    }

    @Override
    public String toString() {
        return "My tester type is " + name + " my salary is "+ salary();
    }
}
