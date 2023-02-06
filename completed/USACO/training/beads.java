/*
ID: strongh2
LANG: JAVA
PROG: beads
TASK: beads
 */


import java.util.*;
import java.io.*;

public class beads {
    public static int getLargestNumBeads(String necklace){
        char[] beads = necklace.toCharArray();
        int numBeads = 2;
        char currentStart = beads[0];
        char currentEnd = beads[beads.length-1];
        boolean start = true;
        boolean end = true;
        /*
        for(int i = 1; i < beads.length; i++){
            if(start) {
                if (beads[i] == currentStart || beads[i] == 'w' || currentStart == 'w') {
                    if(currentStart == 'w' && beads[i]  != 'w'){
                        currentStart = beads[i];
                    }
                    beads[i] = currentStart;
                    numBeads++;
                } else {
                    start = false;
                }
            }
            if(end) {
                if (beads[beads.length - i - 1] == currentEnd || beads[beads.length - i - 1] == 'w') {
                    if(currentEnd == 'w' && beads[beads.length - i - 1]  != 'w'){
                        currentEnd = beads[beads.length - i - 1];
                    }
                    beads[beads.length - i - 1] = currentEnd;
                    numBeads++;
                } else {
                    end = false;
                }
            }
            if(!start && !end){
                break;
            }
        }
         */
        for(int i = 1; i < beads.length; i++) {
            if (beads[i] == currentStart || beads[i] == 'w' || currentStart == 'w') {
                if (currentStart == 'w' && beads[i] != 'w') {
                    currentStart = beads[i];
                }
                beads[i] = currentStart;
                numBeads++;
            } else {
                break;
            }
        }
        for(int j = beads.length-1; j >= 0; j--){
            if (beads[j] == currentEnd || beads[j] == 'w') {
                if(currentEnd == 'w' && beads[j]  != 'w'){
                    currentEnd = beads[j];
                }
                beads[j] = currentEnd;
                numBeads++;
            } else {
                break;
            }
        }
        return Math.min(numBeads, beads.length);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int necklaceLength = Integer.parseInt(f.readLine());
        String necklace = f.readLine();
        int max = getLargestNumBeads(necklace);
        for(int i = 0; i < necklaceLength; i++){
            String temp = necklace.substring(i) + necklace.substring(0,i);
            int curMax = getLargestNumBeads(temp);
            if(curMax > max){
                max = curMax;
            }
        }
        out.println(max);
        out.close();
        f.close();
    }
}
