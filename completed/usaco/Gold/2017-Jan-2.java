import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] a = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            char c = f.readLine().charAt(0);
            if(c == 'H') {
                a[i][0]++;
            } else if(c == 'P') {
                a[i][1]++;
            } else {
                a[i][2]++;
            }
        }
        int[][][] dp = new int[N+1][K+1][3];
        for(int i = 1; i <= N; i++) {
            dp[i][0][0] = dp[i-1][0][0]+a[i][0];
            dp[i][0][1] = dp[i-1][0][1]+a[i][1];
            dp[i][0][2] = dp[i-1][0][2]+a[i][2];
            for(int j = 1; j <= K; j++) {
                int max = Math.max(dp[i-1][j-1][0], Math.max(dp[i-1][j-1][1], dp[i-1][j-1][2]));
                dp[i][j][0] = Math.max(max, dp[i-1][j][0])+a[i][0];
                dp[i][j][1] = Math.max(max, dp[i-1][j][1])+a[i][1];
                dp[i][j][2] = Math.max(max, dp[i-1][j][2])+a[i][2];
            }
        }
        out.println(Math.max(dp[N][K][0], Math.max(dp[N][K][1], dp[N][K][2])));
        f.close();
        out.close();
    }
}
