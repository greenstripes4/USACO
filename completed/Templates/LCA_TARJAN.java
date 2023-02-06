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
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        f.close();
        out.close();
    }
}
