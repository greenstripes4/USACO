import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) {
                break;
            }
            st = new StringTokenizer(f.readLine());
            int[] A = new int[n+1];
            for(int i = 1; i <= n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            int[] C = new int[n+1];
            for(int i = 1; i <= n; i++) {
                C[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[m+1];
            Arrays.fill(dp, 1000000);
            dp[0] = 0;
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j <= m; j++) {
                    if(dp[j] < 1000000) {
                        dp[j] = 0;
                    } else if(A[i] <= j && dp[j-A[i]] < C[i]) {
                        dp[j] = dp[j-A[i]]+1;
                    }
                }
            }
            int ans = 0;
            for(int i = 1; i <= m; i++) {
                if(dp[i] < 1000000) {
                    ans++;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}