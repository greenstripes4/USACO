import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("visitfj.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("visitfj.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] longs, long[] t1) {
                return Long.compare(longs[3], t1[3]);
            }
        });
        boolean[][][] processed = new boolean[N][N][3];
        long[][][] distance = new long[N][N][3];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(long[][] i: distance) {
            for(long[] j: i) {
                Arrays.fill(j, Long.MAX_VALUE);
            }
        }
        queue.offer(new long[]{0, 0, 0, 0});
        distance[0][0][0] = 0;
        while(!queue.isEmpty()) {
            long[] temp = queue.poll();
            int[] node = {(int) temp[0], (int) temp[1], (int) temp[2]};
            long dist = temp[3];
            if(processed[node[0]][node[1]][node[2]]) {
                continue;
            }
            processed[node[0]][node[1]][node[2]] = true;
            for(int[] edge: dir) {
                int[] next = {node[0]+edge[0], node[1]+edge[1], (node[2]+1)%3};
                if(next[0] < 0 || next[0] >= N || next[1] < 0 || next[1] >= N) {
                    continue;
                }
                int weight = T+(next[2] == 0 ? arr[next[0]][next[1]] : 0);
                if(dist+weight < distance[next[0]][next[1]][next[2]]) {
                    queue.offer(new long[]{next[0], next[1], next[2], dist+weight});
                    distance[next[0]][next[1]][next[2]] = dist+weight;
                }
            }
        }
        out.println(Math.min(distance[N-1][N-1][0], Math.min(distance[N-1][N-1][1], distance[N-1][N-1][2])));
        f.close();
        out.close();
    }
}