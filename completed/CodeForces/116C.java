import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int max;
    private static void dfs(int u, int d) {
        max = Math.max(max, d);
        for(int v: adjacencyList.get(u)) {
            dfs(v, d+1);
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = Integer.parseInt(f.readLine())-1;
            if(parent[i] < 0) {
                continue;
            }
            adjacencyList.get(parent[i]).add(i);
        }
        max = 0;
        for(int i = 0; i < n; i++) {
            if(parent[i] < 0) {
                dfs(i, 1);
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
