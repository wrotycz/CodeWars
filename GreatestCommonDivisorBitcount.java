public class GreatestCommonDivisorBitcount {
    
    public static int gcdBinary(int x, int y) {
        int gcd = findGreatestCommonDivisor(x, y);
        int bitCount = Integer.bitCount(gcd);
        
        return bitCount;
    }
    
    public static int findGreatestCommonDivisor(int x, int y) {       
        int innerX = Math.abs(x), innerY = Math.abs(y);
        
        if (x == 0 || y == 0) return x == 0 ? innerY : innerX;
        
        for (int i = innerX < innerY ? innerX : innerY; i > 0; i--) {
            if (innerX % i == 0 && innerY % i == 0) return i;
        }
        
        return 0;
    }   
}
