import java.io.*;
import java.util.*;

public class Main {
    private static int n;
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
    private static int[][] segmentTree;
    private static boolean[] lazy;
    private static void build(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(l == r) {
            segmentTree[u][0] = segmentTree[u][1] = arr[l];
            return;
        }
        int m = (l+r)/2;
        build(u*2, l, m);
        build(u*2+1, m+1, r);
        segmentTree[u][0] = Math.max(segmentTree[u*2][0], segmentTree[u*2+1][0]);
        segmentTree[u][1] = Math.min(segmentTree[u*2][1], segmentTree[u*2+1][1]);
    }
    private static void push(int u) {
        int temp = segmentTree[u*2][0];
        segmentTree[u*2][0] = -segmentTree[u*2][1];
        segmentTree[u*2][1] = -temp;
        lazy[u*2] = true;
        temp = segmentTree[u*2+1][0];
        segmentTree[u*2+1][0] = -segmentTree[u*2+1][1];
        segmentTree[u*2+1][1] = -temp;
        lazy[u*2+1] = true;
        lazy[u] = false;
    }
    private static void update1(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return;
        }
        if(l >= ll && r <= rr) {
            int temp = segmentTree[u][0];
            segmentTree[u][0] = -segmentTree[u][1];
            segmentTree[u][1] = -temp;
            lazy[u] = true;
            return;
        }
        if(lazy[u]) {
            push(u);
        }
        int m = (l+r)/2;
        update1(u*2, l, m, ll, rr);
        update1(u*2+1, m+1, r, ll, rr);
        segmentTree[u][0] = Math.max(segmentTree[u*2][0], segmentTree[u*2+1][0]);
        segmentTree[u][1] = Math.min(segmentTree[u*2][1], segmentTree[u*2+1][1]);
    }
    private static void update2(int u, int l, int r, int i, int v) {
        if(l > i || r < i) {
            return;
        }
        if(l == r) {
            segmentTree[u][0] = segmentTree[u][1] = v;
            return;
        }
        if(lazy[u]) {
            push(u);
        }
        int m = (l+r)/2;
        update2(u*2, l, m, i, v);
        update2(u*2+1, m+1, r, i, v);
        segmentTree[u][0] = Math.max(segmentTree[u*2][0], segmentTree[u*2+1][0]);
        segmentTree[u][1] = Math.min(segmentTree[u*2][1], segmentTree[u*2+1][1]);
    }
    private static int query(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return Integer.MIN_VALUE;
        }
        if(l >= ll && r <= rr) {
            return segmentTree[u][0];
        }
        if(lazy[u]) {
            push(u);
        }
        int m = (l+r)/2;
        return Math.max(query(u*2, l, m, ll, rr), query(u*2+1, m+1, r, ll, rr));
    }
    private static void negate(int u, int v) {
        if(u == v) {
            return;
        }
        if(root[u] == root[v]) {
            if(depth[u] > depth[v]) {
                update1(1, 1, n, idx[heavy[v]], idx[u]);
            } else {
                update1(1, 1, n, idx[heavy[u]], idx[v]);
            }
            return;
        }
        if(depth[root[u]] > depth[root[v]]) {
            update1(1, 1, n, idx[root[u]], idx[u]);
            negate(parent[root[u]], v);
        } else {
            update1(1, 1, n, idx[root[v]], idx[v]);
            negate(u, parent[root[v]]);
        }
    }
    private static int max(int u, int v) {
        if(u == v) {
            return Integer.MIN_VALUE;
        }
        if(root[u] == root[v]) {
            return depth[u] > depth[v] ? query(1, 1, n, idx[heavy[v]], idx[u]) : query(1, 1, n, idx[heavy[u]], idx[v]);
        }
        return depth[root[u]] > depth[root[v]] ? Math.max(query(1, 1, n, idx[root[u]], idx[u]), max(parent[root[u]], v)) : Math.max(query(1, 1, n, idx[root[v]], idx[v]), max(u, parent[root[v]]));
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            f.readLine();
            n = Integer.parseInt(f.readLine());
            adjacencyList = new ArrayList<ArrayList<int[]>>(n+1);
            for(int i = 0; i < n+1; i++) {
                adjacencyList.add(new ArrayList<int[]>());
            }
            int[][] edges = new int[n][3];
            for(int i = 1; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
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
            int size = 1;
            while(size < n) {
                size *= 2;
            }
            segmentTree = new int[2*size][2];
            lazy = new boolean[2*size];
            build(1, 1, n);
            while(true) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                String type = st.nextToken();
                if(type.equals("DONE")) {
                    break;
                }
                if(type.equals("CHANGE")) {
                    int i = Integer.parseInt(st.nextToken());
                    int v = Integer.parseInt(st.nextToken());
                    int u = depth[edges[i][0]] > depth[edges[i][1]] ? edges[i][0] : edges[i][1];
                    update2(1, 1, n, idx[u], v);
                } else if(type.equals("NEGATE")) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    negate(a, b);
                } else {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    out.println(max(a, b));
                }
            }
        }
        f.close();
        out.close();
    }
}
