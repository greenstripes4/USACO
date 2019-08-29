/*
ID: strongh2
LANG: JAVA
PROG: moosick
TASK: moosick
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("moosick.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moosick.out")));
        int n = Integer.parseInt(f.readLine());
        int[] notes = new int[n];
        for(int i = 0; i < n; i++){
            notes[i] = Integer.parseInt(f.readLine());
        }
        int c = Integer.parseInt(f.readLine());
        int[] ruminant = new int[c];
        for(int j = 0; j < c; j++){
            ruminant[j] = Integer.parseInt(f.readLine());
        }
        int[][] chords = new int[n-c+1][c];
        for(int k = 0; k < n-c+1; k++){
            int[] temp = new int[c];
            for(int p = 0; p < c; p++){
                temp[p] = notes[p+k];
            }
            chords[k] = temp;
        }
        for(int l = 0; l < n-c+1; l++){
            Arrays.sort(chords[l]);
        }
        Arrays.sort(ruminant);
        int count = 0;
        ArrayList<Integer> index = new ArrayList<>();
        for(int m = 0; m < chords.length; m++){
            int look_for = ruminant[0] - chords[m][0];
            boolean is_ruminant = true;
            for(int o = 1; o < c; o++){
                if(!(ruminant[o]-chords[m][o] == look_for)){
                    is_ruminant = false;
                    break;
                }
            }
            if(is_ruminant){
                index.add(m+1);
                count++;
            }
        }
        out.println(count);
        for(int ind: index){
            out.println(ind);
        }
        out.close();
        f.close();
    }
}
