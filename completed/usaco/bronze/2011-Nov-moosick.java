import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("moosick.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moosick.out")));
        int numNotes = Integer.parseInt(f.readLine());
        int[] notes = new int[numNotes];
        for(int i = 0; i < numNotes; i++){
            notes[i] = Integer.parseInt(f.readLine());
        }
        int chordNotes = Integer.parseInt(f.readLine());
        int[] ruminantChord = new int[chordNotes];
        for(int j = 0; j < chordNotes; j++){
            ruminantChord[j] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(ruminantChord);
        int[][] chords = new int[numNotes-chordNotes+1][chordNotes];
        for(int k = 0; k < numNotes-chordNotes+1; k++){
            int[] temp = new int[chordNotes];
            for(int l = 0; l < chordNotes; l++){
                temp[l] = notes[l+k];
            }
            Arrays.sort(temp);
            chords[k] = temp;
        }
        int count = 0;
        ArrayList<Integer> indexes = new ArrayList<>();
        for(int m = 0; m < numNotes-chordNotes+1; m++){
            int look_for = ruminantChord[0] - chords[m][0];
            boolean is_ruminant = true;
            for(int n = 1; n < chordNotes; n++){
                if(ruminantChord[n]-chords[m][n] != look_for){
                    is_ruminant = false;
                    break;
                }
            }
            if(is_ruminant){
                indexes.add(m+1);
                count++;
            }
        }
        out.println(count);
        for(int ind: indexes){
            out.println(ind);
        }
        out.close();
        f.close();
    }
}
