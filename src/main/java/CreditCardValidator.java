import java.util.Scanner;

import static helpers.Helper.*;

public class CreditCardValidator {
    public static void main (String args[]){
        String value;

        do{
            //entering the card number by the user from the command line
            value = enterNumberCreditCard();
            // credit card number validation
            boolean results = cardValidationCheck(value);
            checkResults(results);

        }while (!value.contains("exit"));

    }

}