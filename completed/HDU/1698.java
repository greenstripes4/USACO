import java.io.*;
import java.util.*;

public class Main {
    private static int[] segmentTree;
    private static int[] lazy;
    private static int[] length;
    private static void build(int idx, int left, int right) {
        if(left > right) {
            return;
        }
        if(left == right) {
            segmentTree[idx] = 1;
            length[idx] = 1;
            return;
        }
        int mid = (left+right)/2;
        build(idx*2, left, mid);
        build(idx*2+1, mid+1, right);
        segmentTree[idx] = segmentTree[idx*2]+segmentTree[idx*2+1];
        length[idx] = right-left+1;
    }
    private static void update(int idx, int left, int right, int curLeft, int curRight, int val) {
        if(curLeft > curRight) {
            return;
        }
        if(curLeft > right || curRight < left) {
            return;
        }
        if(curLeft >= left && curRight <= right) {
            segmentTree[idx] = val*length[idx];
            lazy[idx] = val;
            return;
        }
        if(lazy[idx] > 0) {
            segmentTree[idx*2] = lazy[idx]*length[idx*2];
            lazy[idx*2] = lazy[idx];
            segmentTree[idx*2+1] = lazy[idx]*length[idx*2+1];
            lazy[idx*2+1] = lazy[idx];
            lazy[idx] = 0;
        }
        int curMid = (curLeft+curRight)/2;
        update(idx*2, left, right, curLeft, curMid, val);
        update(idx*2+1, left, right, curMid+1, curRight, val);
        segmentTree[idx] = segmentTree[idx*2]+segmentTree[idx*2+1];
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(f.readLine());
            int size = 1;
            while(size < N) {
                size *= 2;
            }
            segmentTree = new int[2*size];
            lazy = new int[2*size];
            length = new int[2*size];
            build(1, 0, N-1);
            int Q = Integer.parseInt(f.readLine());
            for(int i = 0; i < Q; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int left = Integer.parseInt(st.nextToken())-1;
                int right = Integer.parseInt(st.nextToken())-1;
                int val = Integer.parseInt(st.nextToken());
                update(1, left, right, 0, N-1, val);
            }
            out.println("Case " + t + ": The total value of the hook is " + segmentTree[1] + ".");
        }
        f.close();
        out.close();
    }
}