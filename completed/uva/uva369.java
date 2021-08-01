import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long[][] dp = new long[101][101];
        for(int i = 0; i <= 100; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
            }
        }
        while(true) {
            int N = f.nextInt();
            int M = f.nextInt();
            if(N == 0 && M == 0) {
                break;
            }
            out.println(N + " things taken " + M + " at a time is " + dp[N][M] + " exactly.");
        }
        f.close();
        out.close();
    }
}