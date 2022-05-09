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
    private static int dist(int[] a, int[] b) {
        int dx = a[0]-b[0];
        int dy = a[1]-b[1];
        return dx*dx+dy*dy;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] points = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        long low = 0;
        long high = Integer.MAX_VALUE;
        long ans = high;
        while(low <= high) {
            long mid = (low+high)/2;
            parent = new int[N];
            size = new int[N];
            components = N;
            for(int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    if(dist(points[i], points[j]) <= mid) {
                        union(i, j);
                    }
                }
            }
            if(components == 1) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
