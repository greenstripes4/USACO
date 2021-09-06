import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        long[][][] dp = new long[n+1][k+1][2];
        for(int i = 0; i <= k; i++) {
            dp[0][i][0] = 1;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                for(int l = 1; l <= Math.min(j, i); l++) {
                    dp[i][j][0] = (dp[i][j][0]+dp[i-l][j][0])%1000000007;
                    dp[i][j][1] = (dp[i][j][1]+dp[i-l][j][l >= d ? 0 : 1])%1000000007;
                }
            }
        }
        out.println(dp[n][k][1]);
        f.close();
        out.close();
    }
}