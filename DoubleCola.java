public class DoubleCola {
    
    public int numberOfNames;
    
    public String WhoIsNext(String[] names, int n) {
        numberOfNames = names.length;
        int iteration = findIterationNumber(n);
        int remainingField = findRemainingSum(iteration-1);        
        
        int numberOfNextPerson = ((n - remainingField)-1) / ((int) Math.pow(2, iteration) );
        
        return names[numberOfNextPerson];
    }
    
    private int findIterationNumber(int number) {
        int sumOfIterations = 0;
        int iteration = 0;       
        while (number > sumOfIterations) {
            sumOfIterations += numberOfNames * Math.pow(2, iteration);
            iteration++;
        }
        
        return --iteration;
    }
    
    private int findRemainingSum(int iteration) {
        int sumOfIterations = 0;
        for (int i = 0; i <= iteration; i++) {
            sumOfIterations += numberOfNames * Math.pow(2, i);
        }           
        
        return sumOfIterations;
    }
}
