import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static int[] arr;
    private static long[] dijkstra(int start) {
        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] longs, long[] t1) {
                return Long.compare(longs[1], t1[1]);
            }
        });
        boolean[] processed = new boolean[n+1];
        long[] distance = new long[n+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        queue.offer(new long[]{start, 0});
        distance[start] = 0;
        while(!queue.isEmpty()) {
            long[] temp = queue.poll();
            int node = (int) temp[0];
            long dist = temp[1];
            if(processed[node]) {
                continue;
            }
            processed[node] = true;
            for(int[] edge: adjacencyList.get(node)) {
                int next = edge[0];
                int weight = edge[1];
                if(dist+weight < distance[next] || (dist+weight == distance[next] && node < arr[next])) {
                    queue.offer(new long[]{next, dist+weight});
                    distance[next] = dist+weight;
                    arr[next] = node;
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("shortcut.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shortcut.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] c = new int[n+1];
        for(int i = 1; i <= n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        adjacencyList = new ArrayList<>(n+1);
        for(int i = 0; i < n+1; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adjacencyList.get(a).add(new int[]{b, t});
            adjacencyList.get(b).add(new int[]{a, t});
        }
        arr = new int[n+1];
        long[] reduction = dijkstra(1);
        for(int i = 1; i <= n; i++) {
            reduction[i] -= T;
        }
        int[] indegree = new int[n+1];
        for(int i = 1; i <= n; i++) {
            indegree[arr[i]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            c[arr[node]] += c[node];
            indegree[arr[node]]--;
            if(indegree[arr[node]] == 0) {
                queue.offer(arr[node]);
            }
        }
        long max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, reduction[i]*c[i]);
        }
        out.println(max);
        f.close();
        out.close();
    }
}