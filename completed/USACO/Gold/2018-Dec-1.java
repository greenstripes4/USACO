import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static ArrayList<ArrayList<int[]>> adjacencyList;
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
                if(dist+weight < distance[next]) {
                    queue.offer(new long[]{next, dist+weight});
                    distance[next] = dist+weight;
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dining.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dining.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
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
        long[] distance = dijkstra(n);
        for(ArrayList<int[]> i: adjacencyList) {
            for(int[] j: i) {
                if(j[0] == n) {
                    i.remove(j);
                    break;
                }
            }
        }
        adjacencyList.get(n).clear();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(f.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            min = Math.min(min, (int) distance[idx]*2-y);
            adjacencyList.get(n).add(new int[]{idx, (int) distance[idx]-y});
        }
        long[] distance2 = dijkstra(n);
        for(int i = 1; i < n; i++) {
            if(distance2[i] <= distance[i] || min <= 0) {
                out.println(1);
            } else {
                out.println(0);
            }
        }
        f.close();
        out.close();
    }
}
