public class MultiTapKeypadTextEntry {
    
    public static int presses(String phrase) {
        char[] array = phrase.toUpperCase().toCharArray();
        int counter = 0;
        for (char ch : array) {
            if ( (int)ch >= 65 && (int)ch <= 79 ) counter += ((((int)ch)-65)%3)+1;        // 3 chars
            else if ( (int)ch >= 84 && (int)ch <= 86 ) counter += ((((int)ch)-84)%3)+1;   // TUV            
            else if ( (int)ch >= 80 && (int)ch <= 83 ) counter += ((((int)ch)-80)%4)+1;   // PQRS            
            else if ( (int)ch >= 87 && (int)ch <= 90 ) counter += ((((int)ch)-87)%4)+1;   // WXYZ            
            else if ( (int)ch == 32 || (int)ch == 49 || (int)ch == 35 || (int)ch == 42) counter += 1; // space, one, #, *
            else if ( (int)ch == 48 ) counter += 2;
            else if (Character.isDigit(ch)) {
                if ( ((int)ch >= 50 && (int)ch <= 54) || (int)ch == 56 ) counter += 4;
                else counter += 5;
            }           
        }
        return counter;
    }
    
}
