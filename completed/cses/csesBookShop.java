import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] h = new int[n+1];
        for(int i = 1; i <= n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        int[] s = new int[n+1];
        for(int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n+1][x+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= x; j++) {
                dp[i][j] = dp[i-1][j];
                if(h[i] <= j && dp[i-1][j-h[i]]+s[i] > dp[i][j]) {
                    dp[i][j] = dp[i-1][j-h[i]]+s[i];
                }
            }
        }
        out.println(dp[n][x]);
        f.close();
        out.close();
    }
}