import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;

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

    private static long[] spfa(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        long[] distance = new long[n+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        boolean[] enqueued = new boolean[n+1];
        int[] count = new int[n+1];
        queue.offer(start);
        distance[start] = 0;
        enqueued[start] = true;
        count[start]++;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            long dist = distance[node];
            enqueued[node] = false;
            for(int[] edge: adjacencyList.get(node)) {
                int next = edge[0];
                int weight = edge[1];
                if(dist+weight < distance[next]) {
                    distance[next] = dist+weight;
                    if(!enqueued[next]) {
                        if(count[next] == n-1) {
                            distance[n] = -1;
                            return distance;
                        }
                        queue.offer(next);
                        enqueued[next] = true;
                        count[next]++;
                    }
                }
            }
        }
        if(distance[n] == Long.MAX_VALUE) {
            distance[n] = -2;
        }
        return distance;
    }

    private static int[][] adjacencyMatrix;
    private static long[][] floydWarshall() {
        long[][] distance = new long[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(adjacencyMatrix[i][j] < Integer.MAX_VALUE) {
                    distance[i][j] = adjacencyMatrix[i][j];
                } else {
                    distance[i][j] = Long.MAX_VALUE/2;
                }
            }
        }
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(distance[i][k]+distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k]+distance[k][j];
                    }
                }
            }
        }
        return distance;
    }

    private static int[][] edges;
    private static long[] bellmanFord(int start) {
        long[] distance = new long[n+1];
        Arrays.fill(distance, Long.MAX_VALUE/2);
        distance[start] = 0;
        for(int i = 0; i < n-1; i++) {
            for(int[] edge: edges) {
                if(distance[edge[0]]+edge[2] < distance[edge[1]]) {
                    distance[edge[1]] = distance[edge[0]]+edge[2];
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        f.close();
        out.close();
    }
}