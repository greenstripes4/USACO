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
    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static int[][] visited;
    private static ArrayList<ArrayList<int[]>> queries;
    private static int[] res = new int[1000000];
    private static void dfs(int u) {
        parent[u] = u;
        for(int[] v: adjacencyList.get(u)) {
            if(visited[v[0]][0] == -1) {
                visited[v[0]][0] = visited[u][0]+v[1];
                visited[v[0]][1] = visited[u][1];
                dfs(v[0]);
                union(u, v[0]);
            }
        }
        for(int[] i: queries.get(u)) {
            if(visited[i[0]][1] == visited[u][1]) {
                res[i[1]] = visited[u][0]+visited[i[0]][0]-2*visited[root(i[0])][0];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjacencyList = new ArrayList<>(n+1);
            queries = new ArrayList<>(n+1);
            for(int i = 0; i <= n; i++) {
                adjacencyList.add(new ArrayList<>());
                queries.add(new ArrayList<>());
            }
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                adjacencyList.get(u).add(new int[]{v, w});
                adjacencyList.get(v).add(new int[]{u, w});
            }
            for(int i = 0; i < c; i++) {
                st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                queries.get(u).add(new int[]{v, i});
                queries.get(v).add(new int[]{u, i});
            }
            init(n+1);
            visited = new int[n+1][2];
            for(int[] i: visited) {
                Arrays.fill(i, -1);
            }
            Arrays.fill(res, -1);
            for(int i = 1; i <= n; i++) {
                if(visited[i][0] == -1) {
                    visited[i][0] = 0;
                    visited[i][1] = i;
                    dfs(i);
                }
            }
            for(int i = 0; i < c; i++) {
                out.println(res[i] == -1 ? "Not connected" : res[i]);
            }
        }
        f.close();
        out.close();
    }
}