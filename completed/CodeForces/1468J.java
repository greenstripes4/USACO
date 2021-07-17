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
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] edges = new int[m][3];
            int cost = Integer.MAX_VALUE;
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                edges[i][0] = Integer.parseInt(st.nextToken());
                edges[i][1] = Integer.parseInt(st.nextToken());
                edges[i][2] = Integer.parseInt(st.nextToken());
                if(Math.abs(k-edges[i][2]) < cost) {
                    cost = Math.abs(k-edges[i][2]);
                }
            }
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
            long total = 0;
            for(int[] i: edges) {
                if(root(i[0]) != root(i[1])) {
                    union(i[0], i[1]);
                    if(i[2] > k) {
                        total += i[2]-k;
                    }
                }
            }
            out.println(total == 0 ? cost : total);
        }
        f.close();
        out.close();
    }
}