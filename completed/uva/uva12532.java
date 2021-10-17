import java.io.*;
import java.util.*;

public class Main {
    private static int[] segmentTree;
    private static int[] arr;
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
        segmentTree[u] = segmentTree[u*2]*segmentTree[u*2+1];
    }
    private static void update(int u, int l, int r, int i, int v) {
        if(l > i || r < i) {
            return;
        }
        if(l == r) {
            segmentTree[u] = v;
            return;
        }
        int m = (l+r)/2;
        update(u*2, l, m, i, v);
        update(u*2+1, m+1, r, i, v);
        segmentTree[u] = segmentTree[u*2]*segmentTree[u*2+1];
    }
    private static int query(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return 1;
        }
        if(l >= ll && r <= rr) {
            return segmentTree[u];
        }
        int m = (l+r)/2;
        return query(u*2, l, m, ll, rr)*query(u*2+1, m+1, r, ll, rr);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.compare(Integer.parseInt(st.nextToken()), 0);
            }
            int size = 1;
            while(size < N) {
                size *= 2;
            }
            segmentTree = new int[2*size];
            build(1, 0, N-1);
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(f.readLine());
                if(st.nextToken().equals("P")) {
                    int l = Integer.parseInt(st.nextToken())-1;
                    int r = Integer.parseInt(st.nextToken())-1;
                    int temp = query(1, 0, N-1, l, r);
                    out.print(temp < 0 ? "-" : temp > 0 ? "+" : 0);
                } else {
                    int I = Integer.parseInt(st.nextToken())-1;
                    int v = Integer.compare(Integer.parseInt(st.nextToken()), 0);
                    update(1, 0, N-1, I, v);
                }
            }
            out.println();
        }
        f.close();
        out.close();
    }
}