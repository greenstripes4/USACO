import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] c = new int[n];
        for(int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n+1][n+1];
        for(int i = n-1; i >= 0; i--) {
            dp[i][i] = 1;
            for(int j = i+1; j < n; j++) {
                dp[i][j] = dp[i+1][j]+1;
                for(int k = i+1; k <= j; k++) {
                    if(c[i] == c[k]) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(1, dp[i+1][k-1])+dp[k+1][j]);
                    }
                }
            }
        }
        out.println(dp[0][n-1]);
        f.close();
        out.close();
    }
}