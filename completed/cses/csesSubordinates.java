import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adjacencyList;
    private static int[] subtreeSize;
    private static void dfs(int root, int parent) {
        for(int i: adjacencyList[root]) {
            if(i != parent) {
                dfs(i, root);
                subtreeSize[root] += subtreeSize[i]+1;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
             adjacencyList[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 2; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            adjacencyList[parent].add(i);
        }
        subtreeSize = new int[n+1];
        dfs(1, 0);
        out.print(subtreeSize[1]);
        for(int i = 2; i <= n; i++) {
            out.print(" " + subtreeSize[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}