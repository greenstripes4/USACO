import java.io.*;
import java.util.*;

public class Main {
    private static long[][] a;
    private static String[][][] dp;
    private static String[] solve(int i, int j) {
        if(i == j) {
            String[] res = {"0", "A" + (i+1)};
            dp[i][j] = res;
            return res;
        }
        long min = Long.MAX_VALUE;
        String first = "";
        String second = "";
        for(int k = i; k < j; k++) {
            String[] temp1 = dp[i][k] == null ? solve(i, k) : dp[i][k];
            String[] temp2 = dp[k+1][j] == null ? solve(k+1, j) : dp[k+1][j];
            long cost = Long.parseLong(temp1[0])+Long.parseLong(temp2[0])+a[i][0]*a[k][1]*a[j][1];
            if(cost < min) {
                min = cost;
                first = temp1[1];
                second = temp2[1];
            }
        }
        String[] res = {Long.toString(min), "(" + first + ") x (" + second + ")"};
        dp[i][j] = res;
        return res;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        while(true) {
            int N = Integer.parseInt(f.readLine());
            if(N == 0) {
                break;
            }
            a = new long[N][2];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                a[i][0] = Integer.parseInt(st.nextToken());
                a[i][1] = Integer.parseInt(st.nextToken());
            }
            dp = new String[N][N][];
            out.println("Case " + t++ + ": " + solve(0, N-1)[1]);
        }
        f.close();
        out.close();
    }
}
