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
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parent = new int[2*N+1];
            size = new int[2*N+1];
            for(int i = 1; i <= 2*N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(f.readLine());
                char op = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(op == 'D') {
                    union(a, b+N);
                    union(b, a+N);
                } else {
                    if(root(a) == root(b)) {
                        out.println("In the same gang.");
                    } else if(root(a) == root(b+N)) {
                        out.println("In different gangs.");
                    } else {
                        out.println("Not sure yet.");
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}