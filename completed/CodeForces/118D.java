import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int k1 = Integer.parseInt(st.nextToken());
        int k2 = Integer.parseInt(st.nextToken());
        long[][][] dp = new long[n1+1][n2+1][2];
        for(int i = 0; i <= k1 && i <= n1; i++) {
            dp[i][0][0] = 1;
        }
        for(int i = 0; i <= k2 && i <= n2; i++) {
            dp[0][i][1] = 1;
        }
        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                for(int l = 1; l <= k1 && i-l >= 0; l++) {
                    dp[i][j][0] = (dp[i][j][0]+dp[i-l][j][1])%100000000;
                }
                for(int l = 1; l <= k2 && j-l >= 0; l++) {
                    dp[i][j][1] = (dp[i][j][1]+dp[i][j-l][0])%100000000;
                }
            }
        }
        out.println((dp[n1][n2][0]+dp[n1][n2][1])%100000000);
        f.close();
        out.close();
    }
}
