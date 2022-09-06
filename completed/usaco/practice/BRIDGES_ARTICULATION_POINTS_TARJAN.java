import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static boolean[] visited;
    private static int[] in;
    private static int[] low;
    private static int time;
    //bridges
    private static ArrayList<int[]> bridges;
    //articulation points
    private static ArrayList<Integer> articulationPoints;
    private static void dfs(int u, int p) {
        visited[u] = true;
        low[u] = in[u] = time++;
        int size = 0;
        boolean flag = false;
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                if(visited[v]) {
                    low[u] = Math.min(low[u], in[v]);
                } else {
                    dfs(v, u);
                    low[u] = Math.min(low[u], low[v]);
                    //find bridges
                    if(low[v] > in[u]) {
                        bridges.add(new int[]{u, v});
                    }
                    //find articulation points
                    if(p != -1 && low[v] >= in[u] && !flag) {
                        flag = true;
                        articulationPoints.add(u);
                    }
                    size++;
                }
            }
        }
        //find articulation points
        if(p == -1 && size > 1) {
            articulationPoints.add(u);
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