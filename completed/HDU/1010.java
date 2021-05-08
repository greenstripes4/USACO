import java.io.*;
import java.util.*;

public class Main {
    private static char[][] maze;
    private static boolean[][] visited;
    private static int er;
    private static int ec;
    private static int dist(int r, int c) {
        return Math.abs(r-er)+Math.abs(c-ec);
    }
    private static boolean dfs(int r, int c, int T) {
        if(r < 0 || r >= maze.length || c < 0 || c >= maze[0].length || maze[r][c] == 'X' || visited[r][c] || dist(r, c) > T) {
            return false;
        }
        if(r == er && c == ec) {
            return T == 0;
        }
        visited[r][c] = true;
        if(dfs(r-1, c, T-1) || dfs(r+1, c, T-1) || dfs(r, c-1, T-1) || dfs(r, c+1, T-1)) {
            return true;
        }
        visited[r][c] = false;
        return false;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int N = f.nextInt();
            int M = f.nextInt();
            int T = f.nextInt();
            if(N == 0 && M == 0 && T == 0) {
                break;
            }
            maze = new char[N][M];
            int sr = -1;
            int sc = -1;
            for(int i = 0; i < N; i++) {
                maze[i] = f.next().toCharArray();
                for(int j = 0; j < M; j++) {
                    if(maze[i][j] == 'S') {
                        sr = i;
                        sc = j;
                        maze[i][j] = '.';
                    } else if(maze[i][j] == 'D') {
                        er = i;
                        ec = j;
                        maze[i][j] = '.';
                    }
                }
            }
            visited = new boolean[N][M];
            if(dist(sr, sc) > T) {
                out.println("NO");
            } else {
                out.println(dfs(sr, sc, T) ? "YES" : "NO");
            }
        }
        f.close();
        out.close();
    }
}