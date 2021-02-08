import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        double p = Double.parseDouble(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        double[][] dp = new double[t+1][n+1];
        dp[0][0] = 1;
        for(int i = 1; i <= t; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = j == n ? dp[i-1][j] : dp[i-1][j]*(1-p);
                if(j > 0) {
                    dp[i][j] += dp[i-1][j-1]*p;
                }
            }
        }
        double ans = 0;
        for(int i = 1; i <= n; i++) {
            ans += dp[t][i]*i;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
