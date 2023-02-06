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
        st = new StringTokenizer(f.readLine());
        int[] a = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[][][] dp = new int[N+1][M+1][2];
        for(int[][] i: dp) {
            for(int[] j: i) {
                Arrays.fill(j, 3005);
            }
        }
        dp[0][0][0] = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= M; j++) {
                dp[i][j][1] = Math.min(dp[i-1][j][1], dp[i-1][j][0]+1);
                if(a[i-1] <= j) {
                    dp[i][j][0] = Math.min(dp[i-1][j-a[i-1]][0], dp[i-1][j-a[i-1]][1]);
                }
            }
        }
        for(int i = 1; i <= M; i++) {
            int ans = Math.min(dp[N][i][0], dp[N][i][1]);
            out.println(ans == 3005 ? -1 : ans);
        }
        f.close();
        out.close();
    }
}
