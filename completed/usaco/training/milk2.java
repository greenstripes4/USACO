import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/*
ID: strongh2
LANG: JAVA
PROG: milk2
TASK: milk2
 */

public class milk2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] times = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return 0;
                } else if(o1[0] > o2[0]){
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        int currentStart = times[0][0];
        int currentEnd = times[0][1];
        int LCT = currentEnd - currentStart;
        int LIT = 0;
        for(int j = 1; j < N; j++){
            int start = times[j][0];
            int end = times[j][1];
            if(start > currentEnd){
                if(currentEnd - currentStart > LCT){
                    LCT = currentEnd - currentStart;
                }
                if(start - currentEnd > LIT){
                    LIT = start - currentEnd;
                }
                currentStart = start;
                currentEnd = end;
            } else if(end >= currentEnd) {
                currentEnd = end;
                if(currentEnd - currentStart > LCT) {
                    LCT = currentEnd - currentStart;
                }
            }
        }
        out.println(LCT + " " + LIT);
        out.close();
        f.close();
    }
}
