import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n+1][3];
        for(int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], 1000000007);
        }
        for(int i = 1; i <= n; i++) {
            int status = a[i-1];
            dp[i][0] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2]))+1;
            if(status == 1 || status == 3) {
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]);
            }
            if(status == 2 || status == 3) {
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]);
            }
        }
        out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
        f.close();
        out.close();
    }
}
