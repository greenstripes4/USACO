import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] r = new int[R+1];
        for(int i = 1; i <= R; i++) {
            r[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(r);
        st = new StringTokenizer(f.readLine());
        int[] g = new int[G+1];
        for(int i = 1; i <= G; i++) {
            g[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(g);
        st = new StringTokenizer(f.readLine());
        int[] b = new int[B+1];
        for(int i = 1; i <= B; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b);
        int[][][] dp = new int[R+1][G+1][B+1];
        int max = 0;
        for(int i = 0; i <= R; i++) {
            for(int j = 0; j <= G; j++) {
                for(int k = 0; k <= B; k++) {
                    if(i > 0 && j > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-1][k]+r[i]*g[j]);
                    }
                    if(i > 0 && k > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k-1]+r[i]*b[k]);
                    }
                    if(j > 0 && k > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][k-1]+g[j]*b[k]);
                    }
                    max = Math.max(max, dp[i][j][k]);
                }
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}