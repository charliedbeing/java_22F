package lab3.exercise1;

public class Health extends Insurance{

    public Health(){
        type="Health";
    }
    @Override
    public void setInsuranceCost(double cost) {
        monthlyCost =cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Insurance type is" + type + " monthlyCost is " + getMonthlyCost());
    }
}
