import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(h == 0 && w == 0) {
                break;
            }
            long[][] dp = new long[2][1 << w];
            dp[0][(1 << w)-1] = 1;
            int l = 1;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    for(int k = 0; k < 1 << w; k++) {
                        dp[l][k] = 0;
                        if((k&(1 << j)) == 0) {
                            dp[l][k] += dp[l^1][k|(1 << j)];
                        } else {
                            dp[l][k] += dp[l^1][k^(1 << j)];
                            if(j > 0 && (k&(1 << (j-1))) > 0) {
                                dp[l][k] += dp[l^1][k^(1 << (j-1))];
                            }
                        }
                    }
                    l ^= 1;
                }
            }
            out.println(dp[l^1][(1 << w)-1]);
        }
        f.close();
        out.close();
    }
}