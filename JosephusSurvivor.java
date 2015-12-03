import java.util.ArrayList;

public class JosephusSurvivor {
    
    public static int josephusSurvivor(final int n, final int k) {
        ArrayList<Integer> arrayN = new ArrayList<>();
        // filling list
        for (int i = 1; i <= n; i++) {
            arrayN.add(i);
        }
        //elimintation
        int lastIndex = 0;
        for (int i = 0; i < n-1; i++) {            
            int indexToEliminate = ((lastIndex-1)+k)%arrayN.size();
            lastIndex = indexToEliminate; 
            arrayN.remove(indexToEliminate);
        }
        return arrayN.get(0).intValue();       
    } 
    
}
