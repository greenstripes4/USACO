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
        BufferedReader f = new BufferedReader(new FileReader("pump.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pump.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] edges = new int[M][4];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
            edges[i][3] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[3]-o1[3];
            }
        });
        adjacencyList = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int max = 0;
        for(int[] i: edges) {
            adjacencyList.get(i[0]).add(new int[]{i[1], i[2]});
            adjacencyList.get(i[1]).add(new int[]{i[0], i[2]});
            long cost = dijkstra(1)[n];
            if(cost == Long.MAX_VALUE) {
                continue;
            }
            max = Math.max(max, (int) (1000000.0*i[3]/cost));
        }
        out.println(max);
        f.close();
        out.close();
    }
}