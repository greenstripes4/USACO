import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static HashSet<Integer> cycle;
    private static boolean[] visited;
    private static int[] parent;
    private static int[] color;
    private static boolean dfs(int root) {
        if(visited[root]) {
            cycle.add(root);
            int temp = parent[root];
            while(root != temp) {
                cycle.add(temp);
                temp = parent[temp];
            }
            cycle.add(root);
            return true;
        }
        visited[root] = true;
        for(int i: adjacencyList.get(root)) {
            if(i != parent[root]) {
                parent[i] = root;
                if(dfs(i)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static void fill(int u, int p, int c) {
        color[u] = c;
        for(int v: adjacencyList.get(u)) {
            if(v != p && !cycle.contains(v)) {
                fill(v, u, c);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        cycle = new HashSet<>();
        visited = new boolean[N];
        parent = new int[N];
        dfs(0);
        color = new int[N];
        int c = 1;
        for(int root: cycle) {
            fill(root, -1, c++);
        }
        int Q = Integer.parseInt(f.readLine());
        while(Q-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            out.println(color[x] == color[y] ? "Yes" : "No");
        }
        f.close();
        out.close();
    }
}
