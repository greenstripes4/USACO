import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] a = f.readLine().toCharArray();
        char[] b = f.readLine().toCharArray();
        int[][] dp = new int[a.length+1][b.length+1];
        for(int i = 1; i <= a.length; i++) {
            dp[i][0] = i;
        }
        for(int i = 1; i <= b.length; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= a.length; i++) {
            for(int j = 1; j <= b.length; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1]+(a[i-1] == b[j-1] ? 0 : 1), Math.min(dp[i][j-1]+1, dp[i-1][j]+1));
            }
        }
        out.println(dp[a.length][b.length]);
        f.close();
        out.close();
    }
}