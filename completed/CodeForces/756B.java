import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] t = new int[n+1];
        for(int i = 1; i <= n; i++) {
            t[i] = Integer.parseInt(f.readLine());
        }
        long[] dp = new long[n+1];
        int last1 = 1;
        int last90 = 1;
        int last1440 = 1;
        for(int i = 1; i <= n; i++) {
            while(t[i]-t[last1] >= 1) {
                last1++;
            }
            while(t[i]-t[last90] >= 90) {
                last90++;
            }
            while(t[i]-t[last1440] >= 1440) {
                last1440++;
            }
            dp[i] = Math.min(dp[last1-1]+20, Math.min(dp[last90-1]+50, dp[last1440-1]+120));
        }
        for(int i = 1; i <= n; i++) {
            out.println(dp[i]-dp[i-1]);
        }
        f.close();
        out.close();
    }
}
