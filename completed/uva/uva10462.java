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
    private static int buildMST(int[][] edges, int invalid, int v) {
        parent = new int[v];
        size = new int[v];
        for(int i = 0; i < v; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int total = 0;
        int cost = 0;
        for(int i = 0; i < edges.length; i++) {
            if(i == invalid) {
                continue;
            }
            if(root(edges[i][0]) != root(edges[i][1])) {
                union(edges[i][0], edges[i][1]);
                total++;
                cost += edges[i][2];
            }
        }
        if(total < v-1) {
            return -1;
        }
        return cost;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int[][] edges = new int[e][3];
            for(int i = 0; i < e; i++) {
                st = new StringTokenizer(f.readLine());
                edges[i][0] = Integer.parseInt(st.nextToken())-1;
                edges[i][1] = Integer.parseInt(st.nextToken())-1;
                edges[i][2] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(edges, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[2]-t1[2];
                }
            });
            parent = new int[v];
            size = new int[v];
            for(int i = 0; i < v; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            boolean[] used = new boolean[e];
            int total = 0;
            for(int i = 0; i < e; i++) {
                if(root(edges[i][0]) != root(edges[i][1])) {
                    union(edges[i][0], edges[i][1]);
                    used[i] = true;
                    total++;
                }
            }
            if(total < v-1) {
                out.println("Case #" + t + " : No way");
            } else {
                int min = -1;
                for(int i = 0; i < e; i++) {
                    if(used[i]) {
                        int cur = buildMST(edges, i, v);
                        if(cur >= 0 && (min < 0 || cur < min)) {
                            min = cur;
                        }
                    }
                }
                if(min < 0) {
                    out.println("Case #" + t + " : No second way");
                } else {
                    out.println("Case #" + t + " : " + min);
                }
            }
        }
        f.close();
        out.close();
    }
}
