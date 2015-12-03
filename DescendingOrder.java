import java.util.Arrays;

public class DescendingOrder {
    
    public static int sortDesc(final int num) {
		
        String first = Integer.toString(num);
        char[] sec = first.toCharArray();
        Arrays.sort(sec);
        StringBuilder third = new StringBuilder();
		
        for (char s : sec) {
            third.append(s);
        }       
		
        return Integer.parseInt(third.reverse().toString());
    }
    
}
