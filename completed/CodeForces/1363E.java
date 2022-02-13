import java.io.*;
import java.util.*;

public class Main {
    private static int[][] nodes;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] parent;
    private static int[][] subtree;
    private static boolean[] visited;
    private static void dfs1(int u, int p) {
        parent[u] = p;
        if(nodes[u][1] == 0 && nodes[u][2] == 1) {
            subtree[u][0] = 1;
        } else if(nodes[u][1] == 1 && nodes[u][2] == 0) {
            subtree[u][1] = 1;
        }
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs1(v, u);
            }
        }
    }
    private static void dfs2(int u) {
        for(int v: adjacencyList.get(u)) {
            if(v != parent[u] && !visited[v]) {
                visited[v] = true;
                dfs2(v);
                subtree[u][0] += subtree[v][0];
                subtree[u][1] += subtree[v][1];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        nodes = new int[n][3];
        Integer[] sorted = new Integer[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            nodes[i][0] = Integer.parseInt(st.nextToken());
            nodes[i][1] = Integer.parseInt(st.nextToken());
            nodes[i][2] = Integer.parseInt(st.nextToken());
            sorted[i] = i;
        }
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
        parent = new int[n];
        subtree = new int[n][2];
        dfs1(0, -1);
        Arrays.sort(sorted, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return nodes[a][0]-nodes[b][0];
            }
        });
        visited = new boolean[n];
        long cost = 0;
        for(int i: sorted) {
            if(!visited[i]) {
                dfs2(i);
                int min = Math.min(subtree[i][0], subtree[i][1]);
                subtree[i][0] -= min;
                subtree[i][1] -= min;
                cost += 2L*min*nodes[i][0];
            }
        }
        out.println(subtree[0][0]+subtree[0][1] > 0 ? -1 : cost);
        f.close();
        out.close();
    }
}
