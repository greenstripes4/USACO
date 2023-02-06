import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adjacencyList;
    private static int[] dfs(int root, int parent, int distance) {
        int[] ans = {root, distance};
        for(int i: adjacencyList[root]) {
            if(i != parent) {
                int[] temp = dfs(i, root, distance+1);
                if(temp[1] > ans[1]) {
                    ans = temp;
                }
            }
        }
        return ans;
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
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
        out.println(dfs(dfs(1, 0, 0)[0], 0, 0)[1]);
        f.close();
        out.close();
    }
}