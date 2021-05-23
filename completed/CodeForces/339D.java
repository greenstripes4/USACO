import java.io.*;
import java.util.*;

public class Main {
    private static int[] segmentTree;
    private static int[] a;
    private static void build(int idx, int left, int right, boolean type) {
        if(left > right) {
            return;
        }
        if(left == right) {
            segmentTree[idx] = a[left];
            return;
        }
        int mid = (left+right)/2;
        build(idx*2, left, mid, !type);
        build(idx*2+1, mid+1, right, !type);
        segmentTree[idx] = type ? segmentTree[idx*2]|segmentTree[idx*2+1] : segmentTree[idx*2]^segmentTree[idx*2+1];
    }
    private static void update(int idx, int left, int right, int change, boolean type) {
        if(left > right) {
            return;
        }
        if(left > change || right < change) {
            return;
        }
        if(left == change && right == change) {
            segmentTree[idx] = a[change];
            return;
        }
        int mid = (left+right)/2;
        update(idx*2, left, mid, change, !type);
        update(idx*2+1, mid+1, right, change, !type);
        segmentTree[idx] = type ? segmentTree[idx*2]|segmentTree[idx*2+1] : segmentTree[idx*2]^segmentTree[idx*2+1];
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = f.nextInt();
        int m = f.nextInt();
        boolean type = n%2 == 1;
        n = 1 << n;
        segmentTree = new int[n << 1];
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = f.nextInt();
        }
        build(1, 0, n-1, type);
        for(int i = 0; i < m; i++) {
            int p = f.nextInt()-1;
            int b = f.nextInt();
            a[p] = b;
            update(1, 0, n-1, p, type);
            out.println(segmentTree[1]);
        }
        f.close();
        out.close();
    }
}