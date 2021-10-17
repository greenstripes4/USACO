import java.io.*;
import java.util.*;

public class Main{
    private static long[] segmentTree;
    private static long[] lazy;
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
        segmentTree[u] = Math.min(segmentTree[u*2], segmentTree[u*2+1]);
    }
    private static void push(int u) {
        segmentTree[u*2] += lazy[u];
        lazy[u*2] += lazy[u];
        segmentTree[u*2+1] += lazy[u];
        lazy[u*2+1] += lazy[u];
        lazy[u] = 0;
    }
    private static void update(int u, int l, int r, int ll, int rr, int v) {
        if(l > r || l > rr || r < ll) {
            return;
        }
        if(l >= ll && r <= rr) {
            segmentTree[u] += v;
            lazy[u] += v;
            return;
        }
        push(u);
        int m = (l+r)/2;
        update(u*2, l, m, ll, rr, v);
        update(u*2+1, m+1, r, ll, rr, v);
        segmentTree[u] = Math.min(segmentTree[u*2], segmentTree[u*2+1]);
    }
    private static long query(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return Long.MAX_VALUE;
        }
        if(l >= ll && r <= rr) {
            return segmentTree[u];
        }
        push(u);
        int m = (l+r)/2;
        return Math.min(query(u*2, l, m, ll, rr), query(u*2+1, m+1, r, ll, rr));
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int size = 1;
        while(size < n) {
            size *= 2;
        }
        segmentTree = new long[2*size];
        lazy = new long[2*size];
        build(1, 0, n-1);
        int m = Integer.parseInt(f.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            if(st.countTokens() == 2) {
                int ll = Integer.parseInt(st.nextToken());
                int rr = Integer.parseInt(st.nextToken());
                if(ll > rr) {
                    out.println(Math.min(query(1, 0, n-1, 0, rr), query(1, 0, n-1, ll, n-1)));
                } else {
                    out.println(query(1, 0, n-1, ll, rr));
                }
            } else {
                int ll = Integer.parseInt(st.nextToken());
                int rr = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if(ll > rr) {
                    update(1, 0, n-1, 0, rr, v);
                    update(1, 0, n-1, ll, n-1, v);
                } else {
                    update(1, 0, n-1, ll, rr, v);
                }
            }
        }
        f.close();
        out.close();
    }
}
