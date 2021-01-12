import java.io.*;
import java.util.*;

public class Main {
    private static int count;
    private static void dfs(int[] a, ArrayList<int[]>[] adjacencyList, boolean[] visited, int root, long min, long cur, boolean remove) {
        visited[root] = true;
        if(remove) {
            count++;
            for(int[] i: adjacencyList[root]) {
                if(visited[i[0]]) {
                    continue;
                }
                dfs(a, adjacencyList, visited, i[0], Long.MIN_VALUE, Long.MAX_VALUE, true);
            }
            return;
        }
        if(cur-min > a[root]) {
            remove = true;
            count++;
        }
        min = Math.min(min, cur);
        for(int[] i: adjacencyList[root]) {
            if(visited[i[0]]) {
                continue;
            }
            dfs(a, adjacencyList, visited, i[0], min, cur+i[1], remove);
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<int[]>[] adjacencyList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int pi = Integer.parseInt(st.nextToken())-1;
            int ci = Integer.parseInt(st.nextToken());
            adjacencyList[i].add(new int[]{pi, ci});
            adjacencyList[pi].add(new int[]{i, ci});
        }
        count = 0;
        dfs(a, adjacencyList, new boolean[n], 0, 1000000001, 0, false);
        out.println(count);
        f.close();
        out.close();
    }
}
