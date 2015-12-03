public class EANValidator {   
 
    public static boolean validate(final String eanCode) {
		
       int[] values = new int[12];
	   
       for(int i=0; i<12; i++) {
		   
			if ((i % 2) == 0) {
			values[i] = Character.getNumericValue(eanCode.charAt(i));
			continue;
			}
			
			else values[i] = ((Character.getNumericValue(eanCode.charAt(i))) * 3);
       }
       
       int sum = 0;
       for(int s : values)
         sum += s;
       
       int checkSum;
       if ((sum % 10) != 0) checkSum = (10 - (sum % 10)); 
       else checkSum = 0;
             
       int givenCheckSum = Character.getNumericValue(eanCode.charAt(12));      
       return givenCheckSum == checkSum;
    }
}