import java.util.Stack;
import java.lang.StringBuilder;

public class DiophantineEquation {

    public static String solEquaStr(long n) {   
	
        Stack<Integer> x = new Stack<>();
        Stack<Integer> y = new Stack<>();
		
        long lim = (n+1)/2;
		
        for (int i = 0; i <= lim; i++) {
            for (int j = 0; j <= lim; j++) {
                if ( (i - 2*j)*(i + 2*j) == n ) { x.push(i); y.push(j); break; }
            }
        }
		
        int size = x.size();
		
        StringBuilder returnStr = new StringBuilder();
        returnStr.append('[');
		
        for (int i = 0; i < size; i++) {
            if (x.size() > 1) returnStr.append("[" + x.pop() + ", " + y.pop() + "], ");
            else returnStr.append("[" + x.pop() + ", " + y.pop() + ']');
        }
		
        returnStr.append(']');
        return returnStr.toString();
    }

}
