import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adjacencyList;
    private static int[] coloring;
    private static boolean dfs(int root, int color) {
        coloring[root] = color;
        for(int i: adjacencyList[root]) {
            if(coloring[i] == 0) {
                if(!dfs(i, color == 1 ? 2 : 1)) {
                    return false;
                }
            } else if(coloring[i] == color) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
        coloring = new int[n];
        boolean valid = true;
        for(int i = 0; i < n; i++) {
            if(coloring[i] == 0) {
                if(!dfs(i, 1)) {
                    valid = false;
                    break;
                }
            }
        }
        if(valid) {
            out.print(coloring[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + coloring[i]);
            }
            out.println();
        } else {
            out.println("IMPOSSIBLE");
        }
        f.close();
        out.close();
    }
}