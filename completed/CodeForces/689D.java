import java.io.*;
import java.util.*;

public class Main {
    private static int[] segmentTree1;
    private static int[] a;
    private static void build1(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(l == r) {
            segmentTree1[u] = a[l];
            return;
        }
        int m = (l+r)/2;
        build1(u*2, l, m);
        build1(u*2+1, m+1, r);
        segmentTree1[u] = Math.max(segmentTree1[u*2], segmentTree1[u*2+1]);
    }
    private static int query1(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return Integer.MIN_VALUE;
        }
        if(l >= ll && r <= rr) {
            return segmentTree1[u];
        }
        int m = (l+r)/2;
        return Math.max(query1(u*2, l, m, ll, rr), query1(u*2+1, m+1, r, ll, rr));
    }
    private static int[] segmentTree2;
    private static int[] b;
    private static void build2(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(l == r) {
            segmentTree2[u] = b[l];
            return;
        }
        int m = (l+r)/2;
        build2(u*2, l, m);
        build2(u*2+1, m+1, r);
        segmentTree2[u] = Math.min(segmentTree2[u*2], segmentTree2[u*2+1]);
    }
    private static int query2(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return Integer.MAX_VALUE;
        }
        if(l >= ll && r <= rr) {
            return segmentTree2[u];
        }
        int m = (l+r)/2;
        return Math.min(query2(u*2, l, m, ll, rr), query2(u*2+1, m+1, r, ll, rr));
    }
    private static int floor(int low, int high) {
        int left = low;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(query1(1, 0, a.length-1, left, mid)-query2(1, 0, b.length-1, left, mid) <= 0) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static int ceil(int low, int high) {
        int left = low;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(query1(1, 0, a.length-1, left, mid)-query2(1, 0, b.length-1, left, mid) >= 0) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        b = new int[n];
        for(int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        int size = 1;
        while(size < n) {
            size *= 2;
        }
        segmentTree1 = new int[size*2];
        segmentTree2 = new int[size*2];
        build1(1, 0, n-1);
        build2(1, 0, n-1);
        long ans = 0;
        for(int i = 0; i < n; i++) {
            int right = floor(i, n-1);
            int left = ceil(i, n-1);
            if(query1(1, 0, n-1, i, left) == query2(1, 0, n-1, i, left)) {
                ans += right-left+1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}