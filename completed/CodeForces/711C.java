import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] c = new int[n];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        int[][] p = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < m; j++) {
                p[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][][] dp = new long[n+1][k+1][m+1];
        for(long[][] i: dp) {
            for(long[] j: i) {
                Arrays.fill(j, 100000000001L);
            }
        }
        for(int i = 0; i <= m; i++) {
            dp[0][0][i] = 0;
        }
        for(int t = 1; t <= n; t++) {
            for(int b1 = 1; b1 <= k; b1++) {
                if(c[t-1] == 0) {
                    for(int c1 = 1; c1 <= m; c1++) {
                        for(int c2 = 1; c2 <= m; c2++) {
                            int b2 = t == 1 && b1 == 1 ? 0 : c1 == c2 ? b1 : b1-1;
                            dp[t][b1][c1] = Math.min(dp[t][b1][c1], dp[t-1][b2][c2]+p[t-1][c1-1]);
                        }
                    }
                } else {
                    for(int c2 = 1; c2 <= m; c2++) {
                        int b2 = t == 1 && b1 == 1 ? 0 : c[t-1] == c2 ? b1 : b1-1;
                        dp[t][b1][c[t-1]] = Math.min(dp[t][b1][c[t-1]], dp[t-1][b2][c2]);
                    }
                }
            }
        }
        long min = 100000000001L;
        for(int i = 1; i <= m; i++) {
            min = Math.min(min, dp[n][k][i]);
        }
        out.println(min > 100000000000L ? -1 : min);
        f.close();
        out.close();
    }
}
