import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class CircularlySortedArray {
    
    public static boolean isCircleSorted(int[] a) {
        LinkedList<Integer> input = new LinkedList<>();
        for (Integer a1 : a) {
            input.add(a1);
        }
        
        LinkedList<Integer> stamp = new LinkedList<>(input);    // for comparison
        stamp.sort(Comparator.naturalOrder());
        
        for (int i = 0; i < a.length; i++) {
            if (input.equals(stamp)) return true;
            Collections.rotate(input, 1);
        }       
        
        return false;
    }
    
}
