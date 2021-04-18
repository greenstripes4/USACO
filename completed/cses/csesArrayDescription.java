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
        st = new StringTokenizer(f.readLine());
        int[] x = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n][m+1];
        if(x[0] > 0) {
            dp[0][x[0]] = 1;
        } else {
            for(int i = 1; i <= m; i++) {
                dp[0][i] = 1;
            }
        }
        for(int i = 1; i < n; i++) {
            if(x[i] > 0) {
                dp[i][x[i]] = (dp[i-1][x[i]-1]+dp[i-1][x[i]])%1000000007;
                if(x[i]+1 <= m) {
                    dp[i][x[i]] = (dp[i][x[i]]+dp[i-1][x[i]+1])%1000000007;
                }
            } else {
                for(int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j]%1000000007;
                    if(j+1 <= m) {
                        dp[i][j] = (dp[i][j]+dp[i-1][j+1])%1000000007;
                    }
                }
            }
        }
        if(x[n-1] > 0) {
            out.println(dp[n-1][x[n-1]]);
        } else {
            long count = 0;
            for(int i = 1; i <= m; i++) {
                count = (count+dp[n-1][i])%1000000007;
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}