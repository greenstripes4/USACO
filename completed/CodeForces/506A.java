import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] a = new int[30001];
        for(int i = 0; i < n; i++) {
            a[Integer.parseInt(f.readLine())]++;
        }
        int[][] dp = new int[30001][501];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }
        dp[d][250] = a[d];
        int ans = a[d];
        for(int i = d+1; i <= 30000; i++) {
            for(int j = 0; j <= 500; j++) {
                int max = -1;
                int len = d+j-250;
                if(len > 0 && len <= i) {
                    max = dp[i-len][j];
                    if(j-1 >= 0) {
                        max = Math.max(max, dp[i-len][j-1]);
                    }
                    if(j+1 <= 500) {
                        max = Math.max(max, dp[i-len][j+1]);
                    }
                }
                if(max == -1) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = max+a[i];
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}