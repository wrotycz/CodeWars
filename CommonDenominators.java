import java.util.ArrayList;
import java.util.Collections;

public class CommonDenominators {
    public int los;
    private String aleString = "foundMe!";
    
    public static String convertFrac(long[][] lst) {
        if (lst.length == 0) return null;
        
        long[] arrayOfSecondNumbers = new long[lst.length];
        long[] arrayOfOutputFirstNumbers = new long[lst.length];
        long leastCommonMultipleOfSecondNumbers = 1;
        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < lst.length; i++) {            
            System.out.print(String.format("{%d,%d}", lst[i][0], lst[i][1]));        
        }
        
        for (int i = 0; i < lst.length; i++) {
            arrayOfSecondNumbers[i] = lst[i][1];
        }
        
        if (!isFullOfOnes(arrayOfSecondNumbers)) {
            leastCommonMultipleOfSecondNumbers = leastCommonMultiple(arrayOfSecondNumbers);
        }
        
        
        for (int i = 0; i < lst.length; i++) {
            arrayOfOutputFirstNumbers[i] = (lst[i][0] * leastCommonMultipleOfSecondNumbers) / lst[i][1];
        }
        
        for (long OutputFirstNumber : arrayOfOutputFirstNumbers) {
            String pieceToAdd = String.format("(%d,%d)", OutputFirstNumber, leastCommonMultipleOfSecondNumbers);
            output.append(pieceToAdd);
        }
        
        return output.toString();
    }
    
    public static long leastCommonMultiple(long[] list) {
        ArrayList<Long> workingList = new ArrayList<>(list.length);
        Long min = (long) 0;
        int indexOfLeastValue;
        
        for (long number : list) {
            workingList.add(number);
        }
        
        while(Collections.max(workingList) != Collections.min(workingList)) {
            min = Collections.min(workingList);
            indexOfLeastValue = workingList.indexOf(min);
            workingList.set(indexOfLeastValue, min + list[indexOfLeastValue]);            
        }
        
        return workingList.get(0);
    }
    
    public static boolean isFullOfOnes(long[] list) {
        boolean containsOne = list[0] == 1;
        
        for (long element : list) {
            if (element != 1) return false;
        }
        
        return containsOne;
    }
    
}
