import java.io.*;
import java.util.*;

public class Main {
    private static int count;
    private static void dfs(char[][] maze, boolean[][] visited, int row, int col) {
        if(row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col] == '#' || visited[row][col] || count == 0) {
            return;
        }
        visited[row][col] = true;
        count--;
        dfs(maze, visited, row-1, col);
        dfs(maze, visited, row+1, col);
        dfs(maze, visited, row, col-1);
        dfs(maze, visited, row, col+1);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] maze = new char[n][];
        int empty = 0;
        for(int i = 0; i < n; i++) {
            maze[i] = f.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                if(maze[i][j] == '.') {
                    empty++;
                }
            }
        }
        count = empty-k;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maze[i][j] == '.' && count > 0) {
                    dfs(maze, visited, i, j);
                }
                if(count == 0) {
                    break;
                }
            }
            if(count == 0) {
                break;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maze[i][j] == '.' && !visited[i][j]) {
                    maze[i][j] = 'X';
                }
            }
        }
        for(char[] i: maze) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}