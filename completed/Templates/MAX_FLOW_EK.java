import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[][] capacity;
    private static int[] parent;
    private static int source;
    private static int sink;
    private static int bfs() {
        Arrays.fill(parent, -1);
        Queue<int[]> queue = new LinkedList<>();
        parent[source] = -2;
        queue.offer(new int[]{source, Integer.MAX_VALUE});
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int u = temp[0];
            int f = temp[1];
            if(u == sink) {
                return f;
            }
            for(int v: adjacencyList.get(u)) {
                if(parent[v] == -1 && capacity[u][v] > 0) {
                    parent[v] = u;
                    queue.offer(new int[]{v, Math.min(f, capacity[u][v])});
                }
            }
        }
        return 0;
    }
    private static int maxFlow() {
        int ans = 0;
        int inc;
        parent = new int[N];
        while((inc = bfs()) > 0) {
            ans += inc;
            int u = sink;
            while(u != source) {
                capacity[parent[u]][u] -= inc;
                capacity[u][parent[u]] += inc;
                u = parent[u];
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
