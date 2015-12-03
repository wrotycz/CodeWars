public class CalculateStringRotation {
    
    static int shiftedDiff(String first, String second) {               
        String testString = second + second;
        
        if (!isValid(testString, first, second)) return -1;
        return testString.indexOf(first);       
    }   
    
    static boolean isValid(String testString, String first, String second) {
        return testString.contains(first) && first.length() == second.length();
    }
}
