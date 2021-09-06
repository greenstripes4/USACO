import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][][] adjacencyMatrix;
    private static long[][][] floydWarshall() {
        long[][][] distance = new long[n+1][n+1][2];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(adjacencyMatrix[i][j][0] < Integer.MAX_VALUE) {
                    distance[i][j][0] = adjacencyMatrix[i][j][0];
                    distance[i][j][1] = adjacencyMatrix[i][j][1];
                } else {
                    distance[i][j][0] = Long.MAX_VALUE/2;
                    distance[i][j][1] = Long.MAX_VALUE/2;
                }
            }
        }
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(distance[i][k][0]+distance[k][j][0] < distance[i][j][0] ||
                            (distance[i][k][0]+distance[k][j][0] == distance[i][j][0] &&
                                    distance[i][k][1]+distance[k][j][1] < distance[i][j][1])) {
                        distance[i][j][0] = distance[i][k][0]+distance[k][j][0];
                        distance[i][j][1] = distance[i][k][1]+distance[k][j][1];
                    }
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adjacencyMatrix = new int[n+1][n+1][2];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i != j) {
                        adjacencyMatrix[i][j][0] = Integer.MAX_VALUE;
                        adjacencyMatrix[i][j][1] = Integer.MAX_VALUE;
                    }
                }
            }
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                if(adjacencyMatrix[u][v][0] == Integer.MAX_VALUE || (time < adjacencyMatrix[u][v][0] || (
                        time == adjacencyMatrix[u][v][0] && dist < adjacencyMatrix[u][v][1]
                        ))) {
                    adjacencyMatrix[u][v][0] = time;
                    adjacencyMatrix[u][v][1] = dist;
                    adjacencyMatrix[v][u][0] = time;
                    adjacencyMatrix[v][u][1] = dist;
                }
            }
            long[][][] res = floydWarshall();
            int q = Integer.parseInt(f.readLine());
            while(q-- > 0) {
                st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if(res[u][v][0] == Long.MAX_VALUE/2) {
                    out.println("No Path.");
                } else {
                    out.println("Distance and time to reach destination is " + res[u][v][1] + " & " + res[u][v][0] + ".");
                }
            }
            if(t > 0) {
                out.println();
            }
        }
        f.close();
        out.close();
    }
}