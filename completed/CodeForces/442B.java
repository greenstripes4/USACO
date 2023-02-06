import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        double[] arr = new double[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = 1-Double.parseDouble(st.nextToken());
        }
        double[][][] dp = new double[n+1][n+1][2];
        for(int i = 0; i <= n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = 1;
        }
        double max = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                double x = dp[i-1][j][0];
                double y = dp[i-1][j-1][0]*arr[i]+dp[i-1][j-1][1]*(1-arr[i]);
                if(x > y) {
                    dp[i][j][0] = x;
                    dp[i][j][1] = dp[i-1][j-1][1];
                } else {
                    dp[i][j][0] = y;
                    dp[i][j][1] = dp[i-1][j-1][1]*arr[i];
                }
                max = Math.max(max, dp[i][j][0]);
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
