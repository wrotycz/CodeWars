import java.util.Stack;
import java.lang.StringBuilder;

public class Dec2Fact {
    public static long factorial(int n) {
        int fact = 1;
		
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
		
        return fact;
    }
    public static String dec2FactString(long nb) {
        Stack stck = new Stack();
        long div = nb;
        for (int i=1; div > 0; i++) {
            stck.push(div%i);
            div = (long) (div / i);
        }
               
        char[] charArray = new char[stck.size()];
        long check;
        int size = stck.size();
		
        for (int i = 0; i < size; i++) {
            check = (long) stck.pop();
            if ( check >= 0 && check < 10 ) charArray[i] = (char) (check + 48);
            else charArray[i] = (char) (check + 55);
        }
       
        StringBuilder returnString = new StringBuilder();        
        for (int i=0; i<charArray.length; i++) {
            returnString.append(charArray[i]);
        }               
        
		return returnString.toString();
    }
    public static long factString2Dec(String str) {   
        
        int[] numArray = new int[str.length()];
		
        for (int i = 0; i < numArray.length; i++) {
			if ( ( (str.charAt(i) - 48) >= 0) && (str.charAt(i) - 48) < 10  ) numArray[i] = str.charAt(i) - 48;
			else numArray[i] = str.charAt(i) - 55;
        }
        
        long dec = 0;
        for (int i = 0, j = numArray.length-1; j > 0; i++, j--) {
            dec += numArray[i] * factorial(j);
        }  
		
		return dec;
    }    
}
