import java.io.*;
import java.util.*;

public class Main {
    private static int[] segmentTree1;
    private static int[] segmentTree2;
    private static int[] arr;
    private static void build1(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(l == r) {
            segmentTree1[u] = arr[l];
            return;
        }
        int m = (l+r)/2;
        build1(u*2, l, m);
        build1(u*2+1, m+1, r);
        segmentTree1[u] = Math.min(segmentTree1[u*2], segmentTree1[u*2+1]);
    }
    private static int query1(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return Integer.MAX_VALUE;
        }
        if(l >= ll && r <= rr) {
            return segmentTree1[u];
        }
        int m = (l+r)/2;
        return Math.min(query1(u*2, l, m, ll, rr), query1(u*2+1, m+1, r, ll, rr));
    }
    private static void build2(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(l == r) {
            segmentTree2[u] = arr[l];
            return;
        }
        int m = (l+r)/2;
        build2(u*2, l, m);
        build2(u*2+1, m+1, r);
        segmentTree2[u] = Math.max(segmentTree2[u*2], segmentTree2[u*2+1]);
    }
    private static int query2(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return Integer.MIN_VALUE;
        }
        if(l >= ll && r <= rr) {
            return segmentTree2[u];
        }
        int m = (l+r)/2;
        return Math.max(query2(u*2, l, m, ll, rr), query2(u*2+1, m+1, r, ll, rr));
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("beads.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int size = 1;
        while(size < N) {
            size *= 2;
        }
        segmentTree1 = new int[2*size];
        segmentTree2 = new int[2*size];
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(f.readLine());
        }
        build1(1, 0, N-1);
        build2(1, 0, N-1);
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            out.println(query2(1, 0, N-1, A, B)-query1(1, 0, N-1, A, B));
        }
        f.close();
        out.close();
    }
}
