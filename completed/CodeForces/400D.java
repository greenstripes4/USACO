import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] adjacencyMatrix;
    private static long[][] floydWarshall() {
        long[][] distance = new long[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(adjacencyMatrix[i][j] < Integer.MAX_VALUE) {
                    distance[i][j] = adjacencyMatrix[i][j];
                } else {
                    distance[i][j] = Long.MAX_VALUE/2;
                }
            }
        }
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(distance[i][k]+distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k]+distance[k][j];
                    }
                }
            }
        }
        return distance;
    }
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
        int n1 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] c = new int[n];
        for(int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        int[] type = new int[n1];
        int id = 1;
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < c[i]; j++) {
                type[idx++] = id;
            }
            id++;
        }
        parent = new int[n1];
        size = new int[n1];
        for(int i = 0; i < n1; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        adjacencyMatrix = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                adjacencyMatrix[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken());
            adjacencyMatrix[type[u]][type[v]] = Math.min(adjacencyMatrix[type[u]][type[v]], x);
            adjacencyMatrix[type[v]][type[u]] = Math.min(adjacencyMatrix[type[v]][type[u]], x);
            if(x == 0) {
                union(u, v);
            }
        }
        boolean flag = false;
        for(int i = 0; i < n1;) {
            int j = i+1;
            while(j < n1 && type[j] == type[i]) {
                j++;
            }
            for(int k = i; k < j; k++) {
                if(root(k) != root(i)) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
            i = j;
        }
        if(flag) {
            out.println("No");
        } else {
            out.println("Yes");
            long[][] res = floydWarshall();
            for(int i = 1; i <= n; i++) {
                out.print(res[i][1] == Long.MAX_VALUE/2 ? -1 : res[i][1]);
                for(int j = 2; j <= n; j++) {
                    out.print(" " + (res[i][j] == Long.MAX_VALUE/2 ? -1 : res[i][j]));
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}