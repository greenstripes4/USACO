import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(f.readLine());
            int[] P = new int[N];
            int[] W = new int[N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                P[i] = Integer.parseInt(st.nextToken());
                W[i] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[N+1][31];
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= 30; k++) {
                    dp[j][k] = Math.max(dp[j-1][k],k >= W[j-1] ? dp[j-1][k-W[j-1]]+P[j-1] : 0);
                }
            }
            int G = Integer.parseInt(f.readLine());
            int maximalTotalValue = 0;
            for(int i = 0; i < G; i++) {
                int MW = Integer.parseInt(f.readLine());
                maximalTotalValue += dp[N][MW];
            }
            out.println(maximalTotalValue);
        }
        f.close();
        out.close();
    }
}
