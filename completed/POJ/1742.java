import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] A = new int[n];
            int[] C = new int[n];
            for(int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < n; i++) {
                C[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[m+1];
            Arrays.fill(dp, -1);
            for(int i = 0; i < n; i++) {
                dp[0] = C[i];
                for(int j = 1; j <= m; j++) {
                    if(dp[j] >= 0) {
                        dp[j] = C[i];
                    } else if(j < A[i] || dp[j-A[i]] <= 0) {
                        dp[j] = -1;
                    } else {
                        dp[j] = dp[j-A[i]]-1;
                    }
                }
            }
            int ans = -1;
            for(int i: dp) {
                if(i >= 0) {
                    ans++;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
