import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            char[][] arr = new char[N][];
            for(int i = 0; i < N; i++) {
                arr[i] = f.readLine().toCharArray();
            }
            Queue<int[]> queue = new LinkedList<>();
            int[][] res = new int[N][M];
            for(int i = 0; i < N; i++) {
                Arrays.fill(res[i], -1);
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] == '1') {
                        queue.offer(new int[]{i, j});
                        res[i][j] = 0;
                    }
                }
            }
            int[] dr = {-1, 0, 0, 1};
            int[] dc = {0, -1, 1, 0};
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                for(int i = 0; i < 4; i++) {
                    int[] next = {cur[0]+dr[i], cur[1]+dc[i]};
                    if(next[0] < 0 || next[0] >= N || next[1] < 0 || next[1] >= M || res[next[0]][next[1]] >= 0) {
                        continue;
                    }
                    queue.offer(next);
                    res[next[0]][next[1]] = res[cur[0]][cur[1]]+1;
                }
            }
            for(int i = 0; i < N; i++) {
                out.print(res[i][0]);
                for(int j = 1; j < M; j++) {
                    out.print(" " + res[i][j]);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}