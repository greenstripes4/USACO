import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] in;
    private static int[] ot;
    private static int t;
    private static int[] segmentTree;
    private static int[] lazy;
    private static int[] arr;
    private static void build(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(l == r) {
            segmentTree[u] = arr[l];
            return;
        }
        int m = (l+r)/2;
        build(u*2, l, m);
        build(u*2+1, m+1, r);
        segmentTree[u] = segmentTree[u*2]+segmentTree[u*2+1];
    }
    private static void push(int u, int s1, int s2) {
        segmentTree[u*2] = s1-segmentTree[u*2];
        lazy[u*2] ^= lazy[u];
        segmentTree[u*2+1] = s2-segmentTree[u*2+1];
        lazy[u*2+1] ^= lazy[u];
        lazy[u] = 0;
    }
    private static void update(int u, int l, int r, int ll, int rr, int v) {
        if(l > r || l > rr || r < ll) {
            return;
        }
        if(l >= ll && r <= rr) {
            segmentTree[u] = r-l+1-segmentTree[u];
            lazy[u] ^= 1;
            return;
        }
        int m = (l+r)/2;
        if(lazy[u] > 0) {
            push(u, m-l+1, r-m);
        }
        update(u*2, l, m, ll, rr, v);
        update(u*2+1, m+1, r, ll, rr, v);
        segmentTree[u] = segmentTree[u*2]+segmentTree[u*2+1];
    }
    private static int query(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return 0;
        }
        if(l >= ll && r <= rr) {
            return segmentTree[u];
        }
        int m = (l+r)/2;
        if(lazy[u] > 0) {
            push(u, m-l+1, r-m);
        }
        return query(u*2, l, m, ll, rr)+query(u*2+1, m+1, r, ll, rr);
    }
    private static void dfs(int u) {
        in[u] = t++;
        for(int v: adjacencyList.get(u)) {
            dfs(v);
        }
        ot[u] = t++;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 1; i < n; i++) {
            adjacencyList.get(Integer.parseInt(st.nextToken())-1).add(i);
        }
        in = new int[n];
        ot = new int[n];
        t = 0;
        dfs(0);
        int size = 1;
        while(size < 2*n) {
            size *= 2;
        }
        st = new StringTokenizer(f.readLine());
        arr = new int[2*n];
        for(int i = 0; i < n; i++) {
            arr[in[i]] = arr[ot[i]] = Integer.parseInt(st.nextToken());
        }
        segmentTree = new int[2*size];
        lazy = new int[2*size];
        build(1, 0, 2*n-1);
        int q = Integer.parseInt(f.readLine());
        while(q-- > 0) {
            st = new StringTokenizer(f.readLine());
            String type = st.nextToken();
            int v = Integer.parseInt(st.nextToken())-1;
            if(type.equals("get")) {
                out.println(query(1, 0, 2*n-1, in[v], ot[v])/2);
            } else {
                update(1, 0, 2*n-1, in[v], ot[v], 1);
            }
        }
        f.close();
        out.close();
    }
}