import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] len;
    private static int[] size;
    private static long[] dp;
    private static void dfs1(int u, int p) {
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs1(v, u);
                size[u] += size[v];
            }
        }
    }
    private static void dfs2(int u, int p, int d) {
        if(p > 0 && adjacencyList.get(u).size() == 1) {
            dp[1] += d+len[u]-len[1]-1;
            return;
        }
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs2(v, u, d+len[u]+1);
            }
        }
    }
    private static void dfs3(int u, int p) {
        if(p > 0 && adjacencyList.get(u).size() > 1) {
            dp[u] = dp[p]-size[u]*(len[u]+1L)+(size[1]-size[u])*3L;
        }
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs3(v, u);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dirtraverse.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dirtraverse.out")));
        int N = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < N+1; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        size = new int[N+1];
        len = new int[N+1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            len[i] = st.nextToken().length();
            int k = Integer.parseInt(st.nextToken());
            if(k == 0) {
                size[i] = 1;
            }
            for(int j = 0; j < k; j++) {
                int u = Integer.parseInt(st.nextToken());
                adjacencyList.get(i).add(u);
                adjacencyList.get(u).add(i);
            }
        }
        dfs1(1, 0);
        dp = new long[N+1];
        dfs2(1, 0, 0);
        dfs3(1, 0);
        long min = dp[1];
        for(int i = 2; i <= N; i++) {
            if(adjacencyList.get(i).size() > 1) {
                min = Math.min(min, dp[i]);
            }
        }
        out.println(min);
        f.close();
        out.close();
    }
}
