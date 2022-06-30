import java.io.*;
import java.util.*;

public class Main {
    private static int n;
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
    private static boolean union(int u, int v) {
        int rootU = root(u);
        int rootV = root(v);
        if(rootU == rootV) {
            return false;
        }
        components--;
        if(size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
        return true;
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
    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static int[][] d;
    private static boolean dfs(int r, int u, int p, int dist) {
        if(dist != d[r][u]) {
            return false;
        }
        for(int[] v: adjacencyList.get(u)) {
            if(v[0] != p) {
                if(!dfs(r, v[0], u, dist+v[1])) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = Integer.parseInt(f.readLine());
        d = new int[n][n];
        ArrayList<int[]> arr = new ArrayList<>(n*n);
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++) {
                d[i][j] = Integer.parseInt(st.nextToken());
                arr.add(new int[]{i, j});
                if(i != j && d[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }
        if(flag) {
            out.println("NO");
        } else {
            Collections.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return d[o1[0]][o1[1]]-d[o2[0]][o2[1]];
                }
            });
            init(n);
            adjacencyList = new ArrayList<>(n);
            for(int i = 0; i < n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for(int i = 0; i < n*n && components > 1; i++) {
                if(union(arr.get(i)[0], arr.get(i)[1])) {
                    adjacencyList.get(arr.get(i)[0]).add(new int[]{arr.get(i)[1], d[arr.get(i)[0]][arr.get(i)[1]]});
                    adjacencyList.get(arr.get(i)[1]).add(new int[]{arr.get(i)[0], d[arr.get(i)[0]][arr.get(i)[1]]});
                }
            }
            for(int i = 0; i < n; i++) {
                if(!dfs(i, i, -1, 0)) {
                    flag = true;
                    break;
                }
            }
            out.println(flag ? "NO" : "YES");
        }
        f.close();
        out.close();
    }
}