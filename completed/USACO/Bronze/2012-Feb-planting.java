/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<int[]> merge(ArrayList<int[]> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return 0;
                }
                return o1[0] < o2[0] ? -1 : 1;
            }
        });
        ArrayList<int[]> ans = new ArrayList<int[]>();
        int start = intervals.get(0)[0];
        int end = intervals.get(0)[1];
        for (int[] i : intervals) {
            if (i[0] >= start && i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                ans.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        ans.add(new  int[]{start,end});
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("planting.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
        int N = Integer.parseInt(f.readLine());
        int[][][] arr = new int[N][2][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            arr[i][0] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            arr[i][1] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        }
        int ans = 0;
        for(int i = -10000; i <= 10000; i++){
            ArrayList<int[]> intervals = new ArrayList<>();
            for(int[][] j: arr){
                if(i > j[0][0] && i <= j[1][0]){
                    intervals.add(new int[]{j[1][1],j[0][1]});
                }
            }
            intervals = merge(intervals);
            for(int[] j: intervals) {
                ans += j[1] - j[0];
            }
        }
        out.println(ans);
        out.close();
        f.close();
    }
}
