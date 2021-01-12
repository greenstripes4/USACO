import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] s = new int[n+1];
            for(int j = 1; j <= n; j++) {
                s[j] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[n+1];
            Arrays.fill(dp, 1);
            for(int j = 1; j <= n; j++) {
                for(int k = j+j; k <= n; k += j) {
                    if(s[j] < s[k]) {
                        dp[k] = Math.max(dp[k], dp[j]+1);
                    }
                }
            }
            int max = 0;
            for(int j = 1; j <= n; j++) {
                max = Math.max(max, dp[j]);
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}