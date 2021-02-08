import java.io.*;
import java.util.*;

public class Main {
    private static void dfs(ArrayList<Integer>[] adjacencyList, boolean[] visited, int root) {
        visited[root] = true;
        for(int i: adjacencyList[root]) {
            if(!visited[i]) {
                dfs(adjacencyList, visited, i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] edges = new int[m][3];
        ArrayList<Integer>[] adjacencyList = new ArrayList[n];
        ArrayList<Integer>[] reversed = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
            reversed[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken())-1;
            edges[i][1] = Integer.parseInt(st.nextToken())-1;
            edges[i][2] = Integer.parseInt(st.nextToken());
            adjacencyList[edges[i][0]].add(edges[i][1]);
            reversed[edges[i][1]].add(edges[i][0]);
        }
        long[] distances = new long[n];
        Arrays.fill(distances, -1000000000000000L);
        distances[0] = 0;
        for(int i = 0; i < n-1; i++) {
            for(int[] j: edges) {
                distances[j[1]] = Math.max(distances[j[1]], distances[j[0]]+j[2]);
            }
        }
        HashSet<Integer> startCycles = new HashSet<>();
        for(int[] j: edges) {
            if(distances[j[0]]+j[2] > distances[j[1]]) {
                startCycles.add(j[1]);
            }
            distances[j[1]] = Math.max(distances[j[1]], distances[j[0]]+j[2]);
        }
        if(startCycles.size() == 0) {
            out.println(distances[n-1]);
        } else {
            boolean found = false;
            for(int i: startCycles) {
                boolean[] visited = new boolean[n];
                dfs(adjacencyList, visited, i);
                if(!visited[n-1]) {
                    continue;
                }
                visited = new boolean[n];
                dfs(reversed, visited, i);
                if(!visited[0]) {
                    continue;
                }
                found = true;
                out.println(-1);
                break;
            }
            if(!found) {
                out.println(distances[n-1]);
            }
        }
        f.close();
        out.close();
    }
}