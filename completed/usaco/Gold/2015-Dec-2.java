import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("feast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        boolean[][] dp = new boolean[T+1][2];
        dp[0][0] = dp[0][1] = true;
        for(int i = 1; i <= T; i++) {
            dp[i][0] = (i-A >= 0 && dp[i-A][0]) || (i-B >= 0 && dp[i-B][0]);
        }
        for(int i = 0; i <= T; i++) {
            dp[i][1] = (i-A >= 0 && dp[i-A][1]) || (i-B >= 0 && dp[i-B][1]) || (2*i <= T && dp[2*i][0]) || (2*i < T && dp[2*i+1][0]);
        }
        for(int i = T; i >= 0; i--) {
            if(dp[i][0] || dp[i][1]) {
                out.println(i);
                break;
            }
        }
        f.close();
        out.close();
    }
}
