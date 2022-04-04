import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static helpers.Helper.*;
import static org.junit.jupiter.api.Assertions.*;

public class CreditCardValidatorTest {

    @Test
    @Description("WHEN we enter a number of digits less than 13 THEN we expect a message about the required range of digits.")
    void testCheckMinNumberCardDigits() {
        //prepare
        int numberCardDigits=12;

        // action
        boolean result = checkCorrectNumberCardDigits(numberCardDigits);

        // verification
        assertEquals(false, result, "The number of digits of the card number must be greater.");
    }

    @Test
    @Description("WHEN we enter a number of digits more than 19 THEN we expect a message about the required range of digits.")
    void testCheckMaxNumberCardDigits() {
        //prepare
        int numberCardDigits=20;

        // action
        boolean result = checkCorrectNumberCardDigits(numberCardDigits);

        // verification
        assertEquals(false, result, "The number of digits of the card number must be less.");
    }

    @Test
    @Description("WHEN we enter the correct number of credit card digits in the range from 13 to 19 THEN we get the value of true.")
    void testCheckCorrectNumberCardDigits() {
        //prepare
        int numberCardDigits=16;

        // action
        boolean result = checkCorrectNumberCardDigits(numberCardDigits);

        // verification
        assertEquals(true, result, "The number of digits of the card number must be in the range from 13 to 19.");
    }

    @Test
    @Description("WHEN we enter a valid credit card number THEN validation is successful.")
    void testValidationCorrectCardNumber() {
        //prepare
        String numberCard="4276271131119147";

        // action
        boolean result = cardValidationCheck(numberCard);

        // verification
        assertEquals(true, result, "Card validation must be successful.");
    }

    @Test
    @Description("WHEN we enter an invalid credit card number THEN validation failed.")
    void testValidationIncorrectCardNumber() {
        //prepare
        String numberCard="4276270030119142";

        // action
        boolean result = cardValidationCheck(numberCard);

        // verification
        assertEquals(false, result, "Card validation must fail.");
    }

    @Test
    @Description("WHEN we enter a valid credit card number with spaces THEN card validation is successful.")
    void testValidationCorrectCardNumberWithSpaces() {
        //prepare
        String numberCard="4276 2700 3011 9141";

        // action
        boolean result = cardValidationCheck(numberCard);

        // verification
        assertEquals(true, result, "Card validation must be successful.");
    }

    @Test
    @Description("WHEN we enter the correct card number with different characters THEN we get only the correct card number without different characters.")
    void testValidationCorrectCardNumberWithDifferentSymbols() {
        //prepare
        String correctCreditCard = "4276271131119141";
        String numberCard="42we76№;271e131er11 !dre9141eere";

        // action
        String result = getNumbersCard(numberCard);

        // verification
        assertEquals(correctCreditCard, result, "The card number must be valid and contain only numbers.");
    }
}