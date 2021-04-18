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
    private static int distance(int[] a, int[] b) {
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        d *= d;
        int[][] points = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        parent = new int[N];
        size = new int[N];
        Arrays.fill(parent, -1);
        String input;
        while((input = f.readLine()) != null) {
            st = new StringTokenizer(input);
            if(st.nextToken().equals("O")) {
                int p = Integer.parseInt(st.nextToken())-1;
                parent[p] = p;
                size[p] = 1;
                for(int i = 0; i < N; i++) {
                    if(parent[i] >= 0 && distance(points[p], points[i]) <= d) {
                        union(p, i);
                    }
                }
            } else {
                int p = Integer.parseInt(st.nextToken())-1;
                int q = Integer.parseInt(st.nextToken())-1;
                if(parent[p] >= 0 && parent[q] >= 0 && root(p) == root(q)) {
                    out.println("SUCCESS");
                } else {
                    out.println("FAIL");
                }
            }
        }
        f.close();
        out.close();
    }
}