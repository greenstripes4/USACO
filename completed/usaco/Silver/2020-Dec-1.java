import java.io.*;
import java.util.*;

public class Main {
    private static int days;
    public static void dfs(ArrayList<Integer>[] adjacencyList, boolean[] visited, int root) {
        visited[root] = true;
        int children = 0;
        for(int i: adjacencyList[root]) {
            if(!visited[i]) {
                children++;
                dfs(adjacencyList, visited, i);
            }
        }
        int infected = 1;
        while(infected < children+1) {
            days++;
            infected += infected;
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        ArrayList<Integer>[] adjacencyList = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
        days = N-1;
        dfs(adjacencyList, new boolean[N], 0);
        out.println(days);
        f.close();
        out.close();
    }
}
