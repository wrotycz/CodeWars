import java.util.WeakHashMap;

public class BasicArabicToRomanNumerals {
    
    public static String toRoman(int arabic) {
        String arabicAsString = String.valueOf(arabic);
        StringBuilder romanOutput = new StringBuilder();
        
        if (arabic <= 0) return "NaR";
        
        for (int i =  0; i < arabicAsString.length(); i++) {
            romanOutput.append(getSingleRoman((int) (Character.getNumericValue(arabicAsString.charAt(i)) * Math.pow(10, (arabicAsString.length() - 1) - i))));
        }
        return romanOutput.toString();
    }
    
    public static String getSingleRoman(int arabic) {
        final WeakHashMap<Integer, String> arabicKeyRomanValueMap = new WeakHashMap<>();
        arabicKeyRomanValueMap.put(1, "I");
        arabicKeyRomanValueMap.put(2, "II");
        arabicKeyRomanValueMap.put(3, "III");
        arabicKeyRomanValueMap.put(4, "IV");
        arabicKeyRomanValueMap.put(5, "V");
        arabicKeyRomanValueMap.put(6, "VI");
        arabicKeyRomanValueMap.put(7, "VII");
        arabicKeyRomanValueMap.put(8, "VIII");
        arabicKeyRomanValueMap.put(9, "IX");
        arabicKeyRomanValueMap.put(10, "X");
        arabicKeyRomanValueMap.put(20, "XX");
        arabicKeyRomanValueMap.put(30, "XXX");
        arabicKeyRomanValueMap.put(40, "XL");
        arabicKeyRomanValueMap.put(50, "L");
        arabicKeyRomanValueMap.put(60, "LX");
        arabicKeyRomanValueMap.put(70, "LXX");
        arabicKeyRomanValueMap.put(80, "LXXX");
        arabicKeyRomanValueMap.put(90, "XC");
        arabicKeyRomanValueMap.put(100, "C");
        arabicKeyRomanValueMap.put(200, "CC");
        arabicKeyRomanValueMap.put(300, "CCC");
        arabicKeyRomanValueMap.put(400, "CD");
        arabicKeyRomanValueMap.put(500, "D");
        arabicKeyRomanValueMap.put(600, "DC");
        arabicKeyRomanValueMap.put(700, "DCC");
        arabicKeyRomanValueMap.put(800, "DCCC");
        arabicKeyRomanValueMap.put(900, "CM");
        arabicKeyRomanValueMap.put(1000, "M");
        arabicKeyRomanValueMap.put(2000, "MM");
        arabicKeyRomanValueMap.put(3000, "MMM");
        arabicKeyRomanValueMap.put(4000, "MMMM");
        arabicKeyRomanValueMap.put(5000, "V");
        arabicKeyRomanValueMap.put(6000, "VM");
        arabicKeyRomanValueMap.put(7000, "VMM");
        arabicKeyRomanValueMap.put(8000, "VMMM");
        arabicKeyRomanValueMap.put(9000, "MX");
        
        return arabicKeyRomanValueMap.get(arabic);       
    }
    
}
