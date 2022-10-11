package lab3.exercise1;

public abstract class Insurance {

    protected String type;
    protected double monthlyCost;

    public String getType(){
        return type;
    }
    public double getMonthlyCost(){
        return monthlyCost;
    }

    public abstract void setInsuranceCost(double cost);
    public abstract  void displayInfo();
}
