import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n+1][n+1];
        int time = 0;
        for(int i = 1; i <= n; i++) {
            time += a[i-1];
            dp[i][0] = dp[i-1][0]+(time%h < l || time%h > r ? 0 : 1);
            for(int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1])+((time-j)%h < l || (time-j)%h > r ? 0 : 1);
            }
        }
        int max = 0;
        for(int i = 0; i <= n; i++) {
            max = Math.max(max, dp[n][i]);
        }
        out.println(max);
        f.close();
        out.close();
    }
}
