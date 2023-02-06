import java.io.*;
import java.util.*;

public class Main{
    private static int getSize(char[][] grid, boolean[][] visited, int r, int c, char target) {
        visited[r][c] = true;
        int ans = 1;
        if(r+1 < grid.length && grid[r+1][c] == target && !visited[r+1][c]) {
            ans += getSize(grid, visited, r+1, c, target);
        }
        if(r-1 >= 0 && grid[r-1][c] == target && !visited[r-1][c]) {
            ans += getSize(grid, visited, r-1, c, target);
        }
        if(c+1 < 10 && grid[r][c+1] == target && !visited[r][c+1]) {
            ans += getSize(grid, visited, r, c+1, target);
        }
        if(c-1 >= 0 && grid[r][c-1] == target && !visited[r][c-1]) {
            ans += getSize(grid, visited, r, c-1, target);
        }
        return ans;
    }
    private static void turnToZeros(char[][] grid, int r, int c, char target) {
        grid[r][c] = '0';
        if(r+1 < grid.length && grid[r+1][c] == target) {
            turnToZeros(grid, r+1, c, target);
        }
        if(r-1 >= 0 && grid[r-1][c] == target) {
            turnToZeros(grid, r-1, c, target);
        }
        if(c+1 < 10 && grid[r][c+1] == target) {
            turnToZeros(grid, r, c+1, target);
        }
        if(c-1 >= 0 && grid[r][c-1] == target) {
            turnToZeros(grid, r, c-1, target);
        }
    }
    private static void applyGravity(char[][] grid) {
        for(int i = 0; i < 10; i++) {
            for(int j = grid.length-1; j >= 0; j--) {
                if(grid[j][i] != '0') {
                    for(int k = grid.length-1; k > j; k--) {
                        if(grid[k][i] == '0') {
                            char temp = grid[j][i];
                            grid[j][i] = '0';
                            grid[k][i] = temp;
                            break;
                        }
                    }
                }
            }
        }
    }
    private static void play(char[][] grid, int K) {
        boolean finished = false;
        while(!finished) {
            finished = true;
            boolean[][] visited = new boolean[grid.length][10];
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < 10; j++) {
                    if(grid[i][j] != '0' && !visited[i][j]) {
                        if(getSize(grid, visited, i, j, grid[i][j]) >= K) {
                            finished = false;
                            turnToZeros(grid, i, j, grid[i][j]);
                        }
                    }
                }
            }
            applyGravity(grid);
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[][] grid = new char[N][10];
        for(int i = 0; i < N; i++) {
            grid[i] = f.readLine().toCharArray();
        }
        play(grid, K);
        for(char[] i: grid) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}
