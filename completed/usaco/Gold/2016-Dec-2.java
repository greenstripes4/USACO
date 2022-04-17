import java.io.*;
import java.util.*;

public class Main {
    private static int distance(int[] a, int[] b) {
        int dx = a[0]-b[0];
        int dy = a[1]-b[1];
        return dx*dx+dy*dy;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("checklist.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("checklist.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int H = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int[][][] cows = new int[2][][];
        cows[0] = new int[H+1][2];
        for(int i = 1; i <= H; i++) {
            st = new StringTokenizer(f.readLine());
            cows[0][i][0] = Integer.parseInt(st.nextToken());
            cows[0][i][1] = Integer.parseInt(st.nextToken());
        }
        cows[0][0] = cows[0][1];
        cows[1] = new int[G+1][2];
        for(int i = 1; i <= G; i++) {
            st = new StringTokenizer(f.readLine());
            cows[1][i][0] = Integer.parseInt(st.nextToken());
            cows[1][i][1] = Integer.parseInt(st.nextToken());
        }
        cows[1][0] = cows[1][1];
        long[][][] dp = new long[H+1][G+1][2];
        for(long[][] i: dp) {
            for(long[] j: i) {
                Arrays.fill(j, Integer.MAX_VALUE);
            }
        }
        dp[0][0][0] = 0;
        for(int i = 1; i <= H; i++) {
            for(int j = 0; j <= G; j++) {
                if(i > 0) {
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i-1][j][0]+distance(cows[0][i-1], cows[0][i]));
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i-1][j][1]+distance(cows[1][j], cows[0][i]));
                }
                if(j > 0) {
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j-1][1]+distance(cows[1][j-1], cows[1][j]));
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j-1][0]+distance(cows[0][i], cows[1][j]));
                }
            }
        }
        out.println(dp[H][G][0]);
        f.close();
        out.close();
    }
}
