import java.util.ArrayList;
import java.util.LinkedList;

public class DiophantineEquation2 {

    public static String solEquaStr(long n) {
        LinkedList<ArrayList<Long>> listOfPairs = new LinkedList<>();
        
        
        for (long x = (long) (n/1.6); x >= 0; x--) {
            for (long y = x/2; y >= 0; y--) {
                if (checkIfDiophaniteEquationAndAddToList(x, y, n, listOfPairs)) break;
            }
        }
        
        return listOfPairs.toString();
    }
    
    public static boolean checkIfDiophaniteEquationAndAddToList(long x, long y, long A, LinkedList<ArrayList<Long>> listOfPairs) {
        Long diophantineEquation = x*x - 4*(y*y);
        boolean isDiophanite = diophantineEquation == A;
        
        if (isDiophanite) {
            ArrayList<Long> xAndY = new ArrayList<>(2);
            xAndY.add(x);
            xAndY.add(y);
            listOfPairs.add(xAndY);
        }
        
        return isDiophanite;
    }
    
}
