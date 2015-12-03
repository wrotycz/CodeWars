public class DeodorantEvaporator {

    public static int evaporator(double content, double evap_per_day, double threshold) {
		
        double accurateContent = content;
        int counter = 0;
		
        while (accurateContent > (threshold / 100) * content) {
            accurateContent *= (1 - evap_per_day/100);
            counter++;
        }
		
		return counter; 
    }
    
}
