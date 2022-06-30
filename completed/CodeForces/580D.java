import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[][] adjacencyMatrix = new int[n][n];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            adjacencyMatrix[y][x] = c;
        }
        long[][] dp = new long[1 << n][n];
        long ans = 0;
        for(int i = 0; i < 1 << n; i++) {
            for(int j = 0; j < n; j++) {
                if((i&(1 << j)) > 0) {
                    int l = i^(1 << j);
                    if(l == 0) {
                        dp[i][j] = a[j];
                    } else {
                        for(int o = 0; o < n; o++) {
                            if((l&(1 << o)) > 0) {
                                dp[i][j] = Math.max(dp[i][j], dp[l][o]+a[j]+adjacencyMatrix[j][o]);
                            }
                        }
                    }
                    if(Integer.bitCount(i) == m) {
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}