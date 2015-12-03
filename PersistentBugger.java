import java.util.ArrayList;

public class PersistentBugger {

    public static int persistence(long n) {
        Long nextNumberToCheck = n;
        int counter = 0;
        
        while(nextNumberToCheck.toString().length() != 1) {
            nextNumberToCheck = multiplyDigitsFromLong(nextNumberToCheck);
            counter++;
        }
        
		return counter;
    }
    
    public static long multiplyDigitsFromLong(long number) {
        Long numberObject = number;
        long multiplication = 1;
        
        for (char characterDigit : numberObject.toString().toCharArray()) {
            multiplication *= Long.parseLong(String.valueOf(characterDigit));
        }
                      
        return multiplication;
    }
    
}
