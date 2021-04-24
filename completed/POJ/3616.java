import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] intervals = new int[M][3];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            intervals[i][0] = Integer.parseInt(st.nextToken());
            intervals[i][1] = Integer.parseInt(st.nextToken());
            intervals[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[1]-t1[1];
            }
        });
        int[] dp = new int[M];
        int ans = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < i; j++) {
                if(intervals[i][0]-intervals[j][1] >= R) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += intervals[i][2];
            ans = Math.max(ans, dp[i]);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
