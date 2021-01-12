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
        st = new StringTokenizer(f.readLine());
        long[] p = new long[n+1];
        for(int i = 1; i <= n; i++) {
            p[i] = p[i-1]+Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[k+1][n+1];
        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1];
                if(j-m >= 0 && dp[i-1][j-m]+p[j]-p[j-m] > dp[i][j]) {
                    dp[i][j] = dp[i-1][j-m]+p[j]-p[j-m];
                }
            }
        }
        out.println(dp[k][n]);
        f.close();
        out.close();
    }
}