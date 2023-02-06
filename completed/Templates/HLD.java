import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static int[] depth;
    private static int[] size;
    private static int[] parent;
    private static int[] heavy;
    private static int[] root;
    private static int[] arr;
    private static int[] idx;
    private static int time;
    private static void dfs1(int u) {
        size[u] = 1;
        heavy[u] = -1;
        for(int[] v: adjacencyList.get(u)) {
            if(v[0] != parent[u]) {
                depth[v[0]] = depth[u]+1;
                parent[v[0]] = u;
                dfs1(v[0]);
                size[u] += size[v[0]];
                if(heavy[u] == -1 || size[v[0]] > size[heavy[u]]) {
                    heavy[u] = v[0];
                }
            }
        }
    }
    private static void dfs2(int u) {
        if(u != 1 && heavy[parent[u]] == u) {
            root[u] = root[parent[u]];
        } else {
            root[u] = u;
        }
        idx[u] = time++;
        if(heavy[u] != -1) {
            dfs2(heavy[u]);
        }
        for(int[] v: adjacencyList.get(u)) {
            if(v[0] != parent[u] && v[0] != heavy[u]) {
                dfs2(v[0]);
                arr[idx[v[0]]] = v[1];
            } else if(v[0] == heavy[u]) {
                arr[idx[v[0]]] = v[1];
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
