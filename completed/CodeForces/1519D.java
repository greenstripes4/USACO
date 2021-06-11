import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = f.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = f.nextInt();
        }
        long max = 0;
        for(int i = 0; i < n; i++) {
            b[i] = f.nextInt();
            max += a[i]*b[i];
        }
        long[][] dp = new long[n][n];
        for(int i = n-1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = max;
            }
            for(int j = i+1; j < n; j++) {
                dp[i][j] = dp[i+1][j-1]-a[i]*b[i]-a[j]*b[j]+a[i]*b[j]+a[j]*b[i];
            }
        }
        for(long[] i: dp) {
            for(long j: i) {
                max = Math.max(max, j);
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
