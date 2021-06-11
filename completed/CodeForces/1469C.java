import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] h = new int[n];
            for(int i = 0; i < n; i++) {
                h[i] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[n][2];
            dp[0][0] = h[0];
            dp[0][1] = h[0];
            boolean flag = false;
            for(int i = 1; i < n; i++) {
                dp[i][0] = Math.max(h[i], dp[i-1][0]-k+1);
                dp[i][1] = Math.min(h[i]+k-1, dp[i-1][1]+k-1);
                if(dp[i][0] > dp[i][1]) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                out.println("NO");
                continue;
            }
            out.println(h[n-1] >= dp[n-1][0] && h[n-1] <= dp[n-1][1] ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}