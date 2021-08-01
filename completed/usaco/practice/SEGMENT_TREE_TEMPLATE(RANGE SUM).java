import java.io.*;
import java.util.*;

public class Main{
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
    private static void push(int u) {
        segmentTree[u*2] += lazy[u];
        lazy[u*2] = lazy[u];
        segmentTree[u*2+1] += lazy[u];
        lazy[u*2+1] = lazy[u];
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
        update(u, l, m, ll, rr, v);
        update(u, m+1, r, ll, rr, v);
        segmentTree[u] = segmentTree[u*2]+segmentTree[u*2+1];
    }
    private static int query(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return 0;
        }
        if(l >= ll && r <= rr) {
            return segmentTree[u];
        }
        push(u);
        int m = (l+r)/2;
        return query(u, l, m, ll, rr)+query(u, m+1, r, ll, rr);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        f.close();
        out.close();
    }
}
