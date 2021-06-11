import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(n == 1) {
                out.println(k == 1 ? 1 : 2);
                continue;
            }
            int[][][] dp = new int[k+1][n][2];
            for(int i = 0; i < n; i++) {
                dp[1][i][0] = 1;
                dp[1][i][1] = 1;
            }
            for(int i = 2; i <= k; i++) {
                for(int j = n-1; j >= 0; j--) {
                    if(j == n-1) {
                        dp[i][j][0] = (1+dp[i-1][j-1][1])%1000000007;
                    } else if(j == 0) {
                        dp[i][j][0] = (dp[i][j+1][0]+1)%1000000007;
                    } else {
                        dp[i][j][0] = (dp[i][j+1][0]+dp[i-1][j-1][1])%1000000007;
                    }
                }
                for(int j = 0; j < n-1; j++) {
                    if(j == 0) {
                        dp[i][j][1] = (1+dp[i-1][j+1][0])%1000000007;
                    } else {
                        dp[i][j][1] = (dp[i][j-1][1]+dp[i-1][j+1][0])%1000000007;
                    }
                }
            }
            out.println(dp[k][0][0]);
        }
        f.close();
        out.close();
    }
}