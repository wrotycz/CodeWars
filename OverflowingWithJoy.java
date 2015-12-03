import java.math.BigInteger;

public class OverflowingWithJoy {
    
    public static long multiply(long a, long b) {
        return Math.multiplyExact(a, b);
    }
    
    public static int multiply(int a, int b) {
        if(!canStoreMultiplicationInInteger(a, b))
            throw new ArithmeticException();
        return a * b;
    }        
    
    public static boolean canStoreMultiplicationInInteger(int a, int b) {
        BigInteger aBig = new BigInteger(String.valueOf(a));
        BigInteger bBig = new BigInteger(String.valueOf(b));
        
        BigInteger integerMaxValue = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        BigInteger integerMinValue = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        BigInteger multiplication = aBig.multiply(bBig);
        
        
        if (multiplication.signum() >= 0)
            return multiplication.compareTo(integerMaxValue) <= 0;
        return multiplication.compareTo(integerMinValue) >= 0;
    }    
      
}
