import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = f.nextInt();
        for(int p = 0; p < n; p++) {
            int m = f.nextInt();
            int[] coins = new int[m];
            int sum = 0;
            for(int i = 0; i < m; i++) {
                coins[i] = f.nextInt();
                sum += coins[i];
            }
            int[][] dp = new int[m+1][sum/2+1];
            for(int i = 1; i <= m; i++) {
                for(int j = 0; j <= sum/2; j++) {
                    if(coins[i-1] <= j) {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-coins[i-1]]+coins[i-1]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            out.println(sum-dp[m][sum/2]*2);
        }
        f.close();
        out.close();
    }
}
