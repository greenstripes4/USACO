import java.io.*;
import java.util.*;

public class Main{
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
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        while(true) {
            int N = f.nextInt();
            int R = f.nextInt();
            if(N == 0 && R == 0) {
                break;
            }
            int[][] roads = new int[R][3];
            for(int i = 0; i < R; i++) {
                roads[i][0] = f.nextInt();
                roads[i][1] = f.nextInt();
                roads[i][2] = f.nextInt();
            }
            Arrays.sort(roads, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return t1[2]-ints[2];
                }
            });
            parent = new int[N+1];
            size = new int[N+1];
            for(int i = 1; i <= N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            int S = f.nextInt();
            int D = f.nextInt();
            int T = f.nextInt();
            out.println("Scenario #" + t++);
            for(int[] i: roads) {
                union(i[0], i[1]);
                if(root(S) == root(D)) {
                    out.println("Minimum Number of Trips = " + (T+i[2]-2)/(i[2]-1));
                    break;
                }
            }
            out.println();
        }
        f.close();
        out.close();
    }
}