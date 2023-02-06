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
    private static void init(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    private static long distance(int[] p1, int[] p2) {
        long dx = p1[0]-p2[0];
        long dy = p1[1]-p2[1];
        return dx*dx+dy*dy;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[][] points = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        ArrayList<long[]> edges = new ArrayList<>();
        int[] prev = new int[11];
        Arrays.fill(prev, -1);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= 10; j++) {
                if(prev[j] >= 0) {
                    edges.add(new long[]{i, prev[j], distance(points[i], points[prev[j]])});
                }
            }
            prev[points[i][1]] = i;
        }
        Collections.sort(edges, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[2], o2[2]);
            }
        });
        init(N);
        long ans = 0;
        for(long[] i: edges) {
            if(union((int) i[0], (int) i[1])) {
                ans += i[2];
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
