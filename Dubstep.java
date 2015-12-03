import java.lang.StringBuilder;

public class Dubstep {

    public static String SongDecoder (String song) {
        String[] arrayOutput = song.split("WUB");       
        StringBuilder output = new StringBuilder();
        
        // determine last
        int lastIndex = 0;
        for (int i = 0; i < arrayOutput.length; i++) {
                if ( !(arrayOutput[i].isEmpty()) ) lastIndex = i;
            }

        for (int i = 0; i <= lastIndex; i++) {
            if ( !(arrayOutput[i].isEmpty()) && (i < lastIndex) ) { output.append(arrayOutput[i] +" "); continue; }
            if ( !(arrayOutput[i].isEmpty()) && (i == lastIndex) ) { output.append(arrayOutput[i]); break; }                        
        }
        return output.toString();
    }
    
}
