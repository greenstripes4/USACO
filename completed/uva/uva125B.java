import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] adjacencyMatrix;
    private static long[][] floydWarshall() {
        long[][] ways = new long[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                ways[i][j] = adjacencyMatrix[i][j];
            }
        }
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    ways[i][j] += ways[i][k]*ways[k][j];
                }
            }
        }
        for(int k = 1; k <= n; k++) {
            if(ways[k][k] > 0) {
                for(int i = 1; i <= n; i++) {
                    for(int j = 1; j <= n; j++) {
                        if(ways[i][k] != 0 && ways[k][j] != 0) {
                            ways[i][j] = -1;
                        }
                    }
                }
            }
        }
        return ways;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 0;
        while(f.hasNext()) {
            int m = f.nextInt();
            int[][] edges = new int[m][2];
            int max = 0;
            for(int i = 0; i < m; i++) {
                edges[i][0] = f.nextInt()+1;
                edges[i][1] = f.nextInt()+1;
                max = Math.max(max, Math.max(edges[i][0], edges[i][1]));
            }
            n = max;
            adjacencyMatrix = new int[max+1][max+1];
            for(int[] i: edges) {
                adjacencyMatrix[i[0]][i[1]]++;
            }
            long[][] res = floydWarshall();
            out.println("matrix for city " + t++);
            for(int i = 1; i <= max; i++) {
                out.print(res[i][1]);
                for(int j = 2; j <= max; j++) {
                    out.print(" " + res[i][j]);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}