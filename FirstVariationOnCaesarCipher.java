import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstVariationOnCaesarCipher {
    
    public static List<String>  movingShift(String s, int shift) {
	ArrayList<String> list = new ArrayList<>();
        
        int divideCounter;
        divideCounter = (int) (s.length()/5);
        System.out.println("s length: " + s.length() + "  divideCounter: " + divideCounter);
        
        char[] array = new char[s.length()];
        array = s.toCharArray();
        
        int counter = 0;
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < array.length; i++) {            
            if (counter > divideCounter && array[i] == ' ') {
                list.add(builder.toString());
                builder = new StringBuilder();
                counter = 0;
            }
            else { builder.append(array[i]); counter++; }
            
        }
        array = s.toCharArray();       
        
        return list;
    }
    
}
