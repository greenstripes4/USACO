import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long[][][] dp = new long[17][17][17];
        dp[1][1][1] = 1;
        for(int i = 2; i <= 13; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = 1; k <= j; k++) {
                    dp[i][j][k] = dp[i-1][j][k]*(i-2)+dp[i-1][j-1][k]+dp[i-1][j][k-1];
                }
            }
        }
        int T = f.nextInt();
        for(int i = 0; i < T; i++){
            int N = f.nextInt();
            int P = f.nextInt();
            int R = f.nextInt();
            out.println(dp[N][P][R]);
        }
        f.close();
        out.close();
    }
}
