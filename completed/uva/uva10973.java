import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[][] adjacencyMatrix = new boolean[n+1][n+1];
            for(int i = 0; i < m; i++) {
                StringTokenizer edge = new StringTokenizer(f.readLine());
                int a = Integer.parseInt(edge.nextToken());
                int b = Integer.parseInt(edge.nextToken());
                adjacencyMatrix[a][b] = true;
                adjacencyMatrix[b][a] = true;
            }
            int count = 0;
            for(int i = 1; i <= n; i++) {
                for(int j = i+1; j <= n; j++) {
                    if(adjacencyMatrix[i][j]) {
                        for(int k = j+1; k <= n; k++) {
                            if(adjacencyMatrix[i][k] && adjacencyMatrix[j][k]) {
                                count++;
                            }
                        }
                    }
                }
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}
