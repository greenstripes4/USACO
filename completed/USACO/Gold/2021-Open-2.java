import java.io.*;
import java.util.*;

public class Main {
    private static int N;
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
    private static boolean union(int u, int v) {
        int rootU = root(u);
        int rootV = root(v);
        if(rootU == rootV) {
            return false;
        }
        if(size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
        return true;
    }
    private static void init() {
        parent = new int[N];
        size = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    private static int[][] kruskal() {
        int[][] mst = new int[N-1][3];
        init();
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int idx = 0;
        for(int[] i: edges) {
            if(union(i[0], i[1])) {
                mst[idx][0] = i[0];
                mst[idx][1] = i[1];
                mst[idx][2] = i[2];
                idx++;
            }
        }
        return mst;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        N = 2*Integer.parseInt(f.readLine());
        edges = new int[3*N][3];
        for(int i = 0; i < N/2; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken())-1;
            int p2 = Integer.parseInt(st.nextToken())-1;
            int p3 = Integer.parseInt(st.nextToken())-1;
            int p4 = Integer.parseInt(st.nextToken())-1;
            edges[i*3][0] = p1;
            edges[i*3][1] = p2;
            edges[i*3+1][0] = p3;
            edges[i*3+1][1] = p4;
            edges[i*3+2][0] = p1;
            edges[i*3+2][1] = p3;
            edges[i*3+2][2] = c;
        }
        int[][] mst = kruskal();
        int ans = 0;
        for(int[] i: mst) {
            ans += i[2];
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
