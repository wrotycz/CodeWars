import java.util.Map;
import java.util.TreeMap;

public class User {
    int rank, progress;
    
    private static final Map<Integer, Integer> rankMap;   
    static {
        rankMap = new TreeMap<>();
        rankMap.put(-8,0);
        rankMap.put(-7,1);
        rankMap.put(-6,2);
        rankMap.put(-5,3);
        rankMap.put(-4,4);
        rankMap.put(-3,5);
        rankMap.put(-2,6);
        rankMap.put(-1,7);
        rankMap.put(1,8);
        rankMap.put(2,9);
        rankMap.put(3,10);
        rankMap.put(4,11);
        rankMap.put(5,12);
        rankMap.put(6,13);
        rankMap.put(7,14);
        rankMap.put(8,15);
        
    }
    
    User() {
        rank = -8;
        progress = 0;
    }
    
    public void incProgress(int kataRank) {
        int difference = getValueFromRank(kataRank) - getValueFromRank(this.rank);
        
        if (difference > 0) this.progress += 10*difference*difference;
        else if (difference == 0) this.progress += 3;
        else if (difference == -1) this.progress += 1;
        
        updateRankAndProgress();
    }
    
    private void updateRankAndProgress() {
        if (this.rank == 8) this.progress = 0;        
        if (this.progress >= 100) {
            int ranksToAdd = (int)(this.progress / 100);
            int overkillProgress = this.progress - ranksToAdd*100;
            int currentRankValue = getValueFromRank(this.rank);
            int newRankValue = currentRankValue + ranksToAdd;
            int newRank = getRankFromValue(newRankValue);            
            
            this.rank = newRank;
            if (newRank == 8) this.progress = 0;
            else this.progress = overkillProgress;            
        }
    }
    
    private int getValueFromRank(int rank) {
        return rankMap.get(rank);
    }
    
    private int getRankFromValue(int value) {
        if (value > 15) return 8;
        
        Integer[] valuesArray = new Integer[rankMap.size()];
        valuesArray = rankMap.keySet().toArray(valuesArray);
        
        return valuesArray[value];
    }
}
