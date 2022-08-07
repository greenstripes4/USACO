import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(f.readLine());
            arr[i] = Integer.parseInt(st.nextToken())-1;
        }
        int[][] dp = new int[n+1][m];
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = dp[i-1][j]+(arr[i] == j ? 0 : 1);
                if(j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
                }
            }
        }
        out.println(dp[n][m-1]);
        f.close();
        out.close();
    }
}