import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static ArrayList<int[]> edges;
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
        Collections.sort(edges, new Comparator<int[]>() {
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
                ans += i[2];
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
        while(f.hasNext()) {
            n = f.nextInt();
            edges = new ArrayList<int[]>();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int w = f.nextInt();
                    edges.add(new int[]{i+1, j+1, w});
                }
            }
            out.println(kruskals());
        }
        f.close();
        out.close();
    }
}