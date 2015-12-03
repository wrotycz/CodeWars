public class DecodeTheMorseCode {

    public static String decodeBits(String bits) {
        StringBuilder Bits = new StringBuilder(bits);
        Bits = new StringBuilder(Bits.substring(Bits.indexOf("1"), Bits.lastIndexOf("1")+1));   // trim 0 from front and end
        
        //case with no zeros
        if(Bits.indexOf("0") == -1) return ".";
        
        int rate = 0, tempRate = 0;
        for (int i = 0; i < Bits.length(); i++) {
            if (Bits.charAt(i) == '1') tempRate += 1;
            else if (Bits.charAt(i) == '0') {
                if (tempRate != 0 && rate == 0) rate = tempRate;    // first portion of ones
                else if (tempRate != 0 && tempRate % 3 == 0) rate = tempRate > rate ? tempRate : rate ; // another portion of ones, if greater save                
                tempRate = 0;
            }
        }
        rate = (rate % 3 == 0) ? (rate/3) : rate;
        
        //magic checking block
        tempRate = 0;
        for (int i = 0; i < Bits.length(); i++) {
            if (Bits.charAt(i) == '0') tempRate += 1;
            else {
                if (tempRate == rate) break;
                else if (i == Bits.length() - 1 && tempRate < rate) rate *= 3;
                tempRate = 0;
            }
        }                 
        
        StringBuilder output = new StringBuilder();        
        int counterOne = 0, counterZero = 0;
        Bits.trimToSize();
        
        for (int i = 0; i < Bits.length(); i++) {
            if ( (i == Bits.length() - 1) ) { //ending if
                counterOne++;
                if (counterZero >= 7 * rate) { output.append("   "); counterZero = 0;} 
                else if (counterZero >= 3 * rate) { output.append(" "); counterZero = 0;} 
                if (counterOne >= 3 * rate) output.append('-');
                else if (counterOne >= rate) output.append('.');
            } 
            if (Bits.charAt(i) == '1') {
                counterOne++;
                if (counterZero == 0) continue;
                else if (counterZero == rate) { counterZero = 0; continue; }
                else if (counterZero >= 7 * rate) { output.append("   "); counterZero = 0; continue;} 
                else if (counterZero >= 3 * rate) { output.append(" "); counterZero = 0; continue;}               
            }
            if (Bits.charAt(i) == '0') {                
                if (counterZero == 0) {     // new dot or dash
                    if (counterOne >= 3 * rate) output.append('-');
                    else if (counterOne >= rate) output.append('.');
                    counterOne = 0;
                }                
                counterZero++;
            }                          
        }
        return output.toString();
    }
    
    public static String decode(String morseCode) {
        String[] strArr = morseCode.split(" ");
        StringBuilder output = new StringBuilder(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            if ( strArr[i].isEmpty() && strArr[i+1].isEmpty() ) { output.append(" "); i++; continue; }    // becouse split leaves one unwanted space
            //output.append(MorseCode.get(strArr[i]));    // MorseCode was in kata
            System.out.print(strArr[i]);
        }        
        if (output.charAt(0) == ' ') output.deleteCharAt(0);    // becouse of irritating space on front
        
        return output.toString();
    }
    
}
