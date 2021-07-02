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
            int n = Integer.parseInt(f.readLine());
            char[] dir = f.readLine().toCharArray();
            parent = new int[2*n+2];
            size = new int[2*n+2];
            for(int i = 0; i < 2*n+2; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            for(int i = 0; i < n; i++) {
                if(dir[i] == 'L') {
                    union(i+1, n+i+1);
                } else {
                    union(i, n+i+2);
                }
            }
            int[] res = new int[n+1];
            for(int i = 0; i <= n; i++) {
                res[i] = size[root(i)];
            }
            out.print(res[0]);
            for(int i = 1; i <= n; i++) {
                out.print(" " + res[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}