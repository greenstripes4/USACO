/*
ID: strongh2
LANG: JAVA
PROG: barn1
TASK: barn1
 */
import java.text.CollationElementIterator;
import java.util.*;
import java.io.*;

public class barn1 {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] cowOccupiedStalls = new int[c];
        for(int i = 0; i < c; i++){
            cowOccupiedStalls[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(cowOccupiedStalls);
        ArrayList<Integer> gaps = new ArrayList<>();
        for(int j = 1; j < c; j++){
            if(cowOccupiedStalls[j] - cowOccupiedStalls[j-1] > 1){
                gaps.add(cowOccupiedStalls[j] - cowOccupiedStalls[j-1]-1);
            }
        }
        Collections.sort(gaps);
        int stallsCovered = c;
        int boardsNeeded = gaps.size()+1;
        while (boardsNeeded > m){
            boardsNeeded--;
            stallsCovered += gaps.get(0);
            gaps.remove(0);
        }
        out.println(stallsCovered);
        out.close();
        f.close();
    }
}
