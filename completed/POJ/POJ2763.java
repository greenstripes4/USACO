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
    private static int[] BIT;
    private static void build() {
        BIT = new int[arr.length];
        for(int i = 1; i < arr.length; i++) {
            update(i, arr[i]);
        }
    }
    private static void update(int index, int add) {
        while(index < BIT.length) {
            BIT[index] += add;
            index += index&-index;
        }
    }
    private static int query(int index) {
        int sum = 0;
        while(index > 0) {
            sum += BIT[index];
            index -= index&-index;
        }
        return sum;
    }
    private static int distance(int u, int v) {
        if(u == v) {
             return 0;
        }
        if(root[u] == root[v]) {
            return depth[u] > depth[v] ? query(idx[u])-query(idx[heavy[v]]-1) : query(idx[v])-query(idx[heavy[u]]-1);
        }
        return depth[root[u]] > depth[root[v]] ? query(idx[u])-query(idx[root[u]]-1)+distance(parent[root[u]], v) : query(idx[v])-query(idx[root[v]]-1)+distance(u, parent[root[v]]);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<ArrayList<int[]>>(n+1);
        for(int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<int[]>());
        }
        int[][] edges = new int[n][3];
        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
            adjacencyList.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            adjacencyList.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }
        depth = new int[n+1];
        size = new int[n+1];
        parent = new int[n+1];
        heavy = new int[n+1];
        root = new int[n+1];
        arr = new int[n+1];
        idx = new int[n+1];
        time = 1;
        dfs1(1);
        dfs2(1);
        build();
        while(q-- > 0) {
            st = new StringTokenizer(f.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type == 0) {
                int u = Integer.parseInt(st.nextToken());
                out.println(distance(s, u));
                s = u;
            } else {
                int i = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int u = depth[edges[i][0]] > depth[edges[i][1]] ? edges[i][0] : edges[i][1];
                update(idx[u], w-arr[idx[u]]);
            }
        }
        f.close();
        out.close();
    }
}