import java.io.*;
import java.util.*;

public class Main {
    private static long[][] dp;
    private static void dfs(int n, int h) {
        if(n < h) {
            dp[n][h] = 0;
            return;
        }
        if(n < 2) {
            dp[n][h] = 1;
            return;
        }
        dp[n][h] = 0;
        int temp = Math.max(0, h-1);
        for(int i = 1; i <= n; i++) {
            int left = i-1;
            int right = n-i;
            if(dp[left][0] == -1) {
                dfs(left, 0);
            }
            if(dp[left][temp] == -1) {
                dfs(left, temp);
            }
            if(dp[right][0] == -1) {
                dfs(right, 0);
            }
            if(dp[right][temp] == -1) {
                dfs(right, temp);
            }
            dp[n][h] += dp[left][0]*dp[right][temp]+dp[left][temp]*dp[right][0]-dp[left][temp]*dp[right][temp];
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        dp = new long[n+1][h+1];
        for(long[] i: dp) {
            Arrays.fill(i, -1);
        }
        dfs(n, h);
        out.println(dp[n][h]);
        f.close();
        out.close();
    }
}