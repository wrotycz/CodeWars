import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {
	
    public static long sumUpToNumber = 0;
    
    public static List<long[]> removNb(long n) {
        List<long[]> outputList = new ArrayList<>();
        sumUpToNumber = sumUpToNumber(n);
        
        for (long i = (long)(0.6*n); i <= n; i++) {
            for (long j = (long)(0.6*n); j <= n; j++) {
                if (i*j == sumUpToNumberWhithoutTwoOfThem(sumUpToNumber, i, j)) {
                    long[] toAdd = new long[]{i, j};
                    outputList.add(toAdd);
                }
            }
        }
        
	return outputList;
    }
	
    public static long sumUpToNumber(long number) {
        long sum = 0;
        for (int i = 1; i <= number; i++)          
            sum += i;      
        return sum;
    }
    
    public static long sumUpToNumberWhithoutTwoOfThem(long sum, long first, long second) {
        return sum - first - second;
    }
}
