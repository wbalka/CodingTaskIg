import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static helpers.Helper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseAndAddTest {

    @Test
    @Description("WHEN we enter a number that is a palindrome THEN we get a positive response.")
    void testCheckNumberHasPalindrome() {
        //prepare
        String number="44344";

        // action
        boolean result = checkPalindrome(number,0);

        // verification
        assertEquals(true, result, "The number must be a palindrome.");
    }

    @Test
    @Description("WHEN we enter a number that is a palindrome THEN we get a positive response.")
    void testCheckNumberHasNotPalindrome() {
        //prepare
        String number="1234";

        // action
        boolean result = checkPalindrome(number,0);

        // verification
        assertEquals(false, result, "The number must not be a palindrome.");
    }

    @Test
    @Description("WHEN we enter various characters (no numbers) THEN we should get an empty array.")
    void testCheckInputVariousCharacters() {
        //prepare
        List<String > emptyList = new ArrayList<>();
        String value="./.,,,fghdfg@#, , , ,ewr._+!@_";

        // action
        List<String> result = getArrayNumbers(value);

        // verification
        assertEquals(emptyList, result, "The number must not be a palindrome.");
    }

    @Test
    @Description("WHEN we send a number to the shuffle method THEN we get a shuffled number.")
    void testCheckShuffleTheArray() {
        //prepare
        char[] currentNumber = String.valueOf(1234).toCharArray();
        long expectedNumber = 2341;

        // action
        long result = shuffleTheArray(currentNumber,0);

        // verification
        assertEquals(expectedNumber, result, "The number must be mixed.");
    }

}