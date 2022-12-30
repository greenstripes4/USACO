import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static long[][][] dp;
    private static int[] weight;
    private static void dfs(int u, int p) {
        dp[u][0][1] = 1;
        dp[u][1][0] = 1;
        dp[u][1][1] = u == 0 ? 0 : 1;
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs(v, u);
                if(dp[v][0][0] > dp[v][1][0] || dp[v][0][0] == dp[v][1][0] && dp[v][0][1] < dp[v][1][1]) {
                    dp[u][0][0] += dp[v][0][0];
                    dp[u][0][1] += dp[v][0][1];
                } else {
                    dp[u][0][0] += dp[v][1][0];
                    dp[u][0][1] += dp[v][1][1];
                }
                dp[u][1][0] += dp[v][0][0];
                dp[u][1][1] += dp[v][0][1]+1;
            }
        }
    }
    private static void dfs2(int u, int p, boolean good) {
        weight[u] = good ? adjacencyList.get(u).size() : 1;
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs2(v, u, !good && dp[v][0][0] <= dp[v][1][0] && (dp[v][0][0] != dp[v][1][0] || dp[v][0][1] >= dp[v][1][1]));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        if(n == 2) {
            out.println("2 2");
            out.println("1 1");
        } else {
            adjacencyList = new ArrayList<>(n);
            for(int i = 0; i < n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for(int i = 0; i < n-1; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken())-1;
                int v = Integer.parseInt(st.nextToken())-1;
                adjacencyList.get(u).add(v);
                adjacencyList.get(v).add(u);
            }
            dp = new long[n][2][2];
            dfs(0, -1);
            weight = new int[n];
            if(dp[0][0][0] > dp[0][1][0] || dp[0][0][0] == dp[0][1][0] && dp[0][0][1] < dp[0][1][1]) {
                out.println(dp[0][0][0] + " " + dp[0][0][1]);
                dfs2(0, -1, false);
            } else {
                out.println(dp[0][1][0] + " " + dp[0][1][1]);
                dfs2(0, -1, true);
            }
            out.print(weight[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + weight[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}