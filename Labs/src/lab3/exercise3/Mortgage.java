package lab3.exercise3;

public abstract class Mortgage implements MortgageConstants {

    private static long id=1000000l;
    protected  long mortgageNumber;
    protected String customerName;
    protected double amountMortgage;
    protected double interestRate;
    protected int term;

    public void setCustomerName(String n){
        customerName = n;
    }

    public void setAmountMortgage(double amtMortgage){

        amountMortgage = checkAmountMortgage(amtMortgage);
    }

    public Mortgage(){
        mortgageNumber =id;
        id = id+1;

    }

    protected double getBankPrimeRate(int term){

        double bankPrimeRate = getBankPrimeTerm(term);
        return bankPrimeRate;
    }

    protected double checkAmountMortgage(double amount_mortgage){
        double result = amount_mortgage;
        if(result > maxiNumMortgageAmount){
            result = maxiNumMortgageAmount;
        }
        return result;
    }

    protected double getFormatRate(double rate){

       return  Math.round( ((1+ rate)* 0.06)*10000.0 )/10000.0 ;
    }

    public abstract  String getMortgageInfo();

}
