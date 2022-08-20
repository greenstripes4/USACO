import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static int root(int u) {
        while(u != parent[u]) {
            parent[u] = parent[parent[u]];
            u = parent[u];
        }
        return u;
    }
    private static void union(int u, int v) {
        int rootU = root(u);
        int rootV = root(v);
        if(rootU == rootV) {
            return;
        }
        parent[rootV] = rootU;
    }
    private static void init(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static boolean[] visited;
    private static ArrayList<ArrayList<int[]>> queries;
    private static int[] res;
    private static void dfs(int u) {
        visited[u] = true;
        parent[u] = u;
        for(int v: adjacencyList.get(u)) {
            if(!visited[v]) {
                dfs(v);
                union(u, v);
            }
        }
        for(int[] i: queries.get(u)) {
            if(visited[i[0]]) {
                res[i[1]] = root(i[0]);
            }
        }
    }
    private static int[] depth;
    private static int[] arr;
    private static int[] sum;
    private static void dfs2(int u, int p) {
        sum[u] = arr[u];
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                depth[v] = depth[u]+1;
                dfs2(v, u);
                sum[u] += sum[v];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList<>(n+1);
        queries = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
            queries.add(new ArrayList<>());
        }
        int[][] edges = new int[n-1][2];
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }
        arr = new int[n+1];
        int k = Integer.parseInt(f.readLine());
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a]++;
            arr[b]++;
            queries.get(a).add(new int[]{b, i});
            queries.get(b).add(new int[]{a, i});
        }
        init(n+1);
        visited = new boolean[n+1];
        res = new int[k];
        dfs(1);
        for(int i: res) {
            arr[i] -= 2;
        }
        depth = new int[n+1];
        sum = new int[n+1];
        dfs2(1, 0);
        for(int[] i: edges) {
            if(depth[i[0]] > depth[i[1]]) {
                int temp = i[0];
                i[0] = i[1];
                i[1] = temp;
            }
            out.print(sum[i[1]] + " ");
        }
        out.println();
        f.close();
        out.close();
    }
}