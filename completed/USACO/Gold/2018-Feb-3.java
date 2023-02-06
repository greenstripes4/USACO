import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("taming.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[N+1];
        for(int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[][][] dp = new int[N+1][N+1][N+1];
        for(int[][] i: dp) {
            for(int[] j: i) {
                Arrays.fill(j, N+1);
            }
        }
        dp[0][0][0] = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= i; k++) {
                    dp[i][j][k] = (k == i ? dp[i-1][j-1][0] : dp[i-1][j][k])+(a[i] == i-k ? 0 : 1);
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i][j][k]);
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            out.println(dp[N][i][0]);
        }
        f.close();
        out.close();
    }
}
