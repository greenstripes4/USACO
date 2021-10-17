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
        segmentTree[u] = Math.min(segmentTree[u*2], segmentTree[u*2+1]);
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
        segmentTree[u] = Math.min(segmentTree[u*2], segmentTree[u*2+1]);
    }
    private static int query(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return Integer.MAX_VALUE;
        }
        if(l >= ll && r <= rr) {
            return segmentTree[u];
        }
        int m = (l+r)/2;
        return Math.min(query(u*2, l, m, ll, rr), query(u*2+1, m+1, r, ll, rr));
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
        st = new StringTokenizer(f.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int size = 1;
        while(size < n) {
            size *= 2;
        }
        segmentTree = new int[2*size];
        build(1, 0, n-1);
        for(int i = 0; i < m; i++) {
            String temp = f.readLine();
            String[] idx = temp.substring(6, temp.length()-1).split(",");
            if(temp.charAt(0) == 'q') {
                int ll = Integer.parseInt(idx[0])-1;
                int rr = Integer.parseInt(idx[1])-1;
                out.println(query(1, 0, n-1, ll, rr));
            } else {
                int[] a = new int[idx.length];
                for(int j = 0; j < idx.length; j++) {
                    a[j] = Integer.parseInt(idx[j])-1;
                }
                int ttemp = arr[a[0]];
                for(int j = 0; j < idx.length-1; j++) {
                    update(1, 0, n-1, a[j], arr[a[j+1]]);
                    arr[a[j]] = arr[a[j+1]];
                }
                update(1, 0, n-1, a[idx.length-1], ttemp);
                arr[a[idx.length-1]] = ttemp;
            }
        }
        f.close();
        out.close();
    }
}
