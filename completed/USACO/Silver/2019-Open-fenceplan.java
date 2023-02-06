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
                BufferedReader f = new BufferedReader(new FileReader("fenceplan.in"));
                //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                StringTokenizer st = new StringTokenizer(f.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());
                int[][] points = new int[N][2];
                parent = new int[N];
                size = new int[N];
                for(int i = 0; i < N; i++) {
                        st = new StringTokenizer(f.readLine());
                        points[i][0] = Integer.parseInt(st.nextToken());
                        points[i][1] = Integer.parseInt(st.nextToken());
                        parent[i] = i;
                        size[i] = 1;
                }
                for(int i = 0; i < M; i++) {
                        st = new StringTokenizer(f.readLine());
                        int u = Integer.parseInt(st.nextToken())-1;
                        int v = Integer.parseInt(st.nextToken())-1;
                        union(u, v);
                }
                int[][] rectangle = new int[N][4];
                for(int i = 0; i < N; i++) {
                        rectangle[i][0] = Integer.MAX_VALUE;
                        rectangle[i][1] = Integer.MIN_VALUE;
                        rectangle[i][2] = Integer.MAX_VALUE;
                        rectangle[i][3] = Integer.MIN_VALUE;
                }
                for(int i = 0; i < N; i++) {
                        int r = root(i);
                        rectangle[r][0] = Math.min(rectangle[r][0], points[i][0]);
                        rectangle[r][1] = Math.max(rectangle[r][1], points[i][0]);
                        rectangle[r][2] = Math.min(rectangle[r][2], points[i][1]);
                        rectangle[r][3] = Math.max(rectangle[r][3], points[i][1]);
                }
                int min = Integer.MAX_VALUE;
                for(int i = 0; i < N; i++) {
                        if(rectangle[i][0] < Integer.MAX_VALUE) {
                                min = Math.min(min, 2*(rectangle[i][1]-rectangle[i][0]+rectangle[i][3]-rectangle[i][2]));
                        }
                }
                out.println(min);
                f.close();
                out.close();
    }
}
