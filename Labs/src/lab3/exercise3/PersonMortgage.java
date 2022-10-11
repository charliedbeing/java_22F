package lab3.exercise3;

public class PersonMortgage extends Mortgage{




    public PersonMortgage(int termNumber){
        super();
        term =termNumber;

        interestRate = getFormatRate(0.01);

    }


    @Override
    public String getMortgageInfo()
        {
            return "You are our respected Personal customer\n" +
                    "Your Name is " + customerName + " , \nmortgage Number is " + mortgageNumber + " ,\nmortgage amount is "
                    + amountMortgage + " ,\ninterest rate is "+ interestRate +" ,\nmortgage term is "+ term;
    }


}
