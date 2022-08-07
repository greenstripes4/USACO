import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        double[][][][] dp = new double[r+1][s+1][p+1][3];
        for(int i = 0; i <= r; i++) {
            for(int j = 0; j <= s; j++) {
                for(int k = 0; k <= p; k++) {
                    if(i == 0 && j == 0 && k == 0) {
                        continue;
                    }
                    if(i == 0 && j == 0) {
                        dp[i][j][k][0] = 0;
                        dp[i][j][k][1] = 0;
                        dp[i][j][k][2] = 1;
                    } else if(i == 0 && k == 0) {
                        dp[i][j][k][0] = 0;
                        dp[i][j][k][1] = 1;
                        dp[i][j][k][2] = 0;
                    } else if(j == 0 && k == 0) {
                        dp[i][j][k][0] = 1;
                        dp[i][j][k][1] = 0;
                        dp[i][j][k][2] = 0;
                    } else {
                        double x = i*j;
                        double y = i*k;
                        double z = j*k;
                        double combinations = x+y+z;
                        if(x > 0) {
                            dp[i][j][k][0] += x/combinations*dp[i][j-1][k][0];
                            dp[i][j][k][1] += x/combinations*dp[i][j-1][k][1];
                            dp[i][j][k][2] += x/combinations*dp[i][j-1][k][2];
                        }
                        if(y > 0) {
                            dp[i][j][k][0] += y/combinations*dp[i-1][j][k][0];
                            dp[i][j][k][1] += y/combinations*dp[i-1][j][k][1];
                            dp[i][j][k][2] += y/combinations*dp[i-1][j][k][2];
                        }
                        if(z > 0) {
                            dp[i][j][k][0] += z/combinations*dp[i][j][k-1][0];
                            dp[i][j][k][1] += z/combinations*dp[i][j][k-1][1];
                            dp[i][j][k][2] += z/combinations*dp[i][j][k-1][2];
                        }
                    }
                }
            }
        }
        out.println(dp[r][s][p][0] + " " + dp[r][s][p][1] + " " + dp[r][s][p][2]);
        f.close();
        out.close();
    }
}