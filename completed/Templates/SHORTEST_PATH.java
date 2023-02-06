import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;

    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static int[][] adjacencyMatrix;
    private static int[][] edges;

    private static long[] dijkstra(int start) {
        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[1], o2[1]);
            }
        });
        boolean[] processed = new boolean[N];
        long[] distance = new long[N];
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
        long[] distance = new long[N];
        Arrays.fill(distance, Long.MAX_VALUE);
        boolean[] enqueued = new boolean[N];
        int[] count = new int[N];
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
                        if(count[next] == N-1) {
                            distance[N-1] = -1;
                            return distance;
                        }
                        queue.offer(next);
                        enqueued[next] = true;
                        count[next]++;
                    }
                }
            }
        }
        if(distance[N-1] == Long.MAX_VALUE) {
            distance[N-1] = -2;
        }
        return distance;
    }

    private static long[][] floydWarshall() {
        long[][] distance = new long[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(adjacencyMatrix[i][j] < Integer.MAX_VALUE) {
                    distance[i][j] = adjacencyMatrix[i][j];
                } else {
                    distance[i][j] = Long.MAX_VALUE/2;
                }
            }
        }
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(distance[i][k]+distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k]+distance[k][j];
                    }
                }
            }
        }
        return distance;
    }

    private static long[] bellmanFord(int start) {
        long[] distance = new long[N];
        Arrays.fill(distance, Long.MAX_VALUE/2);
        distance[start] = 0;
        for(int i = 0; i < N-1; i++) {
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
