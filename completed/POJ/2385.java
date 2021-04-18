import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[T];
        for(int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(f.readLine());
        }
        int[][] dp = new int[T][W+1];
        for(int i = 0; i < T; i++) {
            for(int j = 0; j <= W; j++) {
                if(i == 0) {
                    dp[0][j] = j%2 == arr[0]-1 ? 1 : 0;
                } else {
                    dp[i][j] = dp[i-1][j];
                    if(j > 0 && dp[i-1][j-1] > dp[i][j]) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    dp[i][j] += j%2 == arr[i]-1 ? 1 : 0;
                }
            }
        }
        int max = 0;
        for(int i = 0; i <= W; i++) {
            max = Math.max(max, dp[T-1][i]);
        }
        out.println(max);
        f.close();
        out.close();
    }
}
