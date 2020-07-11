import java.io.*;
import java.util.*;

public class Main{
    private static void dfs(ArrayList<Integer>[] adjacencyList, boolean[] visited, int root) {
        visited[root] = true;
        for(int i: adjacencyList[root]) {
            if(!visited[i]) {
                dfs(adjacencyList,visited,i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] adjacencyList = new ArrayList[n];
            for(int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            for(int i = 0; i < m; i++) {
                StringTokenizer reaction = new StringTokenizer(f.readLine());
                int x = Integer.parseInt(reaction.nextToken());
                int y = Integer.parseInt(reaction.nextToken());
                adjacencyList[x-1].add(y-1);
            }
            boolean[] visited = new boolean[n];
            for(int i = 0; i < l; i++) {
                int z = Integer.parseInt(f.readLine());
                if(!visited[z-1]) {
                    dfs(adjacencyList,visited,z-1);
                }
            }
            int count = 0;
            for(boolean i: visited) {
                if(i) {
                    count++;
                }
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}