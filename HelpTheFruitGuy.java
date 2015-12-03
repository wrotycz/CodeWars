import java.util.Arrays;
import java.util.function.Function;

public class HelpTheFruitGuy {
    
    public static String[] removeRotten(String[] fruitBasket) { 
        if (Arrays.equals(fruitBasket, new String[]{}) || 
            Arrays.equals(fruitBasket, null)) return new String[]{};

        Function<String, String> worker = n -> {
            if (n.startsWith("rotten")) {
                return n.substring(6).toLowerCase();
            }
            return n;
        };     
               
        return Arrays.stream(fruitBasket)
                     .map(worker)
                     .toArray(String[]::new);
    }
    
}
