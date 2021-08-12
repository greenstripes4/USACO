import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            char[] S = f.readLine().toCharArray();
            long[][] dp = new long[S.length][S.length];
            for(int i = S.length-1; i >= 0; i--) {
                dp[i][i] = 1;
                for(int j = i+1; j < S.length; j++) {
                    if(S[i] == S[j]) {
                        dp[i][j] = dp[i+1][j]+dp[i][j-1]+1;
                    } else {
                        dp[i][j] = dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                    }
                }
            }
            out.println(dp[0][S.length-1]);
        }
        f.close();
        out.close();
    }
}
