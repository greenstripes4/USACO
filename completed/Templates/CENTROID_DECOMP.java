import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static boolean[] visited;
    private static int[] size;
    private static int[] max;
    private static int total;
    private static int centroid;
    private static ArrayList<Integer> depth;
    private static void findCentroid(int u, int p) {
        size[u] = 1;
        max[u] = 0;
        for(int[] v: adjacencyList.get(u)) {
            if(v[0] != p && !visited[v[0]]) {
                findCentroid(v[0], u);
                size[u] += size[v[0]];
                max[u] = Math.max(max[u], size[v[0]]);
            }
        }
        max[u] = Math.max(max[u], total-size[u]);
        if(max[u] < max[centroid]) {
            centroid = u;
        }
    }
    private static void getDepth(int u, int p, int d) {
        depth.add(d);
        for(int[] v: adjacencyList.get(u)) {
            if(v[0] != p && !visited[v[0]]) {
                getDepth(v[0], u, d+v[1]);
            }
        }
    }
    private static long count(int u, int k) {
        depth = new ArrayList<>();
        getDepth(u, 0, 0);
        return 0;
    }
    private static long dfs(int u, int k) {
        visited[u] = true;
        long ans = count(u, k);
        for(int[] v: adjacencyList.get(u)) {
            if(!visited[v[0]]) {
                ans -= count(v[0], k-v[1]);
                total = size[v[0]];
                centroid = 0;
                findCentroid(v[0], 0);
                ans += dfs(centroid, k);
            }
        }
        return ans;
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
