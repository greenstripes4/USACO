import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 1000000007;
    private static int add(long a, long b) { return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD); }
    private static int helper(int N, int[] H) {
        int[][] dp = new int[N][1001];
        for(int i = 0; i <= H[0]; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i <= 1000; i++) {
            dp[0][i] = add(dp[0][i], dp[0][i-1]);
        }
        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= H[i]; j++) {
                dp[i][j] = dp[i-1][H[i]-j];
            }
            for(int j = 1; j <= 1000; j++) {
                dp[i][j] = add(dp[i][j], dp[i][j-1]);
            }
        }
        return dp[N-1][0];
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] H = new int[N];
        int min = 1000;
        for(int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, H[i]);
        }
        if(N%2 == 0) {
            out.println(helper(N, H));
        } else {
            int ans = 0;
            for(int i = 0; i <= min; i++) {
                int[] arr = new int[N];
                for(int j = 0; j < N; j++) {
                    arr[j] = H[j]-i;
                }
                ans = add(ans, helper(N, arr));
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
