import java.util.ArrayList;
import java.util.Arrays;

public class DirectionsReduction {
    
    public static String[] dirReduc(String[] arr) {
        ArrayList<String> arList = new ArrayList<>();
        arList.addAll(Arrays.asList(arr));

        for (int i = 0; i < arList.size() - 1; i++) {            
            switch (arList.get(i)) {
                case "NORTH":
                    if (arList.get(i+1) == "SOUTH") { arList.remove(i); arList.remove(i); i = -1; }
                    break;
                case "SOUTH":
                    if (arList.get(i+1) == "NORTH") { arList.remove(i); arList.remove(i); i = -1; }
                    break;
                case "EAST":
                    if (arList.get(i+1) == "WEST") { arList.remove(i); arList.remove(i); i = -1; }
                    break;
                case "WEST":
                    if (arList.get(i+1) == "EAST") { arList.remove(i); arList.remove(i); i = -1; }
                    break;
            }
        }
        String[] out = new String[arList.size()];
        arList.toArray(out);
     
        return out; 
    }   
    
}
