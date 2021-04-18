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
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        parent = new int[3*N];
        size = new int[3*N];
        for(int i = 0; i < 3*N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int count = 0;
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(f.readLine());
            int D = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken())-1;
            int Y = Integer.parseInt(st.nextToken())-1;
            if(X >= N || Y >= N) {
                count++;
                continue;
            }
            if(D == 1) {
                if(root(X) == root(Y+N) || root(X) == root(Y+2*N)) {
                    count++;
                } else {
                    union(X, Y);
                    union(X+N, Y+N);
                    union(X+2*N, Y+2*N);
                }
            } else {
                if(root(X) == root(Y) || root(X) == root(Y+2*N)) {
                    count++;
                } else {
                    union(X, Y+N);
                    union(X+N, Y+2*N);
                    union(Y, X+2*N);
                }
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}