import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;

    private static int[][] adjacencyMatrix;
    private static long[][][] floydWarshall() {
        long[][][] distance = new long[n+1][n+1][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(adjacencyMatrix[i][j] < Integer.MAX_VALUE) {
                    distance[i][j][0] = adjacencyMatrix[i][j];
                } else {
                    distance[i][j][0] = Long.MAX_VALUE/2;
                }
                distance[i][j][1] = Long.MAX_VALUE/2;
            }
        }
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(distance[i][k][0]+distance[k][j][0] < distance[i][j][0]) {
                        distance[i][j][1] = distance[i][j][0];
                        distance[i][j][0] = distance[i][k][0]+distance[k][j][0];
                    } else if(distance[i][k][0]+distance[k][j][0] < distance[i][j][1]) {
                        distance[i][j][1] = distance[i][k][0]+distance[k][j][0];
                    }
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            adjacencyMatrix = new int[n][n];
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                adjacencyMatrix[u][v] = d;
                adjacencyMatrix[v][u] = d;
            }
            out.println("Set #" + t++);
            long[][][] res = floydWarshall();
            int q = Integer.parseInt(f.readLine());
            for(int i = 0; i < q; i++) {
                st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                out.println(res[u][v][1] == Long.MAX_VALUE/2 ? "?" : res[u][v][1]);
            }
            f.readLine();
        }
        f.close();
        out.close();
    }
}
