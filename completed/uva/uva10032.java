import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] w;
    private static int total;
    private static int[][] dp;
    private static int dfs(int idx, int cnt, int sum) {
        if(cnt > (n+1)/2) {
            return 45000;
        }
        if(idx == n) {
            if(Math.abs(n-2*cnt) > 1) {
                return 45000;
            }
            return Math.abs(total-2*sum);
        }
        if(dp[cnt][sum] >= 0) {
            return dp[cnt][sum];
        }
        int ans = Math.min(dfs(idx+1, cnt+1, sum+w[idx]), dfs(idx+1, cnt, sum));
        return dp[cnt][sum] = ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("beads.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = f.nextInt();
        while(T-- > 0) {
            n = f.nextInt();
            w = new int[n];
            total = 0;
            for(int i = 0; i < n; i++) {
                w[i] = f.nextInt();
                total += w[i];
            }
            dp = new int[n/2+2][total+1];
            for(int[] i: dp) {
                Arrays.fill(i, -1);
            }
            int ans = dfs(0, 0, 0);
            int g1 = (total-ans)/2;
            int g2 = g1+ans;
            out.println(g1 + " " + g2);
            if(T > 0) {
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
