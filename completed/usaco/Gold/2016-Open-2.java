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
        components = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("closing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        int[] order = new int[N];
        for(int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(f.readLine())-1;
        }
        init(N);
        boolean[] added = new boolean[N];
        Stack<String> res = new Stack<>();
        for(int i = N-1; i >= 0; i--) {
            added[order[i]] = true;
            for(int j: adjacencyList.get(order[i])) {
                if(added[j]) {
                    union(order[i], j);
                }
            }
            res.push(components == i+1 ? "YES" : "NO");
        }
        while(!res.isEmpty()) {
            out.println(res.pop());
        }
        f.close();
        out.close();
    }
}