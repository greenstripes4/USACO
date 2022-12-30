import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] segmentTree;
    private static int[] arr;
    private static int ceil(ArrayList<Integer> arr, int tar) {
        int low = 0;
        int high = arr.size()-1;
        int ans = arr.size();
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid) >= tar) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    private static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> c = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < a.size() || j < b.size()) {
            if(i == a.size()) {
                c.add(b.get(j++));
            } else if(j == b.size()) {
                c.add(a.get(i++));
            } else if(a.get(i) < b.get(j)) {
                c.add(a.get(i++));
            } else {
                c.add(b.get(j++));
            }
        }
        return c;
    }
    private static void build(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(l == r) {
            segmentTree[u] = new ArrayList<>();
            segmentTree[u].add(arr[l]);
            return;
        }
        int m = (l+r)/2;
        build(u*2, l, m);
        build(u*2+1, m+1, r);
        segmentTree[u] = merge(segmentTree[u*2], segmentTree[u*2+1]);
    }
    private static int query(int u, int l, int r, int ll, int rr, int v) {
        if(l > r || l > rr || r < ll) {
            return 0;
        }
        if(l >= ll && r <= rr) {
            return ceil(segmentTree[u], v);
        }
        int m = (l+r)/2;
        return query(u*2, l, m, ll, rr, v)+query(u*2+1, m+1, r, ll, rr, v);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] b = new int[N];
        for(int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        int[] idx = new int[N+1];
        Arrays.fill(idx, N);
        int[] next = new int[N];
        for(int i = N-1; i >= 0; i--) {
            next[i] = idx[b[i]];
            idx[b[i]] = i;
        }
        Arrays.fill(idx, -1);
        int[] prev = new int[N];
        for(int i = 0; i < N; i++) {
            prev[i] = idx[b[i]];
            idx[b[i]] = i;
        }
        arr = prev;
        int size = 1;
        while(size < N) {
            size *= 2;
        }
        segmentTree = new ArrayList[2*size];
        build(1, 0, N-1);
        long ans = 0;
        for(int i = 0; i < N; i++) {
            ans += query(1, 0, N-1, i+1, next[i]-1, i);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}