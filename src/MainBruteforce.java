import java.io.*;
import java.util.*;

public class MainBruteforce {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][];
        for(int i = 0; i < N; i++) {
            arr[i] = f.readLine().toCharArray();
        }
        int[][][] teleporters = new int[N][M][2];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                teleporters[i][j][0] = -1;
                teleporters[i][j][1] = -1;
            }
        }
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(f.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            teleporters[x1][y1][0] = x2;
            teleporters[x1][y1][1] = y2;
        }
        Deque<int[]> queue = new LinkedList<>();
        int[][] visited = new int[N][M];
        for(int[] i: visited) {
            Arrays.fill(i, -1);
        }
        queue.offer(new int[]{0, 0});
        visited[0][0] = 0;
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == N-1 && cur[1] == M-1) {
                break;
            }
            if(teleporters[cur[0]][cur[1]][0] >= 0) {
                int[] next = teleporters[cur[0]][cur[1]];
                if(arr[next[0]][next[1]] == '.' && visited[next[0]][next[1]] < 0) {
                    queue.offerFirst(next);
                    visited[next[0]][next[1]] = visited[cur[0]][cur[1]];
                }
            } else {
                for(int[] i: dir) {
                    int[] next = {cur[0]+i[0], cur[1]+i[1]};
                    if(next[0] >= 0 && next[0] < N && next[1] >= 0 && next[1] < M && arr[next[0]][next[1]] == '.' && visited[next[0]][next[1]] < 0) {
                        queue.offer(next);
                        visited[next[0]][next[1]] = visited[cur[0]][cur[1]]+1;
                    }
                }
            }
        }
        out.println(visited[N-1][M-1]);
        f.close();
        out.close();
    }
}
