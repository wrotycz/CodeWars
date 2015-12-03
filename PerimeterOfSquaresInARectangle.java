import java.math.BigInteger;
import java.io.*;
import java.math.BigDecimal;

public class PerimeterOfSquaresInARectangle {
    
    public static BigDecimal getFibonacciFromGoldenRatio(int num) {
        double fi, squareRootOfFive;
        BigDecimal outputValue = new BigDecimal("0");
        
        squareRootOfFive = Math.sqrt(5.0);
        fi = (1 + squareRootOfFive) / 2;
        
        try {
            outputValue = power(fi, num).subtract(power((1 - fi), num))
                                        .divide(BigDecimal.valueOf(squareRootOfFive), BigDecimal.ROUND_UP);
        } catch(ArithmeticException e) {
            System.err.println(e.getMessage());
        }
        
        return outputValue;
    }
    
    public static BigDecimal power(double number, int power) {
        BigDecimal outputValue = new BigDecimal(number);
        
        for (int i = 1; i < power; i++) {
            outputValue = outputValue.multiply(BigDecimal.valueOf(number));
        }
        
        return outputValue;
    }
    
    public static BigInteger perimeter(BigInteger n) {
        return new BigDecimal("0").add(getFibonacciFromGoldenRatio(n.intValue()+3))
                                  .subtract(BigDecimal.valueOf(1))
                                  .multiply(BigDecimal.valueOf(4))
                                  .toBigInteger();
    }
    
}
