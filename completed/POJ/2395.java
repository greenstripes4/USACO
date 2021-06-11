import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] edges;
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
    private static int kruskals() {
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[2]-t1[2];
            }
        });
        parent = new int[n+1];
        size = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int ans = 0;
        for(int[] i: edges) {
            if(root(i[0]) != root(i[1])) {
                union(i[0], i[1]);
                ans = i[2];
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = f.nextInt();
        int m = f.nextInt();
        edges = new int[m][3];
        for(int i = 0; i < m; i++) {
            edges[i][0] = f.nextInt();
            edges[i][1] = f.nextInt();
            edges[i][2] = f.nextInt();
        }
        out.println(kruskals());
        f.close();
        out.close();
    }
}