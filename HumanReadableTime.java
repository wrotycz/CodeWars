public class HumanReadableTime {

    public static String makeReadable(int seconds) {
        int H, M, S, tempSec;
        tempSec = seconds;
        H = tempSec/3600;       
        tempSec -= (H * 3600);
        M = tempSec/60;
        tempSec -= (M * 60);
        S = tempSec;
        
        StringBuilder out = new StringBuilder();
        if (H > 9) out.append(H + ":");
        else if (H <= 9) out.append("0" + H + ":");
        if (M > 9) out.append(M + ":");
        else if (M <= 9) out.append("0" + M + ":");
        if (S > 9) out.append(S);
        else if (S <= 9) out.append("0" + S);
        
        return out.toString();
    }
    
}
