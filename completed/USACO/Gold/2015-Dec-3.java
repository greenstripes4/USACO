import java.io.*;
import java.util.*;

public class Main {
    private static int[][] maze;
    private static int[] move(int[] cur, int[] dir) {
        int[] next = {cur[0]+dir[0], cur[1]+dir[1], cur[2], cur[3]};
        if(next[0] < 0 || next[0] >= maze.length || next[1] < 0 || next[1] >= maze[0].length) {
            return cur;
        }
        if(maze[next[0]][next[1]] == 0 || (cur[2] == 0 && maze[next[0]][next[1]] == 3)) {
            return cur;
        }
        if(maze[next[0]][next[1]] == 2) {
            next[2] = 1;
        }
        next[3]++;
        if(maze[next[0]][next[1]] == 4) {
            return move(next, dir);
        }
        return next;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("dream.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dream.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        int[][][] distance = new int[N][M][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j][0] = 1000000000;
                distance[i][j][1] = 1000000000;
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[3]-o2[3];
            }
        });
        boolean[][][] processed = new boolean[N][M][2];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue.offer(new int[]{0, 0, 0, 0});
        distance[0][0][0] = 0;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            if(processed[temp[0]][temp[1]][temp[2]]) {
                continue;
            }
            processed[temp[0]][temp[1]][temp[2]] = true;
            for(int[] d: dir) {
                int[] next = move(temp, d);
                if(next[3] < distance[next[0]][next[1]][next[2]]) {
                    queue.offer(next);
                    distance[next[0]][next[1]][next[2]] = next[3];
                }
            }
        }
        int ans = Math.min(distance[N-1][M-1][0], distance[N-1][M-1][1]);
        out.println(ans == 1000000000 ? -1 : ans);
        f.close();
        out.close();
    }
}
