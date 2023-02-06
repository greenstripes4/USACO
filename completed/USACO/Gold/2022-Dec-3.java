import java.io.*;
import java.util.*;

public class Main {
    private static int N;
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
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] degree = new int[N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        for(int i = 0; i < N; i++) {
            set.add(new int[]{degree[i], i});
        }
        Stack<Integer> order = new Stack<>();
        Stack<Integer> min = new Stack<>();
        for(int i = 0; i < N; i++) {
            int[] cur = set.pollFirst();
            min.push(cur[0]);
            order.push(cur[1]);
            for(int j: adjacencyList.get(cur[1])) {
                if(set.contains(new int[]{degree[j], j})) {
                    set.remove(new int[]{degree[j], j});
                    degree[j]--;
                    set.add(new int[]{degree[j], j});
                }
            }
        }
        init();
        boolean[] added = new boolean[N];
        long max = 0;
        while(!order.isEmpty()) {
            int u = order.pop();
            added[u] = true;
            for(int v: adjacencyList.get(u)) {
                if(added[v]) {
                    union(u, v);
                }
            }
            max = Math.max(max, (long) size[root(u)]*min.pop());
        }
        out.println(max);
        f.close();
        out.close();
    }
}
