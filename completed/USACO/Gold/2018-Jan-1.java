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
    private static void init(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mootube.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[][] edges = new int[N-1][3];
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(f.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken())-1;
            edges[i][1] = Integer.parseInt(st.nextToken())-1;
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2]-o1[2];
            }
        });
        int[][] queries = new int[Q][3];
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken())-1;
            queries[i][2] = i;
        }
        Arrays.sort(queries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        init(N);
        int[] res = new int[Q];
        int idx = 0;
        for(int[] i: queries) {
            while(idx < N-1 && edges[idx][2] >= i[0]) {
                union(edges[idx][0], edges[idx][1]);
                idx++;
            }
            res[i[2]] = size[root(i[1])]-1;
        }
        for(int i: res) {
            out.println(i);
        }
        init(N);
        f.close();
        out.close();
    }
}