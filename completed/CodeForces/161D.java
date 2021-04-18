import java.io.*;
import java.util.*;

public class Main {
    private static int k;
    private static ArrayList<Integer>[] adjacencyList;
    private static long[][] dp;
    private static long ans;
    private static void dfs(int root, int parent) {
        dp[root][0] = 1;
        for(int i: adjacencyList[root]) {
            if(i != parent) {
                dfs(i, root);
                for(int j = 1; j <= k; j++) {
                    dp[root][j] += dp[i][j-1];
                }
            }
        }
        long temp = 0;
        for(int i: adjacencyList[root]) {
            if(i != parent) {
                for(int j = 1; j < k; j++) {
                    temp += dp[i][j-1]*(dp[root][k-j]-dp[i][k-j-1]);
                }
            }
        }
        ans += temp/2+dp[root][k];
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
        dp = new long[n+1][k+1];
        dfs(1, 0);
        out.println(ans);
        f.close();
        out.close();
    }
}