import java.io.*;
import java.util.*;

public class Main {
    private static int[][] segmentTree;
    private static int[] a;
    private static void build(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(l == r) {
            segmentTree[u][0] = 1;
            segmentTree[u][1] = 1;
            segmentTree[u][2] = 1;
            return;
        }
        int m = (l+r)/2;
        build(u*2, l, m);
        build(u*2+1, m+1, r);
        segmentTree[u][0] = Math.max(segmentTree[u*2][0], segmentTree[u*2+1][0]);
        segmentTree[u][1] = segmentTree[u*2][1];
        segmentTree[u][2] = segmentTree[u*2+1][2];
        if(a[m] == a[m+1]) {
            segmentTree[u][0] = Math.max(segmentTree[u][0], segmentTree[u*2][2]+segmentTree[u*2+1][1]);
            if(segmentTree[u*2][1] == m-l+1) {
                segmentTree[u][1] += segmentTree[u*2+1][1];
            }
            if(segmentTree[u*2+1][2] == r-m) {
                segmentTree[u][2] += segmentTree[u*2][2];
            }
        }
    }
    private static int query(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return 0;
        }
        if(l >= ll && r <= rr) {
            return segmentTree[u][0];
        }
        int m = (l+r)/2;
        int left = query(u*2, l, m, ll, rr);
        int right = query(u*2+1, m+1, r, ll, rr);
        int combined = 0;
        if(left > 0 && right > 0 && a[m] == a[m+1]) {
            combined = Math.min(segmentTree[u*2][2], m-ll+1)+Math.min(segmentTree[u*2+1][1], rr-m);
        }
        return Math.max(Math.max(left, right), combined);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) {
                break;
            }
            int q = Integer.parseInt(st.nextToken());
            int size = 1;
            while(size < n) {
                size *= 2;
            }
            segmentTree = new int[2*size][3];
            st = new StringTokenizer(f.readLine());
            a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            build(1, 0, n-1);
            for(int i = 0; i < q; i++) {
                st = new StringTokenizer(f.readLine());
                int l = Integer.parseInt(st.nextToken())-1;
                int r = Integer.parseInt(st.nextToken())-1;
                out.println(query(1, 0, n-1, l, r));
            }
        }
        f.close();
        out.close();
    }
}
