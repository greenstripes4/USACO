import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static int[] size;
    private static ArrayList<Integer>[] cells;
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
            cells[rootV].addAll(cells[rootU]);
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
            cells[rootU].addAll(cells[rootV]);
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        parent = new int[n+1];
        size = new int[n+1];
        cells = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
            cells[i] = new ArrayList<>();
            cells[i].add(i);
        }
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> ans = cells[root(1)];
        out.print(ans.get(0));
        for(int i = 1; i < n; i++) {
            out.print(" " + ans.get(i));
        }
        out.println();
        f.close();
        out.close();
    }
}