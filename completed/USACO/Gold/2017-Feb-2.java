import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("nocross.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocross.out")));
        int N = Integer.parseInt(f.readLine());
        int[] a = new int[N+1];
        for(int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(f.readLine());
        }
        int[] b = new int[N+1];
        for(int i = 1; i <= N; i++) {
            b[i] = Integer.parseInt(f.readLine());
        }
        int[][] dp = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                if(Math.abs(a[i]-b[j]) <= 4) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
                }
            }
        }
        out.println(dp[N][N]);
        f.close();
        out.close();
    }
}