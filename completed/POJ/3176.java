import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[][] arr = new int[N][];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            arr[i] = new int[i+1];
            for(int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][];
        dp[0] = new int[1];
        dp[0][0] = arr[0][0];
        for(int i = 1; i < N; i++) {
            dp[i] = new int[i+1];
            dp[i][0] = dp[i-1][0]+arr[i][0];
            for(int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+arr[i][j];
            }
            dp[i][i] = dp[i-1][i-1]+arr[i][i];
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[N-1][i]);
        }
        out.println(max);
        f.close();
        out.close();
    }
}
