import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long[][] dp = new long[2000001][2];
        for(int i = 3; i <= 2000000; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1])+2*Math.max(dp[i-2][0], dp[i-2][1]);
            dp[i][1] = 4+dp[i-1][0]+2*dp[i-2][0];
            dp[i][0] %= 1000000007;
            dp[i][1] %= 1000000007;
        }
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            out.println(Math.max(dp[n][0], dp[n][1]));
        }
        f.close();
        out.close();
    }
}
