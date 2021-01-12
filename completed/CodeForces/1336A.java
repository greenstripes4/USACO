import java.io.*;
import java.util.*;

public class Main {
    private static void dfs(ArrayList<Integer>[] adjacencyList, int[] subtreeSize, boolean[] visited, int root) {
        subtreeSize[root] = 1;
        visited[root] = true;
        for(int i: adjacencyList[root]) {
            if(!visited[i]) {
                dfs(adjacencyList, subtreeSize, visited, i);
                subtreeSize[root] += subtreeSize[i];
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adjacencyList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }
        int[] subtreeSize = new int[n];
        dfs(adjacencyList, subtreeSize, new boolean[n], 0);
        int[] depth = new int[n];
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int temp = queue.poll();
                depth[temp] = steps;
                for(int j: adjacencyList[temp]) {
                    if(!visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }
            steps++;
        }
        Integer[] sorted = new Integer[n];
        for(int i = 0; i < n; i++) {
            sorted[i] = i;
        }
        Arrays.sort(sorted, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return subtreeSize[t1]-depth[t1]-subtreeSize[integer]+depth[integer];
            }
        });
        long sum = 0;
        for(int i = 0; i < n-k; i++) {
            sum += subtreeSize[sorted[i]]-depth[sorted[i]]-1;
        }
        out.println(sum);
        f.close();
        out.close();
    }
}