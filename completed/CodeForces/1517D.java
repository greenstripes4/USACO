import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] horizontal = new int[n][m-1];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < m-1; j++) {
                horizontal[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] vertical = new int[n-1][m];
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < m; j++) {
                vertical[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] dp = new int[k+1][n][m];
        for(int i = 1; i <= k; i++) {
            for(int r = 0; r < n; r++) {
                for(int c = 0; c < m; c++) {
                    dp[i][r][c] = 100000000;
                    if(r > 0) {
                        dp[i][r][c] = Math.min(dp[i][r][c], dp[i-1][r-1][c]+vertical[r-1][c]);
                    }
                    if(r < n-1) {
                        dp[i][r][c] = Math.min(dp[i][r][c], dp[i-1][r+1][c]+vertical[r][c]);
                    }
                    if(c > 0) {
                        dp[i][r][c] = Math.min(dp[i][r][c], dp[i-1][r][c-1]+horizontal[r][c-1]);
                    }
                    if(c < m-1) {
                        dp[i][r][c] = Math.min(dp[i][r][c], dp[i-1][r][c+1]+horizontal[r][c]);
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            out.print(k%2 == 0 ? dp[k/2][i][0]*2 : -1);
            for(int j = 1; j < m; j++) {
                out.print(" " + (k%2 == 0 ? dp[k/2][i][j]*2 : -1));
            }
            out.println();
        }
        f.close();
        out.close();
    }
}