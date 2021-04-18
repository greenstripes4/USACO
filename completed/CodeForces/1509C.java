import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] s = new int[n];
        for(int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(s);
        long[][] dp = new long[n][n];
        for(int i = n-1; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1])+s[j]-s[i];
            }
        }
        out.println(dp[0][n-1]);
        f.close();
        out.close();
    }
}