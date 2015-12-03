
public class AckermannFunction {

    public int Ackermann(int m, int n) {
        if (m < 0 || n < 0) return -1;
        if (m == 0) return n + 1;
        
        if (n == 0) return this.Ackermann(m-1, 1);
        
        return this.Ackermann(m-1, this.Ackermann(m, n-1));
    }
    
}
