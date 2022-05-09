import java.io.*;
import java.util.*;

public class Main {
    private static int[] e;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] arr1;
    private static int[] arr2;
    private static int[] depth;
    private static int[] in1;
    private static int[] in2;
    private static int[] ot;
    private static int idx1;
    private static int idx2;
    private static void dfs(int u, int p, int d) {
        arr1[idx1] = e[u];
        arr2[idx2] = u;
        depth[idx2] = d;
        in1[u] = idx1;
        in2[u] = idx2;
        idx1++;
        idx2++;
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs(v, u, d+1);
                arr2[idx2] = u;
                depth[idx2] = d;
                idx2++;
            }
        }
        arr1[idx1] = e[u];
        ot[u] = idx1;
        idx1++;
    }
    private static int[] BIT;
    private static void update(int index, int add) {
        while(index < BIT.length) {
            BIT[index] ^= add;
            index += index&-index;
        }
    }
    private static int query(int index) {
        int sum = 0;
        while(index > 0) {
            sum ^= BIT[index];
            index -= index&-index;
        }
        return sum;
    }
    private static int[] segmentTree;
    private static void build(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(l == r) {
            segmentTree[u] = l;
            return;
        }
        int m = (l+r)/2;
        build(u*2, l, m);
        build(u*2+1, m+1, r);
        segmentTree[u] = depth[segmentTree[u*2]] < depth[segmentTree[u*2+1]] ? segmentTree[u*2] : segmentTree[u*2+1];
    }
    private static int query(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return Integer.MAX_VALUE;
        }
        if(l >= ll && r <= rr) {
            return segmentTree[u];
        }
        int m = (l+r)/2;
        int x = query(u*2, l, m, ll, rr);
        int y = query(u*2+1, m+1, r, ll, rr);
        if(x < Integer.MAX_VALUE && y < Integer.MAX_VALUE) {
            return depth[x] < depth[y] ? x : y;
        }
        return x == Integer.MAX_VALUE ? y : x;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowland.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowland.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        e = new int[N+1];
        for(int i = 1; i <= N; i++) {
            e[i] = Integer.parseInt(st.nextToken());
        }
        adjacencyList = new ArrayList<>(N+1);
        for(int i = 0; i < N+1; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);

        }
        arr1 = new int[2*N+1];
        arr2 = new int[2*N+1];
        depth = new int[2*N+1];
        in1 = new int[N+1];
        in2 = new int[N+1];
        ot = new int[N+1];
        idx1 = 1;
        idx2 = 0;
        dfs(1, 0, 0);
        BIT = new int[2*N+1];
        for(int i = 1; i <= 2*N; i++) {
            update(i, arr1[i]);
        }
        int size = 1;
        while(size < idx2) {
            size *= 2;
        }
        segmentTree = new int[2*size];
        build(1, 0, idx2-1);
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            if(Integer.parseInt(st.nextToken()) == 1) {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                update(in1[u], e[u]^v);
                update(ot[u], e[u]^v);
                e[u] = v;
                arr1[in1[u]] = v;
                arr1[ot[u]] = v;
            } else {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if(in2[v] < in2[u]) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
                out.println(query(in1[u])^query(in1[v])^e[arr2[query(1, 0, idx2-1, in2[u], in2[v])]]);
            }
        }
        f.close();
        out.close();
    }
}