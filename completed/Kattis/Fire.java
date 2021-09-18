import java.io.*;
import java.util.*;

public class Main {
    private static class State {
        private int r;
        private int c;
        private State(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            char[][] grid = new char[n][];
            Queue<State> q2 = new LinkedList<>();
            boolean[][] fire = new boolean[n][m];
            State start = null;
            for(int i = 0; i < n; i++) {
                grid[i] = f.readLine().toCharArray();
                for(int j = 0; j < m; j++) {
                    if(grid[i][j] == '*') {
                        grid[i][j] = '.';
                        q2.offer(new State(i, j));
                        fire[i][j] = true;
                    } else if(grid[i][j] == '@') {
                        grid[i][j] = '.';
                        start = new State(i, j);
                    }
                }
            }
            Queue<State> q1 = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];
            q1.offer(start);
            visited[start.r][start.c] = true;
            int[] dr = {-1, 0, 0, 1};
            int[] dc = {0, -1, 1, 0};
            int steps = 0;
            boolean found = false;
            while(!q1.isEmpty()) {
                int s2 = q2.size();
                while(s2-- > 0) {
                    State cur = q2.poll();
                    for(int i = 0; i < 4; i++) {
                        State next = new State(cur.r+dr[i], cur.c+dc[i]);
                        if(next.r < 0 || next.r >= n || next.c < 0 || next.c >= m || grid[next.r][next.c] == '#' || fire[next.r][next.c]) {
                            continue;
                        }
                        q2.offer(next);
                        fire[next.r][next.c] = true;
                    }
                }
                int s1 = q1.size();
                while(s1-- > 0) {
                    State cur = q1.poll();
                    if(cur.r < 0 || cur.r >= n || cur.c < 0 || cur.c >= m) {
                        found = true;
                        break;
                    }
                    for(int i = 0; i < 4; i++) {
                        State next = new State(cur.r+dr[i], cur.c+dc[i]);
                        if(next.r >= 0 && next.r < n && next.c >= 0 && next.c < m && (grid[next.r][next.c] == '#' || visited[next.r][next.c] || fire[next.r][next.c])) {
                            continue;
                        }
                        q1.offer(next);
                        if(next.r >= 0 && next.r < n && next.c >= 0 && next.c < m) {
                            visited[next.r][next.c] = true;
                        }
                    }
                }
                if(found) {
                    break;
                }
                steps++;
            }
            out.println(found ? steps : "IMPOSSIBLE");
        }
        f.close();
        out.close();
    }
}