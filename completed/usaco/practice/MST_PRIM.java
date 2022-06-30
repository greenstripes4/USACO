import java.io.*;
import java.util.*;

public class Main {

    private static int n;

    private static int[][] adjacencyMatrix;
    private static int[][] primDense() {
        int[][] mst = new int[n-1][3];
        boolean[] visited = new boolean[n+1];
        int[] cost = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        visited[1] = true;
        for(int i = 2; i <= n; i++) {
            if(adjacencyMatrix[1][i] < cost[i]) {
                cost[i] = adjacencyMatrix[1][i];
                parent[i] = 1;
            }
        }
        for(int i = 0; i < n-1; i++) {
            int u = 0;
            for(int j = 1; j <= n; j++) {
                if(!visited[j] && cost[j] < cost[u]) {
                    u = j;
                }
            }
            if(cost[u] == Integer.MAX_VALUE) {
                return null;
            }
            mst[i][0] = parent[u];
            mst[i][1] = u;
            mst[i][2] = cost[u];
            visited[u] = true;
            for(int v = 1; v <= n; v++) {
                if(!visited[v] && adjacencyMatrix[u][v] < cost[v]) {
                    cost[v] = adjacencyMatrix[u][v];
                    parent[v] = u;
                }
            }
        }
        return mst;
    }

    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static int[][] primSparse() {
        int[][] mst = new int[n-1][3];
        boolean[] visited = new boolean[n+1];
        TreeSet<int[]> edges = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        int[] cost = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        visited[1] = true;
        for(int[] i: adjacencyList.get(1)) {
            if(i[1] < cost[i[0]]) {
                edges.add(new int[]{i[0], i[1]});
                cost[i[0]] = i[1];
                parent[i[0]] = 1;
            }
        }
        for(int i = 0; i < n-1; i++) {
            int[] u = edges.pollFirst();
            if(u == null) {
                return null;
            }
            mst[i][0] = parent[u[0]];
            mst[i][1] = u[0];
            mst[i][2] = u[1];
            visited[u[0]] = true;
            for(int[] v: adjacencyList.get(u[0])) {
                if(!visited[v[0]] && v[1] < cost[v[0]]) {
                    edges.remove(new int[]{v[0], cost[v[0]]});
                    edges.add(new int[]{v[0], v[1]});
                    cost[v[0]] = v[1];
                    parent[v[0]] = u[0];
                }
            }
        }
        return mst;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        f.close();
        out.close();
    }
}