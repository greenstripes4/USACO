import java.io.*;
import java.util.*;

public class Main{
    private static long[] segmentTree;
    private static boolean[] lazy;
    private static long[] arr;
    private static void build(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(l == r) {
            segmentTree[u] = arr[l];
            if(arr[l] == 1) {
                lazy[u] = true;
            }
            return;
        }
        int m = (l+r)/2;
        build(u*2, l, m);
        build(u*2+1, m+1, r);
        segmentTree[u] = segmentTree[u*2]+segmentTree[u*2+1];
        lazy[u] = lazy[u*2] && lazy[u*2+1];
    }
    private static void push(int u, int l, int r) {
        if(lazy[u]) {
            segmentTree[u*2] = (l+r)/2-l+1;
            lazy[u*2] = true;
            segmentTree[u*2+1] = r-(l+r)/2;
            lazy[u*2+1] = true;
        }
    }
    private static void update(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll || lazy[u]) {
            return;
        }
        if(l == r) {
            segmentTree[u] = (long) Math.sqrt(segmentTree[u]);
            if(segmentTree[u] == 1) {
                lazy[u] = true;
            }
            return;
        }
        push(u, l, r);
        int m = (l+r)/2;
        update(u*2, l, m, ll, rr);
        update(u*2+1, m+1, r, ll, rr);
        segmentTree[u] = segmentTree[u*2]+segmentTree[u*2+1];
        lazy[u] = lazy[u*2] && lazy[u*2+1];
    }
    private static long query(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return 0;
        }
        if(l >= ll && r <= rr) {
            return segmentTree[u];
        }
        push(u, l, r);
        int m = (l+r)/2;
        return query(u*2, l, m, ll, rr)+query(u*2+1, m+1, r, ll, rr);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        while(f.hasNext()) {
            int N = f.nextInt();
            arr = new long[N];
            for(int i = 0; i < N; i++) {
                arr[i] = f.nextLong();
            }
            int size = 1;
            while(size < N) {
                size *= 2;
            }
            segmentTree = new long[2*size];
            lazy = new boolean[2*size];
            build(1, 0, N-1);
            int M = f.nextInt();
            out.println("Case #" + t + ":");
            for(int i = 0; i < M; i++) {
                int T = f.nextInt();
                int X = f.nextInt()-1;
                int Y = f.nextInt()-1;
                if(T == 0) {
                    update(1, 0, N-1, X, Y);
                } else {
                    out.println(query(1, 0, N-1, X, Y));
                }
            }
            out.println();
            t++;
        }
        f.close();
        out.close();
    }
}