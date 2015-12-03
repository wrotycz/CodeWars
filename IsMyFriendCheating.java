import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class RemovedNumbers {
    public static List<long[]> removNb(long n) {
        ArrayList<long[]> out = new ArrayList<>();
        
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum+=i;
        }
        
        for (int i = 1; i <= n; i++) {           
            for (int j = 1; j <= n; j++) {
                if (j == i) continue;
                if (i*j == (sum - i - j)) out.add(new long[] {i, j});
            }            
        }
        
        return out;
    }
}
