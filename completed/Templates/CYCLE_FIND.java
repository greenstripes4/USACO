import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adjacencyList;
    private static ArrayList<Integer> cycle;
    private static boolean[] visited;
    private static int[] parent;
    private static boolean dfs(int root) {
        if(visited[root]) {
            cycle.add(root);
            int temp = parent[root];
            while(root != temp) {
                cycle.add(temp);
                temp = parent[temp];
            }
            cycle.add(root);
            return true;
        }
        visited[root] = true;
        for(int i: adjacencyList[root]) {
            if(i != parent[root]) {
                parent[i] = root;
                if(dfs(i)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        f.close();
        out.close();
    }
}
