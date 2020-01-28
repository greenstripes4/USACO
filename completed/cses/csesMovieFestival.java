/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("cecs.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int movies = Integer.parseInt(f.readLine());
        int[][] intervals = new int[movies][2];
        for(int i = 0; i < movies; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            intervals[i][0] = Integer.parseInt(st.nextToken());
            intervals[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return 0;
                }
                return o1[1] > o2[1] ? 1:-1;
            }
        });
        int count = 0;
        int currentEnd = -1;
        for(int[] i: intervals){
            if(i[0] >= currentEnd){
                count++;
                currentEnd = i[1];
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
