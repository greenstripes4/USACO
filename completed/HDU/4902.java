import java.io.*;
import java.util.*;

public class Main {
    private static int[] segmentTree;
    private static boolean[] lazy;
    private static int[] res;
    private static int k;
    private static void build(int[] a, int idx, int left, int right) {
        if(left > right) {
            return;
        }
        if(left == right) {
            segmentTree[idx] = a[left];
            lazy[idx] = true;
            return;
        }
        int mid = (left+right)/2;
        build(a, idx*2, left, mid);
        build(a, idx*2+1, mid+1, right);
        segmentTree[idx] = Math.max(segmentTree[idx*2], segmentTree[idx*2+1]);
        lazy[idx] = segmentTree[idx*2] == segmentTree[idx*2+1] && lazy[idx*2] && lazy[idx*2+1];
    }
    private static void update1(int idx, int left, int right, int rangeLeft, int rangeRight, int x) {
        if(left > right) {
            return;
        }
        if(left > rangeRight || right < rangeLeft) {
            return;
        }
        if(left >= rangeLeft && right <= rangeRight) {
            segmentTree[idx] = x;
            lazy[idx] = true;
            return;
        }
        if(lazy[idx]) {
            segmentTree[idx*2] = segmentTree[idx];
            lazy[idx*2] = true;
            segmentTree[idx*2+1] = segmentTree[idx];
            lazy[idx*2+1] = true;
            lazy[idx] = false;
        }
        int mid = (left+right)/2;
        update1(idx*2, left, mid, rangeLeft, rangeRight, x);
        update1(idx*2+1, mid+1, right, rangeLeft, rangeRight, x);
        segmentTree[idx] = Math.max(segmentTree[idx*2], segmentTree[idx*2+1]);
        lazy[idx] = segmentTree[idx*2] == segmentTree[idx*2+1] && lazy[idx*2] && lazy[idx*2+1];
    }
    private static void update2(int idx, int left, int right, int rangeLeft, int rangeRight, int x) {
        if(left > right) {
            return;
        }
        if(left > rangeRight || right < rangeLeft) {
            return;
        }
        if(left >= rangeLeft && right <= rangeRight && lazy[idx]) {
            if(segmentTree[idx] > x) {
                segmentTree[idx] = gcd(segmentTree[idx], x);
            }
            return;
        }
        if(lazy[idx]) {
            segmentTree[idx*2] = segmentTree[idx];
            lazy[idx*2] = true;
            segmentTree[idx*2+1] = segmentTree[idx];
            lazy[idx*2+1] = true;
            lazy[idx] = false;
        }
        int mid = (left+right)/2;
        update2(idx*2, left, mid, rangeLeft, rangeRight, x);
        update2(idx*2+1, mid+1, right, rangeLeft, rangeRight, x);
        segmentTree[idx] = Math.max(segmentTree[idx*2], segmentTree[idx*2+1]);
        lazy[idx] = segmentTree[idx*2] == segmentTree[idx*2+1] && lazy[idx*2] && lazy[idx*2+1];
    }
    private static void query(int idx, int left, int right) {
        if(left > right) {
            return;
        }
        if(lazy[idx]) {
            for(int i = left; i <= right; i++) {
                res[k++] = segmentTree[idx];
            }
            return;
        }
        int mid = (left+right)/2;
        query(idx*2, left, mid);
        query(idx*2+1, mid+1, right);
    }
    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int size = 1;
            while(size < n) {
                size *= 2;
            }
            segmentTree = new int[2*size];
            lazy = new boolean[2*size];
            build(a, 1, 0, n-1);
            int Q = Integer.parseInt(f.readLine());
            for(int i = 0; i < Q; i++) {
                st = new StringTokenizer(f.readLine());
                int t = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken())-1;
                int r = Integer.parseInt(st.nextToken())-1;
                int x = Integer.parseInt(st.nextToken());
                if(t == 1) {
                    update1(1, 0, n-1, l, r, x);
                } else {
                    update2(1, 0, n-1, l, r, x);
                }
            }
            res = new int[n];
            k = 0;
            query(1, 0, n-1);
            for(int i = 0; i < n; i++) {
                out.print(res[i] + " ");
            }
            out.println();
        }
        f.close();
        out.close();
    }
}