import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private static double maxProfit(int k, double[] prices) {
        int n = prices.length;
        if (n <= 0 || k <= 0) {
            return 0;
        }
        double[][][] dp = new double[n][k+1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = -1000000000;
                dp[i][j][1] = -1000000000;
            }
        }
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = dp[i-1][j][0];
                if(j > 0 && dp[i-1][j-1][1] + prices[i] > dp[i][j][0]) {
                    dp[i][j][0] = dp[i-1][j-1][1] + prices[i];
                }
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0]-prices[i]);
            }
        }
        double res = 0;
        for (int j = 0; j <= k; j++) {
            res = Math.max(res, dp[n-1][j][0]);
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        double P = f.nextDouble();
        double[] prices = new double[N];
        for(int i = 0; i < N; i++) {
            prices[i] = f.nextDouble();
        }
        int low = 1;
        int high = N/2;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(maxProfit(mid,prices) >= P) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        out.println(ans*2);
        f.close();
        out.close();
    }
}
