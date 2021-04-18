import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n-1];
        for(int i = 0; i < n-1; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        int[] b = new int[n-1];
        for(int i = 0; i < n-1; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n][2];
        dp[0][1] = c;
        for(int i = 1; i < n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < n-1; i++) {
            dp[i+1][0] = Math.min(dp[i][0], dp[i][1])+a[i];
            dp[i+1][1] = Math.min(dp[i][0]+c, dp[i][1])+b[i];
        }
        out.print(0);
        for(int i = 1; i < n; i++) {
            out.print(" " + Math.min(dp[i][0], dp[i][1]));
        }
        out.println();
        f.close();
        out.close();
    }
}