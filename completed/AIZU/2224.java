import java.io.*;
import java.util.*;

public class Main {
    private static class Edge implements Comparable<Edge> {
        private int p1;
        private int p2;
        private double d;
        private Edge(int p1, int p2, double d) {
            this.p1 = p1;
            this.p2 = p2;
            this.d = d;
        }
        @Override
        public int compareTo(Edge o) {
            return Double.compare(o.d, d);
        }
    }
    private static int n;
    private static Edge[] edges;
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
    private static double kruskals() {
        Arrays.sort(edges);
        parent = new int[n+1];
        size = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        double ans = 0;
        for(Edge i: edges) {
            if(root(i.p1) != root(i.p2)) {
                union(i.p1, i.p2);
                ans += i.d;
            }
        }
        return ans;
    }
    private static double dist(int[] a, int[] b) {
        int dx = Math.abs(a[0]-b[0]);
        int dy = Math.abs(a[1]-b[1]);
        return Math.sqrt(dx*dx+dy*dy);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = f.nextInt();
        int m = f.nextInt();
        int[][] points = new int[n][2];
        for(int i = 0; i < n; i++) {
            points[i][0] = f.nextInt();
            points[i][1] = f.nextInt();
        }
        edges = new Edge[m];
        double total = 0;
        for(int i = 0; i < m; i++) {
            int p1 = f.nextInt();
            int p2 = f.nextInt();
            double d = dist(points[p1-1], points[p2-1]);
            edges[i] = new Edge(p1, p2, d);
            total += d;
        }
        out.println(total-kruskals());
        f.close();
        out.close();
    }
}