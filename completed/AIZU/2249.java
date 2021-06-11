import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static long[] dijkstra(int start) {
        PriorityQueue<long[]> queue = new PriorityQueue<long[]>(11, new Comparator<long[]>() {
            @Override
            public int compare(long[] longs, long[] t1) {
                return Long.compare(longs[1], t1[1]);
            }
        });
        boolean[] processed = new boolean[n+1];
        long[] distance = new long[n+1];
        long[] cost = new long[n+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        Arrays.fill(cost, Long.MAX_VALUE);
        queue.offer(new long[]{start, 0});
        distance[start] = 0;
        cost[start] = 0;
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
                if(dist+weight <= distance[next]) {
                    if(dist+weight < distance[next]) {
                        cost[next] = edge[2];
                    } else {
                        cost[next] = Math.min(cost[next], edge[2]);
                    }
                    queue.offer(new long[]{next, dist+weight});
                    distance[next] = dist+weight;
                }
            }
        }
        return cost;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            adjacencyList = new ArrayList<ArrayList<int[]>>();
            for(int i = 0; i <= n; i++) {
                adjacencyList.add(new ArrayList<int[]>());
            }
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adjacencyList.get(u).add(new int[]{v, d, c});
                adjacencyList.get(v).add(new int[]{u, d, c});
            }
            long[] res = dijkstra(1);
            long ans = 0;
            for(int i = 1; i <= n; i++) {
                ans += res[i];
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}