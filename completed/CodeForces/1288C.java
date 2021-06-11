import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] dp1 = new long[m+1][n];
        Arrays.fill(dp1[1], 1);
        for(int i = 2; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k <= j; k++) {
                    dp1[i][j] += dp1[i-1][k];
                }
                dp1[i][j] %= 1000000007;
            }
        }
        long[][] dp2 = new long[m+1][n];
        Arrays.fill(dp2[1], 1);
        for(int i = 2; i <= m; i++) {
            for(int j = n-1; j >= 0; j--) {
                for(int k = j; k < n; k++) {
                    dp2[i][j] += dp2[i-1][k];
                }
                dp2[i][j] %= 1000000007;
            }
        }
        long ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                ans += dp1[m][i]*dp2[m][j];
                ans %= 1000000007;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}