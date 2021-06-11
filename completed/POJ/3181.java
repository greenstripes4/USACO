import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        int K = f.nextInt();
        long[][] dp = new long[N+1][K+1];
        for(int i = 1; i <= K; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                dp[i][j] = dp[i][j-1];
                if(i >= j) {
                    dp[i][j] += dp[i-j][j];
                }
            }
        }
        out.println(dp[N][K]);
        f.close();
        out.close();
    }
}
