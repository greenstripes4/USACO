/*
ID: strongh2
LANG: JAVA
PROG: milk2
TASK: milk2
 */


import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class milk2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] intervals = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            intervals[i][0] = Integer.parseInt(st.nextToken());
            intervals[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return 0;
                }
                return o1[0] > o2[0] ? 1:-1;
            }
        });
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        int LCT = currentEnd - currentStart;
        int LIT = 0;
        for(int j = 1; j < N; j++){
            int start = intervals[j][0];
            int end = intervals[j][1];
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
        f.close();
        out.close();
    }
}
