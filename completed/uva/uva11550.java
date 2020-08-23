import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = f.nextInt();
        for(int testcase = 0; testcase < t; testcase++) {
            int n = f.nextInt();
            int m = f.nextInt();
            int[][] incidenceMatrix = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    incidenceMatrix[i][j] = f.nextInt();
                }
            }
            boolean possible = true;
            ArrayList<Integer>[] adjacencyList = new ArrayList[n];
            for(int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            for(int i = 0; i < m; i++) {
                int u = -1;
                int v = -1;
                int verticesToEdgeI = 0;
                for(int j = 0; j < n; j++) {
                    if(incidenceMatrix[j][i] == 1) {
                        if(u == -1) {
                            u = j;
                        } else {
                            v = j;
                        }
                        verticesToEdgeI++;
                    }
                }
                if(verticesToEdgeI != 2 || adjacencyList[u].contains(v) || adjacencyList[v].contains(u)) {
                    possible = false;
                    break;
                }
                adjacencyList[u].add(v);
                adjacencyList[v].add(u);
            }
            out.println(possible ? "Yes" : "No");
        }
        f.close();
        out.close();
    }
}
