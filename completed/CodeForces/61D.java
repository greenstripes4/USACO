import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static long max = 0;
    private static void dfs(ArrayList<int[]>[] adjacencyList, boolean[] visited, int root, long pathLength) {
        visited[root] = true;
        boolean isLeaf = true;
        for(int[] i: adjacencyList[root]) {
            if(!visited[i[0]]) {
                isLeaf = false;
                dfs(adjacencyList, visited, i[0], pathLength+i[1]);
            }
        }
        if(isLeaf) {
            max = Math.max(max, pathLength);
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        ArrayList<int[]>[] adjacencyList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        long total = 0;
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            adjacencyList[x].add(new int[]{y, w});
            adjacencyList[y].add(new int[]{x, w});
            total += w*2;
        }
        dfs(adjacencyList, new boolean[n], 0, 0);
        out.println(total-max);
        f.close();
        out.close();
    }
}
