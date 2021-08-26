import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int M = Integer.parseInt(f.readLine());
        while(M-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[N+1];
            for(int i = 1; i <= N; i++) {
                a[i] = Math.abs(Integer.parseInt(st.nextToken()))%K;
            }
            boolean[][] dp = new boolean[N+1][K];
            dp[0][0] = true;
            for(int i = 1; i <= N; i++) {
                for(int j = 0; j < K; j++) {
                    dp[i][j] = dp[i-1][(j-a[i]+K)%K] || dp[i-1][(j+a[i])%K];
                }
            }
            out.println(dp[N][0] ? "Divisible" : "Not divisible");
        }
        f.close();
        out.close();
    }
}
