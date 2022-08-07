import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int M = -Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(f.readLine());
            int[][] arr = new int[N+1][2];
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(f.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            long[][] dp = new long[M+1][N+1];
            for(int i = 1; i <= M; i++) {
                Arrays.fill(dp[i], Long.MAX_VALUE/2);
            }
            for(int i = 1; i <= M; i++) {
                for(int j = 1; j <= N; j++) {
                    dp[i][j] = dp[i][j-1];
                    if(i-arr[j][1] >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-arr[j][1]][j]+arr[j][0]);
                    }
                }
            }
            long min = Long.MAX_VALUE/2;
            for(int i = 0; i <= N; i++) {
                min = Math.min(min, dp[M][i]);
            }
            out.println(min == Long.MAX_VALUE/2 ? "This is impossible." : "The minimum amount of money in the piggy-bank is " + min + ".");
        }
        f.close();
        out.close();
    }
}