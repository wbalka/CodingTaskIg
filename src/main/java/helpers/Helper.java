package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helper {
    private static final Logger logger = LoggerFactory.getLogger(Helper.class);

    public static String getNumbersCard(String cardNo){
        return cardNo.replaceAll("[^1-9]", "");
    }

    public static boolean checkCorrectNumberCardDigits(int numberCard){
        if(numberCard<13 || numberCard>19){
            return false;
        }else {
            return true;
        }
    }

    public static String enterNumberCreditCard(){
        Scanner inputVariable = new Scanner(System.in);

        System.out.println("---------");
        System.out.println("Please enter a valid credit card number. If you want to exit, type - exit.");
        System.out.print("Enter value: ");
        String value = inputVariable.nextLine();
        if(value.contains("exit")){
            // close Scanner
            inputVariable.close();
            System.exit(0);
            return null;
        }else{
            return value;
        }
    }

    public static void checkResults(boolean results){
        if (results){
            logger.info("Result: " + results);
        }
        else {
            logger.info("Result: " + results);
        }
    }

    public static boolean cardValidationCheck(String cardNumber)
    {
        cardNumber = getNumbersCard(cardNumber);
        int nDigits = cardNumber.length();
        if (checkCorrectNumberCardDigits(nDigits)==false){
            logger.error("The number of credit card digits must be between 13 and 19.");
            return false;
        };
        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits-1 ; i >= 0; i--)
        {
            int d =  Character.getNumericValue(cardNumber.charAt(i)) ;
            if (isSecond == true) {
                d = d * 2;
                if (d > 9) {
                    d = d - 9;
                }
                nSum +=d;
            }else {
                nSum += d;
            }

            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }

    public static List<String> enterValues(){
        Scanner inputVariable = new Scanner(System.in);

        System.out.println("---------");
        System.out.println("Please enter an integer separated by commas. For example - 4,294,967 or 290.");
        System.out.print("Enter value: ");
        String value = inputVariable.nextLine();

        return getArrayNumbers(value);

    }

    public static String getNumbersAndSeparator(String cardNo){
        return cardNo.replaceAll("[^,0-9 ]", "");
    }

    public static List<String> getArrayNumbers(String numbers){
        List<String > list = new ArrayList<>();
        numbers = getNumbersAndSeparator(numbers);
        String[] value = numbers.split(",");
        for ( String s : value) {
            try {
                Integer.valueOf(s);
                list.add(s);
            } catch(NumberFormatException e) {

            }
        }
        return list;
    }

    public static void getPalindrome(List<String> numbers) throws NumberFormatException{
        long prevNumb,currentNumb ;
        long nextNumb, sumNumb;
        int numberIterations;

        for (String number : numbers){
            logger.info("Start number - " + number);
            numberIterations = 0;
            prevNumb = Long.parseLong(number);
            currentNumb = prevNumb;

            if(checkPalindrome(String.valueOf(currentNumb),numberIterations)!=true){
                while (numberIterations<1000){
                    char[] characterArray = String.valueOf(prevNumb).toCharArray();

                    nextNumb = shuffleTheArray(characterArray, numberIterations);
                    if(nextNumb==0){
                        break;
                    }

                    sumNumb = prevNumb+nextNumb;
                    if(checkPalindrome(String.valueOf(sumNumb),numberIterations)){
                        break;
                    }
                    prevNumb = sumNumb;
                    numberIterations++;
                }
            }
        }
    }

    public static long shuffleTheArray(char[] characterArray,int numberIterations){
        int len= characterArray.length;
        long newNumber=0;
        do {
            for (int i = 0; i < len - 1; i++) {
                char temp = characterArray[i];
                characterArray[i] = characterArray[i + 1];
                characterArray[i + 1] = temp;
            }
        }
        while(characterArray[0]=='0');
        try {
            newNumber = Long.parseLong(String.valueOf(characterArray));
        } catch(NumberFormatException e) {
            logger.info("number of iterations - " + numberIterations);
            logger.error("The number is too big, i can't handle it - " + String.valueOf(characterArray));
            logger.info("Failed to find palindrome.\n");
            // System.exit(0);
        }
        return newNumber;
    }

    public static boolean checkPalindrome(String number, int numberIterations) {
        boolean result = number.equals(new StringBuilder().append(number).reverse().toString());
        if(result){

            logger.info("number of iterations - " + numberIterations);
            logger.info(number +" - It's palindrome.\n");

            return true;
        }else{
            return false;
        }
    }
}
