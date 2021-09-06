import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        while(true) {
            int n = Integer.parseInt(f.readLine());
            if(n == 0) {
                break;
            }
            StringTokenizer st = new StringTokenizer(f.readLine());
            Queue<int[]> queue1 = new LinkedList<>();
            int[][] visited1 = new int[2001][2001];
            for(int i = 0; i <= 2000; i++) {
                Arrays.fill(visited1[i], -1);
            }
            for(int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                queue1.offer(new int[]{x, y});
                visited1[x][y] = 0;
            }
            int m = Integer.parseInt(f.readLine());
            st = new StringTokenizer(f.readLine());
            Queue<int[]> queue2 = new LinkedList<>();
            int[][] visited2 = new int[2001][2001];
            for(int i = 0; i <= 2000; i++) {
                Arrays.fill(visited2[i], -1);
            }
            for(int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                queue2.offer(new int[]{x, y});
                visited2[x][y] = 0;
            }
            int steps = -1;
            while(true) {
                int size1 = queue1.size();
                while(size1-- > 0) {
                    int[] cur = queue1.poll();
                    if(visited2[cur[0]][cur[1]] >= 0) {
                        steps = visited1[cur[0]][cur[1]]+visited2[cur[0]][cur[1]];
                        break;
                    }
                    for(int i = 0; i < 4; i++) {
                        int[] next = {cur[0]+dr[i], cur[1]+dc[i]};
                        if(next[0] < 0 || next[0] > 2000 || next[1] < 0 || next[1] > 2000) {
                            continue;
                        }
                        if(visited1[next[0]][next[1]] >= 0) {
                            continue;
                        }
                        queue1.offer(next);
                        visited1[next[0]][next[1]] = visited1[cur[0]][cur[1]]+1;
                    }
                }
                if(steps >= 0) {
                    break;
                }
                int size2 = queue2.size();
                while(size2-- > 0) {
                    int[] cur = queue2.poll();
                    for(int i = 0; i < 4; i++) {
                        int[] next = {cur[0]+dr[i], cur[1]+dc[i]};
                        if(next[0] < 0 || next[0] > 2000 || next[1] < 0 || next[1] > 2000) {
                            continue;
                        }
                        if(visited2[next[0]][next[1]] >= 0) {
                            continue;
                        }
                        queue2.offer(next);
                        visited2[next[0]][next[1]] = visited2[cur[0]][cur[1]]+1;
                    }
                }
            }
            out.println(steps);
        }
        f.close();
        out.close();
    }
}