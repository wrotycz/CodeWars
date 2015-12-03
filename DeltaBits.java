public class DeltaBits {

    public static int convertBits(int a, int b) {
        int bitwiseExclusive = a ^ b;
        return Integer.bitCount(bitwiseExclusive);
    }
    
}
