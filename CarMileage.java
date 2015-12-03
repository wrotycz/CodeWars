import java.util.Arrays;

public class CarMileage {
    
    public static int isInteresting(int number, int[] awesomePhrases) {
        if (isInterestingBoolean(number, awesomePhrases)) return 2;
        if (isInterestingBoolean(number+1, awesomePhrases) 
            || isInterestingBoolean(number+2, awesomePhrases)) return 1;        
        
        return 0;
    }
    
    public static boolean isInterestingBoolean(int number, int[] awesomePhrases) {
        String numberAsString = String.valueOf(number);
        
        if (hasError(number)) return false;
        if (isFollowedByAllZeros(number)) return true;
        if (everyDigitIsTheSame(numberAsString)) return true;
        if (isSequentiallyDecrementing(numberAsString)) return true;
        if (isSequentiallyIncrementing(numberAsString)) return true;
        if (isPalindrome(numberAsString)) return true;
        return matchAwesomePhrases(number, awesomePhrases);
    }
    
    public static boolean isFollowedByAllZeros(int number) {
        return number % 10 == 0;
    }
    
    public static boolean everyDigitIsTheSame(String number) {
        for (int i = 0; i < number.length()-1; i++) {
            if (number.charAt(i) != number.charAt(i+1))
                return false;
        }
        
        return true;
    }
    
    public static boolean isSequentiallyIncrementing(String number) {        
        String incrementingNumbers = "1234567890";
        return incrementingNumbers.contains(number);
    }
    
    public static boolean isSequentiallyDecrementing(String number) {
        String decrementingNumbers = "9876543210";
        return decrementingNumbers.contains(number);
    }
    
    public static boolean isPalindrome(String number) {
        for (int i = 0; i <= number.length()/2; i++) {
            if (number.charAt(i) != number.charAt(number.length()-1-i))
                return false;
        }       
        return true;
    }
    
    public static boolean matchAwesomePhrases(int number, int[] awesomePhrases) {
        for (int awesomePhrase : awesomePhrases) {
            if (number == awesomePhrase) return true;
        }       
        return false;
    }
    
    public static boolean hasError(int number) {
        if (number <= 99) return true;
        return number >= 1000000000;
    }
}
