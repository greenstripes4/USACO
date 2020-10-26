import java.io.*;
import java.util.*;

public class Main {
    private static int area;
    private static int perimeter;
    private static void dfs(char[][] grid, int sourceRow, int sourceCol) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        stack.push(sourceRow*grid.length+sourceCol);
        visited.add(sourceRow*grid.length+sourceCol);
        while(!stack.isEmpty()) {
            int temp = stack.pop();
            int row = temp/grid.length;
            int col = temp%grid.length;
            grid[row][col] = 'X';
            area++;
            if(row-1 >= 0) {
                if(grid[row-1][col] == '.') {
                    perimeter++;
                } else if(grid[row-1][col] == '#' && !visited.contains((row-1)*grid.length+col)) {
                    stack.push((row-1)*grid.length+col);
                    visited.add((row-1)*grid.length+col);
                }
            }
            if(row+1 < grid.length) {
                if(grid[row+1][col] == '.') {
                    perimeter++;
                } else if(grid[row+1][col] == '#' && !visited.contains((row+1)*grid.length+col)){
                    stack.push((row+1)*grid.length+col);
                    visited.add((row+1)*grid.length+col);
                }
            }
            if(col-1 >= 0) {
                if(grid[row][col-1] == '.') {
                    perimeter++;
                } else if(grid[row][col-1] == '#' && !visited.contains(row*grid.length+col-1)){
                    stack.push(row*grid.length+col-1);
                    visited.add(row*grid.length+col-1);
                }
            }
            if(col+1 < grid.length) {
                if(grid[row][col+1] == '.') {
                    perimeter++;
                } else if(grid[row][col+1] == '#' && !visited.contains(row*grid.length+col+1)) {
                    stack.push(row*grid.length+col+1);
                    visited.add(row*grid.length+col+1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        int N = Integer.parseInt(f.readLine());
        char[][] grid = new char[N+2][N+2];
        for(int i = 1; i <= N; i++) {
            char[] temp = f.readLine().toCharArray();
            for(int j = 1; j <= N; j++) {
                grid[i][j] = temp[j-1];
            }
        }
        for(int i = 0; i < N+2; i++) {
            grid[0][i] = '.';
            grid[N+1][i] = '.';
            grid[i][0] = '.';
            grid[i][N+1] = '.';
        }
        int maxArea = 0;
        int maxPerimeter = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(grid[i][j] == '#') {
                    area = 0;
                    perimeter = 0;
                    dfs(grid, i, j);
                    if(area > maxArea || (area == maxArea && perimeter < maxPerimeter)) {
                        maxArea = area;
                        maxPerimeter = perimeter;
                    }
                }
            }
        }
        out.println(maxArea + " " + maxPerimeter);
        f.close();
        out.close();
    }
}
