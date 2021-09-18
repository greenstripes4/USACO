import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<int[]>> adjacencyList;
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
    private static int dfs(int u, int p, int v, int max) {
        if(u == v) {
            return max;
        }
        for(int[] e: adjacencyList.get(u)) {
            if(e[0] != p) {
                int temp = dfs(e[0], u, v, Math.max(max, e[1]));
                if(temp >= 0) {
                    return temp;
                }
            }
        }
        return -1;
    }
    private static int distance(int x1, int y1, int x2, int y2) {
        int dx = x1-x2;
        int dy = y1-y2;
        return dx*dx+dy*dy;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        while(true) {
            int n = f.nextInt();
            if(n == 0) {
                break;
            }
            int[][] points = new int[n][2];
            for(int i = 0; i < n; i++) {
                points[i][0] = f.nextInt();
                points[i][1] = f.nextInt();
            }
            int[][] edges = new int[n*(n-1)/2][3];
            int idx = 0;
            for(int i = 0; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    edges[idx][0] = i;
                    edges[idx][1] = j;
                    edges[idx++][2] = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                }
            }
            Arrays.sort(edges, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[2]-t1[2];
                }
            });
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            adjacencyList = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for(int[] i: edges) {
                if(root(i[0]) != root(i[1])) {
                    union(i[0], i[1]);
                    adjacencyList.get(i[0]).add(new int[]{i[1], i[2]});
                    adjacencyList.get(i[1]).add(new int[]{i[0], i[2]});
                }
            }
            out.println("Scenario #" + t++);
            out.print("Frog Distance = ");
            out.printf("%.3f\n", Math.sqrt(dfs(0, -1, 1, 0)));
            out.println();
        }
        f.close();
        out.close();
    }
}