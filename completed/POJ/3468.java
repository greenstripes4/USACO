import java.io.*;
import java.util.*;

public class Main {
    private static long[] segmentTree;
    private static long[] lazy;
    private static int[] length;
    private static void build(long[] arr, int idx, int left, int right) {
        if(left > right) {
            return;
        }
        if(left == right) {
            segmentTree[idx] = arr[left];
            length[idx] = 1;
            return;
        }
        int mid = (left+right)/2;
        build(arr, idx*2, left, mid);
        build(arr, idx*2+1, mid+1, right);
        segmentTree[idx] = segmentTree[idx*2]+segmentTree[idx*2+1];
        length[idx] = right-left+1;
    }
    private static void update(int idx, int left, int right, int rangeLeft, int rangeRight, long add) {
        if(left > right) {
            return;
        }
        if(left > rangeRight || right < rangeLeft) {
            return;
        }
        if(left >= rangeLeft && right <= rangeRight) {
            segmentTree[idx] += add*length[idx];
            lazy[idx] += add;
            return;
        }
        if(lazy[idx] != 0) {
            segmentTree[idx*2] += lazy[idx]*length[idx*2];
            lazy[idx*2] += lazy[idx];
            segmentTree[idx*2+1] += lazy[idx]*length[idx*2+1];
            lazy[idx*2+1] += lazy[idx];
            lazy[idx] = 0;
        }
        int mid = (left+right)/2;
        update(idx*2, left, mid, rangeLeft, rangeRight, add);
        update(idx*2+1, mid+1, right, rangeLeft, rangeRight, add);
        segmentTree[idx] = segmentTree[idx*2]+segmentTree[idx*2+1];
    }
    private static long query(int idx, int left, int right, int rangeLeft, int rangeRight) {
        if(left > right) {
            return 0;
        }
        if(left > rangeRight || right < rangeLeft) {
            return 0;
        }
        if(left >= rangeLeft && right <= rangeRight) {
            return segmentTree[idx];
        }
        if(lazy[idx] != 0) {
            segmentTree[idx*2] += lazy[idx]*length[idx*2];
            lazy[idx*2] += lazy[idx];
            segmentTree[idx*2+1] += lazy[idx]*length[idx*2+1];
            lazy[idx*2+1] += lazy[idx];
            lazy[idx] = 0;
        }
        int mid = (left+right)/2;
        return query(idx*2, left, mid, rangeLeft, rangeRight)+query(idx*2+1, mid+1, right, rangeLeft, rangeRight);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        long[] arr = new long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int size = 1;
        while(size < N) {
            size *= 2;
        }
        segmentTree = new long[2*size];
        lazy = new long[2*size];
        length = new int[2*size];
        build(arr, 1, 0, N-1);
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            if(st.nextToken().equals("C")) {
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                long c = Long.parseLong(st.nextToken());
                update(1, 0, N-1, a, b, c);
            } else {
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                out.println(query(1, 0, N-1, a, b));
            }
        }
        f.close();
        out.close();
    }
}