import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] flag;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[][] dp;
    private static void dfs1(int u, int p) {
        if(flag[u]) {
            dp[u][0] = 0;
            dp[u][1] = -1;
            dp[u][2] = u;
        }
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs1(v, u);
                if(dp[v][0] == -1) {
                    continue;
                }
                if(dp[v][0]+1 > dp[u][0]) {
                    dp[u][1] = dp[u][0];
                    dp[u][0] = dp[v][0]+1;
                    dp[u][2] = v;
                } else if(dp[v][0]+1 > dp[u][1]) {
                    dp[u][1] = dp[v][0]+1;
                }
            }
        }
    }
    private static void dfs2(int u, int p) {
        if(u > 0) {
            int temp = (dp[p][2] == u ? (dp[p][1] == -1 ? -2 : dp[p][1]) : dp[p][0])+1;
            if(temp > dp[u][0]) {
                dp[u][1] = dp[u][0];
                dp[u][0] = temp;
                dp[u][2] = p;
            } else if(temp > dp[u][1]) {
                dp[u][1] = temp;
            }
        }
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs2(v, u);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        flag = new boolean[n];
        for(int i = 0; i < m; i++) {
            flag[Integer.parseInt(st.nextToken())-1] = true;
        }
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }
        dp = new int[n][3];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }
        dfs1(0, -1);
        dfs2(0, -1);
        int ans = 0;
        for(int[] i: dp) {
            if(i[0] <= d) {
                ans++;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}