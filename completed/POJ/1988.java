import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static int[] size;
    private static int[] above;
    private static int root(int u) {
        if(u != parent[u]) {
            int v = root(parent[u]);
            above[u] += above[parent[u]];
            parent[u] = v;
        }
        return parent[u];
    }
    private static void union(int u, int v) {
        int rootU = root(u);
        int rootV = root(v);
        parent[rootV] = rootU;
        above[rootV] += size[rootU];
        size[rootU] += size[rootV];
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int P = f.nextInt();
        parent = new int[P+1];
        size = new int[P+1];
        above = new int[P+1];
        for(int i = 1; i <= P; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        while(f.hasNext()) {
            if(f.next().equals("M")) {
                union(f.nextInt(), f.nextInt());
            } else {
                int u = f.nextInt();
                out.println(size[root(u)]-above[u]-1);
            }
        }
        f.close();
        out.close();
    }
}