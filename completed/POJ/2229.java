import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        long[] dp = new long[N+1];
        dp[0] = 1;
        for(int i = 1; i <= N; i <<= 1) {
            for(int j = i; j <= N; j++) {
                dp[j] = (dp[j]+dp[j-i])%1000000000;
            }
        }
        out.println(dp[N]);
        f.close();
        out.close();
    }
}
