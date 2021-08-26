import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 1; t <= N; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<int[]>> adjacencyList = new ArrayList<>(n);
            for(int i = 0; i < n; i++) {
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
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[1]-t1[1];
                }
            });
            queue.offer(new int[]{S, 0});
            boolean[] processed = new boolean[n];
            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[S] = 0;
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                if(processed[cur[0]]) {
                    continue;
                }
                processed[cur[0]] = true;
                for(int[] edge: adjacencyList.get(cur[0])) {
                    int[] next = new int[]{edge[0], cur[1]+edge[1]};
                    if(next[1] < distance[next[0]]) {
                        queue.offer(next);
                        distance[next[0]] = next[1];
                    }
                }
            }
            out.println("Case #" + t + ": " + (distance[T] == Integer.MAX_VALUE ? "unreachable" : distance[T]));
        }
        f.close();
        out.close();
    }
}