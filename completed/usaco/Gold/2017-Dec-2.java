import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] color;
    private static long[][] dp;
    private static final int MOD = 1000000007;
    private static void dfs(int u, int p) {
        if(color[u] == 0) {
            dp[u][0] = dp[u][1] = dp[u][2] = 1;
        } else {
            dp[u][color[u]-1] = 1;
        }
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs(v, u);
                dp[u][0] = (dp[u][0]*(dp[v][1]+dp[v][2]))%MOD;
                dp[u][1] = (dp[u][1]*(dp[v][0]+dp[v][2]))%MOD;
                dp[u][2] = (dp[u][2]*(dp[v][0]+dp[v][1]))%MOD;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barnpainting.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barnpainting.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(x).add(y);
            adjacencyList.get(y).add(x);
        }
        color = new int[N];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(f.readLine());
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            color[b] = c;
        }
        dp = new long[N][3];
        dfs(0, -1);
        out.println((dp[0][0]+dp[0][1]+dp[0][2])%MOD);
        f.close();
        out.close();
    }
}