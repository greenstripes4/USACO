import java.io.*;
import java.util.*;

public class Main {
    private static int[][] grid;
    private static boolean isValid(int r, int c) {
        boolean[] used = new boolean[10];
        for(int i = 0; i < 9; i++) {
            if(grid[r][i] > 0 && used[grid[r][i]]) {
                return false;
            }
            used[grid[r][i]] = true;
        }
        Arrays.fill(used, false);
        for(int i = 0; i < 9; i++) {
            if(grid[i][c] > 0 && used[grid[i][c]]) {
                return false;
            }
            used[grid[i][c]] = true;
        }
        Arrays.fill(used, false);
        int topRow = r/3*3;
        int bottomRow = topRow+2;
        int leftCol = c/3*3;
        int rightCol = leftCol+2;
        for(int i = topRow; i <= bottomRow; i++) {
            for(int j = leftCol; j <= rightCol; j++) {
                if(grid[i][j] > 0 && used[grid[i][j]]) {
                    return false;
                }
                used[grid[i][j]] = true;
            }
        }
        return true;
    }
    private static boolean solve(int r, int c) {
        if(r == 9) {
            return true;
        }
        if(grid[r][c] > 0) {
            return solve(r+(c+1)/9, (c+1)%9);
        }
        for(int i = 1; i <= 9; i++) {
            grid[r][c] = i;
            if(isValid(r, c) && solve(r+(c+1)/9, (c+1)%9)) {
                return true;
            }
        }
        grid[r][c] = 0;
        return false;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            grid = new int[9][9];
            for(int i = 0; i < 9; i++) {
                char[] temp = f.readLine().toCharArray();
                for(int j = 0; j < 9; j++) {
                    grid[i][j] = temp[j]-'0';
                }
            }
            solve(0, 0);
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    out.print(grid[i][j]);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
