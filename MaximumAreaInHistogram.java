import java.util.Arrays;

public class MaximumAreaInHistogram {
    
    public static long calc(long[] rects) {
        long[] storageArray = new long[rects.length];
        
        for (int i = 0; i < rects.length; i++) {
            storageArray[i] = checkNeighborhoodForMaxArea(i, rects);
        }
        return Arrays.stream(storageArray)
                     .max()
                     .getAsLong();
    }
    
    public static long checkNeighborhoodForMaxArea(int index, long[] rects) {
        long sum = rects[index];
        
        for (int i = index + 1; i < rects.length; i++) {
            if (rects[i] < rects[index]) break;
            sum += rects[index];
        }
        if (index == 0) return sum;
        
        for (int i = index - 1; i >= 0; i--) {
            if (rects[i] < rects[index]) break;
            sum += rects[index];
        }
        
        return sum;
    }
}
