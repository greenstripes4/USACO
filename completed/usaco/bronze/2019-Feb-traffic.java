import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("traffic.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
        int N = Integer.parseInt(f.readLine());
        String[] segments = new String[N];
        int[][] intervals = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            String s = st.nextToken();
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            segments[i] = s;
            intervals[i] = new int[]{low,high};
        }
        int[] before = {-999999999,999999999};
        for(int i = N-1; i >= 0; i--){
            if(segments[i].equals("none")){
                before[0] = Math.max(before[0],intervals[i][0]);
                before[1] = Math.min(before[1],intervals[i][1]);
            } else if(segments[i].equals("on")) {
                before[0] -= intervals[i][1];
                before[1] -= intervals[i][0];
                before[0] = Math.max(before[0],0);
            } else {
                before[0] += intervals[i][0];
                before[1] += intervals[i][1];
            }
        }
        int[] after = {-999999999,999999999};
        for(int i = 0; i < N; i++){
            if(segments[i].equals("none")){
                after[0] = Math.max(after[0],intervals[i][0]);
                after[1] = Math.min(after[1],intervals[i][1]);
            } else if(segments[i].equals("on")) {
                after[0] += intervals[i][0];
                after[1] += intervals[i][1];
            } else {
                after[0] -= intervals[i][1];
                after[1] -= intervals[i][0];
                after[0] = Math.max(after[0],0);
            }
        }
        out.println(before[0] + " " + before[1]);
        out.println(after[0] + " " + after[1]);
        f.close();
        out.close();
    }
}
