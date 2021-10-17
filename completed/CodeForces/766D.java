import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static int[] size;
    private static int root(int u) {
        while(u != parent[u]) {
            parent[u] = parent[parent[u]];
            u = parent[u];
        }
        return u;
    }
    private static void union(int u, int v) {
        int rootU = root(u);
        int rootV = root(v);
        if(rootU == rootV) {
            return;
        }
        if(size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            map.put(st.nextToken(), i);
        }
        parent = new int[2*n];
        size = new int[2*n];
        for(int i = 0; i < 2*n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int t = Integer.parseInt(st.nextToken());
            int u = map.get(st.nextToken());
            int v = map.get(st.nextToken());
            if(t == 1) {
                if(root(u) == root(v+n)) {
                    out.println("NO");
                } else {
                    out.println("YES");
                    union(u, v);
                    union(u+n, v+n);
                }
            } else {
                if(root(u) == root(v)) {
                    out.println("NO");
                } else {
                    out.println("YES");
                    union(u, v+n);
                    union(u+n, v);
                }
            }
        }
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int u = map.get(st.nextToken());
            int v = map.get(st.nextToken());
            if(root(u) == root(v)) {
                out.println(1);
            } else if(root(u) == root(v+n)) {
                out.println(2);
            } else {
                out.println(3);
            }
        }
        f.close();
        out.close();
    }
}
