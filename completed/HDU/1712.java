import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) {
                break;
            }
            int[][] A = new int[n+1][m+1];
            for(int i = 1; i <= n; i++) {
                st = new StringTokenizer(f.readLine());
                for(int j = 1; j <= m; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            long[][] dp = new long[m+1][n+1];
            long ans = 0;
            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    for(int k = 0; k <= i; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-k][j-1]+A[j][k]);
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}