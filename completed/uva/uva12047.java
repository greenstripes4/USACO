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
        Arrays.fill(distance, Integer.MAX_VALUE);
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
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            adjacencyList = new ArrayList<>(n+1);
            for(int i = 0; i <= n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges[i][0] = u;
                edges[i][1] = v;
                edges[i][2] = c;
                adjacencyList.get(u).add(new int[]{v, c});
            }
            long[] distance1 = dijkstra(s);
            adjacencyList = new ArrayList<>(n+1);
            for(int i = 0; i <= n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for(int[] i: edges) {
                adjacencyList.get(i[1]).add(new int[]{i[0], i[2]});
            }
            long[] distance2 = dijkstra(t);
            int max = -1;
            for(int[] i: edges) {
                long total = distance1[i[0]]+i[2]+distance2[i[1]];
                if(total <= p) {
                    max = Math.max(max, i[2]);
                }
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
