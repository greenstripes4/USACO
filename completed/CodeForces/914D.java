import java.io.*;
import java.util.*;

public class Main {
    private static int[] segmentTree;
    private static int[] arr;
    private static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
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
        segmentTree[u] = gcd(segmentTree[u*2], segmentTree[u*2+1]);
    }
    private static void update(int u, int l, int r, int idx, int v) {
        if(l > idx || r < idx) {
            return;
        }
        if(l == r) {
            segmentTree[u] = v;
            return;
        }
        int m = (l+r)/2;
        update(u*2, l, m, idx, v);
        update(u*2+1, m+1, r, idx, v);
        segmentTree[u] = gcd(segmentTree[u*2], segmentTree[u*2+1]);
    }
    private static int query(int u, int l, int r, int ll, int rr, int x) {
        if(l > r || l > rr || r < ll) {
            return 0;
        }
        if(l >= ll && r <= rr) {
            if(segmentTree[u]%x == 0) {
                return 0;
            }
            while(u*2+1 < segmentTree.length) {
                u *= 2;
                if(segmentTree[u]%x > 0 && segmentTree[u+1]%x > 0) {
                    return 2;
                }
                if(segmentTree[u+1]%x > 0) {
                    u++;
                }
            }
            return 1;
        }
        int m = (l+r)/2;
        return Math.min(2, query(u*2, l, m, ll, rr, x)+query(u*2+1, m+1, r, ll, rr, x));
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
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
        segmentTree = new int[2*size];
        build(1, 0, n-1);
        int q = Integer.parseInt(f.readLine());
        while(q-- > 0) {
            st = new StringTokenizer(f.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type == 1) {
                int l = Integer.parseInt(st.nextToken())-1;
                int r = Integer.parseInt(st.nextToken())-1;
                int x = Integer.parseInt(st.nextToken());
                out.println(query(1, 0, n-1, l, r, x) < 2 ? "YES" : "NO");
            } else {
                int i = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken());
                update(1, 0, n-1, i, y);
            }
        }
        f.close();
        out.close();
    }
}