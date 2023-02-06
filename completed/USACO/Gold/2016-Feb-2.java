import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("cbarn2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn2.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] r = new int[n];
        for(int i = 0; i < n; i++) {
            r[i] = Integer.parseInt(f.readLine());
        }
        long ans = Long.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int[] res = new int[n];
            int idx = 0;
            for(int j = i; j < n; j++) {
                res[idx++] = r[j];
            }
            for(int j = 0; j < i; j++) {
                res[idx++] = r[j];
            }
            long[][] sum = new long[n+2][n+1];
            for(int j = 1; j <= n; j++) {
                long cur = 0;
                for(int l = j; l <= n; l++) {
                    cur += res[l-1]*(l-j+1);
                    sum[j][l] = cur;
                }
            }
            long[][] dp = new long[n+1][k+1];
            for(long[] j: dp) {
                Arrays.fill(j, Long.MAX_VALUE/2);
            }
            Arrays.fill(dp[0], 0);
            for(int j = 1; j <= n; j++) {
                for(int l = 1; l <= k; l++) {
                    for(int m = 1; m <= j; m++) {
                        dp[j][l] = Math.min(dp[j][l], dp[m-1][l-1]+sum[m+1][j]);
                    }
                }
            }
            ans = Math.min(ans, dp[n][k]);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}