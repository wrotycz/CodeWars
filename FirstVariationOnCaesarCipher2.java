import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CaesarCipher {
    
    public static List<String>  movingShift(String s, int shift) {
	String cipheredString = cipher(s, shift);
        List<String> outputList = new ArrayList<>();
        int[] lengthsOfSplittedStrings = lengthsOfSplittedStrings(s.length());
        
        for (int i = 0, startPoint = 0; i < 5; i++) {
            String substringToAdd = cipheredString.substring(startPoint, startPoint+=lengthsOfSplittedStrings[i]);
            outputList.add(substringToAdd);
        }
        
        return outputList;
    }
	
    public static String demovingShift(List<String> s, int shift) {        
        String stringToDecypher;
        
        stringToDecypher = s.stream().collect(Collectors.joining());
        
	return decipher(stringToDecypher, shift);
    }
    
    public static int[] lengthsOfSplittedStrings(int stringLength) {
        int[] lengths = new int[5];
        int lengthOfFirstFour = (int) Math.ceil(stringLength / 5.0);
        int lengthOfLast = stringLength - lengthOfFirstFour*4;
        
        lengths = new int[] {lengthOfFirstFour, lengthOfFirstFour, 
                             lengthOfFirstFour, lengthOfFirstFour, 
                             lengthOfLast};
        
        return lengths;
    }
    
    public static String cipher(String string, int shift) {
        char[] characters = string.toCharArray();
        
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(characters[i]))
                characters[i] = offsetLetter(characters[i], shift+i);
        }
        String output = new String(characters);
        return output;
    }
    
    public static String decipher(String string, int shift) {
        char[] characters = string.toCharArray();
        int deshift = -shift;
        
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(characters[i]))
                characters[i] = offsetLetter(characters[i], deshift - i);
        }
        
        String output = new String(characters);
        return output;
    }
    
    public static char offsetLetter(char toOffset, int shift) {
        if (Character.isLowerCase(toOffset))
            return offsetNonCapital(toOffset, shift);
        else return offsetCapital(toOffset, shift);
    }
    
    public static char offsetNonCapital(char toOffset, int shift) {
        if (shift >= 0)
            toOffset = (char)(((int)toOffset + shift%26 - (int)'a') % 26 + (int)'a');
        else toOffset = (char)(((int)toOffset + shift%26 - (int)'a' + 26) % 26 + (int)'a');
        return toOffset;
    }
    
    public static char offsetCapital(char toOffset, int shift) {        
        if (shift >= 0)
            toOffset = (char)(((int)toOffset + shift%26 - (int)'A') % 26 + (int)'A');
        else toOffset = (char)(((int)toOffset + shift%26 - (int)'A' + 26) % 26 + (int)'A');
        return toOffset;
    }
}
