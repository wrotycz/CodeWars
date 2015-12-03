import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class BestTravel {

    public static List<String> storage = new ArrayList<>();   
    
    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        int[] arrayOfSums;
        int[] givenList = new int[ls.size()];
        for (int i = 0; i < givenList.length; i++) {
            givenList[i] = ls.get(i);
        }
              
        combinations(givenList, k, 0, new int[k]);
        arrayOfSums = new int[storage.size()];
        
        for (int i = 0; i < storage.size(); i++) {
            arrayOfSums[i] = getSumOfNumbers(storage.get(i));
        }
        
        storage.clear();
        
        OptionalInt max = Arrays.stream(arrayOfSums)
                                .filter(i -> i <= t)
                                .max();
        
        if (max.isPresent()) return max.getAsInt();
        return null;
    }
    
    static void combinations(int[] arr, int len, int startPosition, int[] result){       
        if (len == 0){
            storage.add(Arrays.toString(result));
            return;
        }       
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations(arr, len-1, i+1, result);           
        }
    } 
    
    static int getSumOfNumbers(String string) {
        int sum;
        String tempString = string.substring(1, string.length()-1);
        String[] numbers = tempString.split(", ");
        sum = Arrays.stream(numbers)
                    .mapToInt(i -> Integer.parseInt(i))
                    .sum();
        return sum;
    }
}
