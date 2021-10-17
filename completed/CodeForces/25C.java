import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] adjacencyMatrix;

    private static long[][] floydWarshall() {
        long[][] distance = new long[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(adjacencyMatrix[i][j] < Integer.MAX_VALUE) {
                    distance[i][j] = adjacencyMatrix[i][j];
                } else {
                    distance[i][j] = Long.MAX_VALUE/2;
                }
            }
        }
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(distance[i][k]+distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k]+distance[k][j];
                    }
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = Integer.parseInt(f.readLine());
        adjacencyMatrix = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 1; j <= n; j++) {
                adjacencyMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] distance = floydWarshall();
        int k = Integer.parseInt(f.readLine());
        long[] res = new long[k];
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            long ans = 0;
            for(int j = 1; j <= n; j++) {
                for(int l = 1; l <= n; l++) {
                    distance[j][l] = Math.min(distance[j][l], distance[j][u]+c+distance[v][l]);
                    distance[j][l] = Math.min(distance[j][l], distance[j][v]+c+distance[u][l]);
                    ans += distance[j][l];
                }
            }
            res[i] = ans/2;
        }
        out.print(res[0]);
        for(int i = 1; i < k; i++) {
            out.print(" " + res[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}
