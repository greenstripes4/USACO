import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[] a = f.readLine().toCharArray();
        char[] b = f.readLine().toCharArray();
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+2;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])-1;
                }
                dp[i][j] = Math.max(dp[i][j], 0);
                max = Math.max(max, dp[i][j]);
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}