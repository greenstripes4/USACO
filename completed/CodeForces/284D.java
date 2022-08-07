import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] a;
    private static long[][] dp;
    private static void dfs(int x, int flag) {
        dp[x][flag] = -1;
        int next = x+(flag == 0 ? 1 : -1)*a[x];
        if(next < 0 || next >= n) {
            dp[x][flag] = a[x];
            return;
        }
        if(next == 0) {
            return;
        }
        if(dp[next][flag^1] == 0) {
            dfs(next, flag^1);
        }
        if(dp[next][flag^1] == -1) {
            return;
        }
        dp[x][flag] = a[x]+dp[next][flag^1];
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        a = new int[n];
        for(int i = 1; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        dp = new long[n][2];
        for(int i = 1; i < n; i++) {
            if(dp[i][0] == 0) {
                dfs(i, 0);
            }
            if(dp[i][1] == 0) {
                dfs(i, 1);
            }
        }
        for(int i = 1; i < n; i++) {
            if(dp[i][1] == -1) {
                out.println(-1);
            } else {
                out.println(i+dp[i][1]);
            }
        }
        f.close();
        out.close();
    }
}