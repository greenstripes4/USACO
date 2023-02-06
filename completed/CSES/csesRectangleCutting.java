import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] dp = new int[a+1][b+1];
        for(int i = 1; i <= a; i++) {
            for(int j = 1; j <= b; j++) {
                if(i == j) {
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[k][j]+dp[i-k][j]+1);
                }
                for(int k = 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[i][j-k]+1);
                }
            }
        }
        out.println(dp[a][b]);
        int ans = 0;
        while(a != b) {
            if(a > b) {
                a -= b;
            } else {
                b -= a;
            }
            ans++;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}