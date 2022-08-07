import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] ans = new int[n+1];
        int[][] dp = new int[2][n+1];
        ans[0] = dp[0][0] = 1;
        int idx = 1;
        for(int i = 1; i < 632; i++) {
            for(int j = 0; j <= Math.min(n, k+i-2); j++) {
                dp[idx][j] = 0;
            }
            for(int j = k+i-1; j <= n; j++) {
                dp[idx][j] = (dp[idx][j-(k+i-1)]+dp[idx^1][j-(k+i-1)])%998244353;
                ans[j] = (ans[j]+dp[idx][j])%998244353;
            }
            idx ^= 1;
        }
        out.print(ans[1]);
        for(int i = 2; i <= n; i++) {
            out.print(" " + ans[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}