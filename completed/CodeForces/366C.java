import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n+1];
        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        int[] b = new int[n+1];
        for(int i = 1; i <= n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n+1][200000];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }
        dp[0][100000] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 200000; j++) {
                dp[i][j] = dp[i-1][j];
                int prev = j-(a[i]-k*b[i]);
                if(prev < 0 || prev >= 200000) {
                    continue;
                }
                if(dp[i-1][prev] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][prev]+a[i]);
                }
            }
        }
        out.println(dp[n][100000] > 0 ? dp[n][100000] : -1);
        f.close();
        out.close();
    }
}