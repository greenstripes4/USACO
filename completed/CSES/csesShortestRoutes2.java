import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] adjacencyMatrix = new int[n][n];
        for(int[] i: adjacencyMatrix) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            adjacencyMatrix[a][b] = Math.min(adjacencyMatrix[a][b], c);
            adjacencyMatrix[b][a] = Math.min(adjacencyMatrix[b][a], c);
        }
        long[][] distances = new long[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                distances[i][j] = i == j ? 0 : adjacencyMatrix[i][j] < Integer.MAX_VALUE ? adjacencyMatrix[i][j] : 1000000000000000L;
            }
        }
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k]+distances[k][j]);
                }
            }
        }
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            out.println(distances[a][b] == 1000000000000000L ? -1 : distances[a][b]);
        }
        f.close();
        out.close();
    }
}