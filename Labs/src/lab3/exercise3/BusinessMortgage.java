package lab3.exercise3;

public class BusinessMortgage extends Mortgage{


    public void setCustomerName(String n){
        customerName = n;
    }

    public void setAmountMortgage(double amtMortgage){
        amountMortgage = checkAmountMortgage(amtMortgage);
    }

    public BusinessMortgage(int termNumber){
        super();
        term =termNumber;
        interestRate = getFormatRate(0.02);

    }

    @Override
    public String getMortgageInfo()
    {
        return "You are our respected Business Customer\n" +
                "Your Name is " + customerName + " , \nmortgage Number is " + mortgageNumber + " ,\nmortgage amount is "
                + amountMortgage + " ,\ninterest rate is "+ interestRate +" ,\nmortgage term is "+ term;
    }
}
