package lab3.exercise3;

import java.util.Arrays;

public interface MortgageConstants {

    String backName="CityTorontoBank";
    Double maxiNumMortgageAmount = 300000d;
    double shortTermPrimeRate =0.06;
    double mediumTermPrimeRate =0.05;
    double longTermPrimeRate =0.04;

    default double getBankPrimeTerm(int term){
        double result =0;
        if(term ==1){
            result = shortTermPrimeRate;
        }else if(term ==3){
            result = mediumTermPrimeRate;
        }else if(term ==5){
            result = longTermPrimeRate;
        }else{
            result = shortTermPrimeRate;
        }
        return result;
    }

}
