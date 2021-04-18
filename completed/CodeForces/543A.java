import java.io.*;
import java.util.*;

public class Main {
    private static int MOD;
    private static int add(long a, long b) {
        return (int) ((a%MOD+b%MOD)%MOD);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        MOD = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[][][] dp = new int[2][m+1][b+1];
        dp[0][0][0] = 1;
        for(int i = 1; i <= n; i++) {
            int index = i&1;
            for(int j = 0; j <= m; j++) {
                for(int k = 0; k <= b; k++) {
                    dp[index][j][k] = dp[index^1][j][k];
                    if(j > 0 && k-a[i-1] >= 0) {
                        dp[index][j][k] = add(dp[index][j][k], dp[index][j-1][k-a[i-1]]);
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i <= b; i++) {
            ans = add(ans, dp[n&1][m][i]);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}