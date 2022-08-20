import java.io.*;
import java.util.*;

public class Main {
    private static long[] segmentTree;
    private static int[] lazy1;
    private static long[] lazy2;
    private static int[] arr;
    private static void build(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(l == r) {
            lazy1[u] = arr[l];
            return;
        }
        int m = (l+r)/2;
        build(u*2, l, m);
        build(u*2+1, m+1, r);
        lazy1[u] = -1;
    }
    private static void push(int u, int l, int r) {
        int m = (l+r)/2;
        int l1 = m-l+1;
        int l2 = r-m;
        segmentTree[u*2] += lazy2[u]*l1;
        lazy1[u*2] = lazy1[u];
        lazy2[u*2] += lazy2[u];
        segmentTree[u*2+1] += lazy2[u]*l2;
        lazy1[u*2+1] = lazy1[u];
        lazy2[u*2+1] += lazy2[u];
        lazy2[u] = 0;
    }
    private static void update(int u, int l, int r, int ll, int rr, int v) {
        if(l > r || l > rr || r < ll) {
            return;
        }
        if(l >= ll && r <= rr && lazy1[u] >= 0) {
            segmentTree[u] += Math.abs(v-lazy1[u])*(r-l+1L);
            lazy2[u] += Math.abs(v-lazy1[u]);
            lazy1[u] = v;
            return;
        }
        if(lazy1[u] >= 0) {
            push(u, l, r);
        }
        int m = (l+r)/2;
        update(u*2, l, m, ll, rr, v);
        update(u*2+1, m+1, r, ll, rr, v);
        segmentTree[u] = segmentTree[u*2]+segmentTree[u*2+1];
        lazy1[u] = lazy1[u*2] >= 0 && lazy1[u*2+1] >= 0 && lazy1[u*2] == lazy1[u*2+1] ? lazy1[u*2] : -1;
    }
    private static long query(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return 0;
        }
        if(l >= ll && r <= rr) {
            return segmentTree[u];
        }
        if(lazy1[u] >= 0) {
            push(u, l, r);
        }
        int m = (l+r)/2;
        return query(u*2, l, m, ll, rr)+query(u*2+1, m+1, r, ll, rr);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        int size = 1;
        while(size < n) {
            size *= 2;
        }
        segmentTree = new long[2*size];
        lazy1 = new int[2*size];
        lazy2 = new long[2*size];
        build(1, 0, n-1);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int type = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken())-1;
            int r = Integer.parseInt(st.nextToken())-1;
            if(type == 1) {
                int x = Integer.parseInt(st.nextToken());
                update(1, 0, n-1, l, r, x);
            } else {
                out.println(query(1, 0, n-1, l, r));
            }
        }
        f.close();
        out.close();
    }
}