import java.io.*;
import java.util.*;

public class Main {
    private static int[] segmentTree;
    private static int[] lazy;
    private static void update(int idx, int left, int right, int curLeft, int curRight, int val) {
        if(curLeft > curRight) {
            return;
        }
        if(curLeft > right || curRight < left) {
            return;
        }
        if(curLeft >= left && curRight <= right) {
            segmentTree[idx] = val;
            lazy[idx] = val;
            return;
        }
        if(lazy[idx] > 0) {
            segmentTree[idx*2] = lazy[idx];
            lazy[idx*2] = lazy[idx];
            segmentTree[idx*2+1] = lazy[idx];
            lazy[idx*2+1] = lazy[idx];
            lazy[idx] = 0;
        }
        int curMid = (curLeft+curRight)/2;
        update(idx*2, left, right, curLeft, curMid, val);
        update(idx*2+1, left, right, curMid+1, curRight, val);
        segmentTree[idx] = segmentTree[idx*2] | segmentTree[idx*2+1];
    }
    private static int query(int idx, int left, int right, int curLeft, int curRight) {
        if(curLeft > curRight) {
            return 0;
        }
        if(curLeft > right || curRight < left) {
            return 0;
        }
        if(curLeft >= left && curRight <= right) {
            return segmentTree[idx];
        }
        if(lazy[idx] > 0) {
            segmentTree[idx*2] = lazy[idx];
            lazy[idx*2] = lazy[idx];
            segmentTree[idx*2+1] = lazy[idx];
            lazy[idx*2+1] = lazy[idx];
            lazy[idx] = 0;
        }
        int curMid = (curLeft+curRight)/2;
        return query(idx*2, left, right, curLeft, curMid) | query(idx*2+1, left, right, curMid+1, curRight);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int L = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int O = Integer.parseInt(st.nextToken());
        int size = 1;
        while(size < L) {
            size *= 2;
        }
        segmentTree = new int[2*size];
        lazy = new int[2*size];
        Arrays.fill(segmentTree, 1);
        for(int i = 0; i < O; i++) {
            st = new StringTokenizer(f.readLine());
            if(st.nextToken().equals("C")) {
                int A = Integer.parseInt(st.nextToken())-1;
                int B = Integer.parseInt(st.nextToken())-1;
                if(A > B) {
                    int temp = A;
                    A = B;
                    B = temp;
                }
                int C = Integer.parseInt(st.nextToken())-1;
                update(1, A, B, 0, L-1, 1 << C);
            } else {
                int A = Integer.parseInt(st.nextToken())-1;
                int B = Integer.parseInt(st.nextToken())-1;
                if(A > B) {
                    int temp = A;
                    A = B;
                    B = temp;
                }
                out.println(Integer.bitCount(query(1, A, B, 0, L-1)));
            }
        }
        f.close();
        out.close();
    }
}