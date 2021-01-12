import java.io.*;
import java.util.*;

public class Main {
    private static boolean dfs(ArrayList<Integer>[] adjacencyList, boolean[] visited, int root, boolean color, HashSet<Integer> white, HashSet<Integer> black) {
        visited[root] = true;
        if(color) {
            white.add(root);
        } else {
            black.add(root);
        }
        for(int i: adjacencyList[root]) {
            if(!visited[i]) {
                if(!dfs(adjacencyList, visited, i, !color, white, black)) {
                    return false;
                }
            } else if((color && white.contains(i)) || (!color && black.contains(i))) {
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
        ArrayList<Integer>[] adjacencyList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        int[][] edges = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
            edges[i][0] = u;
            edges[i][1] = v;
        }
        HashSet<Integer> white = new HashSet<>();
        HashSet<Integer> black = new HashSet<>();
        if(dfs(adjacencyList, new boolean[n], 0, true, white, black)) {
            out.println("YES");
            StringBuilder sb = new StringBuilder();
            for(int[] i: edges) {
                if(white.contains(i[0]) && black.contains(i[1])) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
            out.println(sb);
        } else {
            out.println("NO");
        }
        f.close();
        out.close();
    }
}
