import java.io.*;
import java.util.*;

public class Main {
    private static int distance(int ax, int ay, int bx, int by) {
        int dx = bx-ax;
        int dy = by-ay;
        return dx*dx+dy*dy;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("radio.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("radio.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int fx = Integer.parseInt(st.nextToken());
        int fy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int bx = Integer.parseInt(st.nextToken());
        int by = Integer.parseInt(st.nextToken());
        char[] fp = f.readLine().toCharArray();
        int[][] arr1 = new int[N+1][2];
        for(int i = 0; i < N; i++) {
            arr1[i+1][0] = arr1[i][0];
            arr1[i+1][1] = arr1[i][1];
            if(fp[i] == 'N') {
                arr1[i+1][1]++;
            } else if(fp[i] == 'S') {
                arr1[i+1][1]--;
            } else if(fp[i] == 'W') {
                arr1[i+1][0]--;
            } else {
                arr1[i+1][0]++;
            }
        }
        char[] bp = f.readLine().toCharArray();
        int[][] arr2 = new int[M+1][2];
        for(int i = 0; i < M; i++) {
            arr2[i+1][0] = arr2[i][0];
            arr2[i+1][1] = arr2[i][1];
            if(bp[i] == 'N') {
                arr2[i+1][1]++;
            } else if(bp[i] == 'S') {
                arr2[i+1][1]--;
            } else if(bp[i] == 'W') {
                arr2[i+1][0]--;
            } else {
                arr2[i+1][0]++;
            }
        }
        long[][] dp = new long[N+1][M+1];
        for(long[] i: dp) {
            Arrays.fill(i, Long.MAX_VALUE);
        }
        dp[0][0] = 0;
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= M; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                int dist = distance(fx+arr1[i][0], fy+arr1[i][1], bx+arr2[j][0], by+arr2[j][1]);
                if(i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+dist);
                }
                if(j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+dist);
                }
                if(i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+dist);
                }
            }
        }
        out.println(dp[N][M]);
        f.close();
        out.close();
    }
}