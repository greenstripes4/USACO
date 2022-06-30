import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        double[] p = new double[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long L = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());
            long low = 1;
            long total = 0;
            while(low <= R) {
                total += Math.max(0, Math.min(low, Math.min(R-L+1, Math.min(2*low-L, R-low+1))));
                low *= 10;
            }
            p[i] = total/(double) (R-L+1);
        }
        int K = Integer.parseInt(f.readLine());
        K = (K*N+99)/100;
        double[][] dp = new double[N+1][N+1];
        dp[0][0] = 1;
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = dp[i-1][j]*(1-p[i-1]);
                if(j > 0) {
                    dp[i][j] += dp[i-1][j-1]*p[i-1];
                }
            }
        }
        double ans = 0;
        for(int i = K; i <= N; i++) {
            ans += dp[N][i];
        }
        out.println(ans);
        f.close();
        out.close();
    }
}