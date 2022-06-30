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
        for(int i = 1; i <= n; i++) {
            if(distance[i] == Long.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        return distance;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjacencyList.get(u).add(new int[]{v, w});
            adjacencyList.get(v).add(new int[]{u, w});
        }
        int[][] taxis = new int[n+1][2];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(f.readLine());
            taxis[i][0] = Integer.parseInt(st.nextToken());
            taxis[i][1] = Integer.parseInt(st.nextToken());
        }
        long[][] distance = new long[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            distance[i] = dijkstra(i);
        }
        adjacencyList = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i != j && distance[i][j] >= 0 && distance[i][j] <= taxis[i][0]) {
                    adjacencyList.get(i).add(new int[]{j, taxis[i][1]});
                }
            }
        }
        out.println(dijkstra(x)[y]);
        f.close();
        out.close();
    }
}