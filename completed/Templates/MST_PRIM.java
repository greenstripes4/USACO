import java.io.*;
import java.util.*;

public class Main {

    private static int N;

    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static int[][] adjacencyMatrix;

    private static int[][] primDense() {
        int[][] mst = new int[N-1][3];
        boolean[] visited = new boolean[N];
        int[] cost = new int[N];
        int[] parent = new int[N];
        visited[0] = true;
        Arrays.fill(cost, Integer.MAX_VALUE);
        for(int i = 1; i < N; i++) {
            if(adjacencyMatrix[0][i] < cost[i]) {
                cost[i] = adjacencyMatrix[0][i];
            }
        }
        for(int i = 0; i < N-1; i++) {
            int u = -1;
            for(int j = 0; j < N; j++) {
                if(!visited[j] && (u == -1 || cost[j] < cost[u])) {
                    u = j;
                }
            }
            if(u == -1) {
                return null;
            }
            mst[i][0] = parent[u];
            mst[i][1] = u;
            mst[i][2] = cost[u];
            visited[u] = true;
            for(int v = 0; v < N; v++) {
                if(!visited[v] && adjacencyMatrix[u][v] < cost[v]) {
                    cost[v] = adjacencyMatrix[u][v];
                    parent[v] = u;
                }
            }
        }
        return mst;
    }

    private static int[][] primSparse() {
        int[][] mst = new int[N-1][3];
        boolean[] visited = new boolean[N];
        int[] cost = new int[N];
        int[] parent = new int[N];
        TreeSet<int[]> edges = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        visited[0] = true;
        Arrays.fill(cost, Integer.MAX_VALUE);
        for(int[] i: adjacencyList.get(0)) {
            if(i[1] < cost[i[0]]) {
                cost[i[0]] = i[1];
                edges.add(new int[]{i[0], i[1]});
            }
        }
        for(int i = 0; i < N-1; i++) {
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
