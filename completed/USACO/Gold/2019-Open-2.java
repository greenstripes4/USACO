import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static int[] size;
    private static int components;
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
        components--;
        if(size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
    }
    private static void init(int n) {
        parent = new int[n];
        size = new int[n];
        components = n;
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("walk.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("walk.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] edges = new int[N*(N-1)/2][3];
        int idx = 0;
        for(int x = 1; x <= N; x++) {
            for(int y = x+1; y <= N; y++) {
                edges[idx++] = new int[]{x, y, (int) ((2019201913L*x+2019201949L*y)%2019201997)};
            }
        }
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        init(N+1);
        int i = 0;
        while(i < idx && components >= K+1) {
            union(edges[i][0], edges[i][1]);
            i++;
        }
        out.println(edges[i-1][2]);
        f.close();
        out.close();
    }
}