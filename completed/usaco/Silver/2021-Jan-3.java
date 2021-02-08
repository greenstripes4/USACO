import java.io.*;
import java.util.*;

public class Main {
    private static int max;
    private static boolean isValid(int[][] grid) {
        for(int i = 0; i < grid.length-1; i++) {
            for(int j = 0; j < grid.length-1; j++) {
                if(grid[i][j]+grid[i+1][j]+grid[i][j+1]+grid[i+1][j+1] != 2) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void solve(int[][] a, int[][] grid, int row, int col, int cur) {
        if(row == grid.length) {
            if(isValid(grid)) {
                max = Math.max(max, cur);
            }
            return;
        }
        int tempRow = row;
        int tempCol = col;
        int temp = a[row][col];
        col = (col+1)%grid.length;
        if(col == 0) {
            row++;
        }
        solve(a, grid, row, col, cur);
        grid[tempRow][tempCol] = 1;
        solve(a, grid, row, col, cur+temp);
        grid[tempRow][tempCol] = 0;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[][] a = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = 0;
        solve(a, new int[N][N], 0, 0, 0);
        out.println(max);
        f.close();
        out.close();
    }
}
