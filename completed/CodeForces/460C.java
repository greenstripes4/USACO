import java.io.*;
import java.util.*;

public class Main {
    private static long[] segmentTree;
    private static long[] lazy;
    private static long[] arr;
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
        lazy[u*2] += lazy[u];
        segmentTree[u*2+1] += lazy[u];
        lazy[u*2+1] += lazy[u];
        lazy[u] = 0;
    }
    private static void update(int u, int l, int r, int ll, int rr, long v) {
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
        segmentTree[u] = segmentTree[u*2]+segmentTree[u*2+1];
    }
    private static long query(int u, int l, int r, int i) {
        if(l > i || r < i) {
            return 0;
        }
        if(l == r) {
            return segmentTree[u];
        }
        push(u);
        int m = (l+r)/2;
        return query(u*2, l, m, i)+query(u*2+1, m+1, r, i);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int size = 1;
        while(size < n) {
            size *= 2;
        }
        long low = 0;
        long high = Integer.MAX_VALUE;
        long ans = 0;
        while(low <= high) {
            long mid = (low+high)/2;
            arr = new long[n];
            for(int i = 0; i < n; i++) {
                arr[i] = mid-a[i];
            }
            segmentTree = new long[2*size];
            lazy = new long[2*size];
            build(1, 0, n-1);
            int left = m;
            boolean flag = false;
            for(int i = 0; i < n; i++) {
                long cur = query(1, 0, n-1, i);
                if(cur > 0) {
                    if(cur > left) {
                        flag = true;
                        break;
                    }
                    left -= cur;
                    update(1, 0, n-1, i, Math.min(n-1, i+w-1), -cur);
                }
            }
            if(flag) {
                high = mid-1;
            } else {
                low = mid+1;
                ans = mid;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
