import java.io.*;
import java.util.*;

public class Main {
    private static char[] path;
    private static boolean[][] visited;
    private static int[][] directions;
    private static int count;
    private static int getDirection(char dir) {
        if(dir == 'D') {
            return 3;
        }
        if(dir == 'U') {
            return 0;
        }
        if(dir == 'L') {
            return 1;
        }
        return 2;
    }
    private static int distance(int row, int col) {
        return 6-row+col;
    }
    private static void dfs(int ind, int row, int col) {
        visited[row][col] = true;
        if(ind == 48) {
            count++;
        } else if(path[ind] == '?') {
            for(int[] i: directions) {
                int nextRow = row+i[0];
                int nextCol = col+i[1];
                if(nextRow < 0 || nextCol < 0 || nextRow > 6 || nextCol > 6 || visited[nextRow][nextCol] || distance(nextRow, nextCol) > 48-ind) {
                    continue;
                }
                dfs(ind+1, nextRow, nextCol);
            }
        } else {
            int nextRow = row+directions[getDirection(path[ind])][0];
            int nextCol = col+directions[getDirection(path[ind])][1];
            if(!(nextRow < 0 || nextCol < 0 || nextRow > 6 || nextCol > 6 || visited[nextRow][nextCol] || distance(nextRow, nextCol) > 48-ind)) {
                dfs(ind+1, nextRow, nextCol);
            }
        }
        visited[row][col] = false;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        path = f.readLine().toCharArray();
        visited = new boolean[7][7];
        directions = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        count = 0;
        dfs(0, 0, 0);
        out.println(count);
        f.close();
        out.close();
    }
}