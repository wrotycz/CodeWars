public class CompoundArray {

    public static int[] compoundArray(int[] a, int[] b){
        int maxLength = a.length >= b.length ? a.length : b.length;
        int index = 0;
        int[] output = new int[a.length + b.length];
        
        for (int i = 0; i < maxLength; i++) {
            if (a.length > i && b.length > i) {               
                output[index++] = a[i];
                output[index++] = b[i];
            }
            else if (a.length > i) output[index++] = a[i];
            else if (b.length > i) output[index++] = b[i];
        }
        
        return output;
    }
    
}
