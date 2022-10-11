package lab3.exercise1;

public class Life extends Insurance{

    public Life(){
        type="Life";
    }
    @Override
    public void setInsuranceCost(double cost) {
       monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Insurance type is" + type + " monthlyCost is " + getMonthlyCost());
    }
}
