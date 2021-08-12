import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        while(true) {
            char[] a = f.readLine().toCharArray();
            if(a[0] == '#') {
                break;
            }
            char[] b = f.readLine().toCharArray();
            int[][] dp = new int[a.length+1][b.length+1];
            for(int i = 1; i <= a.length; i++) {
                for(int j = 1; j <= b.length; j++) {
                    if(a[i-1] == b[j-1]) {
                        dp[i][j] = dp[i-1][j-1]+1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            out.println("Case #" + t + ": you can visit at most " + dp[a.length][b.length] + " cities.");
            t++;
        }
        f.close();
        out.close();
    }
}
