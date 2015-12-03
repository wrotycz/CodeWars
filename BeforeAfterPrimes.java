public class BeforeAfterPrimes {
    
    public static long[] primeBefAft(long num) {
        long[] outputArray = new long[2];
        
        for (long i = num-1; i > 1; i--) {
            if (isPrime(i)) {
                outputArray[0] = i;
                break;
            }
        }
        for (long i = num+1; ; i++) {
            if (isPrime(i)) {
                outputArray[1] = i;
                break;
            }
        }
        
        return outputArray;
    }
    
    public static boolean isPrime(long num) {
        for (long i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }       
        return num != 1;
    }
    
}
