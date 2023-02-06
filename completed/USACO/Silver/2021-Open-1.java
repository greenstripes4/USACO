import java.io.*;
import java.util.*;

public class Main {
    private static class Cell {
        private int type;
        private int row;
        private int col;
        private Cell(char type, char row, char col) {
            this.type = type == '.' ? 0 : type == '#' ? 3 : type == 'M' ? 1 : 2;
            this.row = row-'1';
            this.col = col-'1';
        }
    }
    private static class Board {
        private int[][] arr;
        private Board() {
            arr = new int[3][3];
        }
        private int toInt() {
            int ans = 0;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    ans = (ans << 2) | arr[i][j];
                }
            }
            return ans;
        }
        private boolean update(int type, int row, int col) {
            if(type == 0 || arr[row][col] != 0) {
                return false;
            }
            arr[row][col] = type;
            return true;
        }
        private void remove(int row, int col) {
            arr[row][col] = 0;
        }
        private boolean isWin() {
            for(int i = 0; i < 3; i++) {
                int val = arr[i][0]*100+arr[i][1]*10+arr[i][2];
                if(val == 122 || val == 221) {
                    return true;
                }
                val = arr[0][i]*100+arr[1][i]*10+arr[2][i];
                if(val == 122 || val == 221) {
                    return true;
                }
            }
            int val = arr[0][0]*100+arr[1][1]*10+arr[2][2];
            if(val == 122 || val == 221) {
                return true;
            }
            val = arr[0][2]*100+arr[1][1]*10+arr[2][0];
            return val == 122 || val == 221;
        }
    }
    private static int N;
    private static Cell[][] maze;
    private static Board board;
    private static boolean[][][] visited;
    private static HashSet<Integer> winning;
    private static int[] dirRow;
    private static int[] dirCol;
    private static void dfs(int row, int col) {
        visited[row][col][board.toInt()] = true;
        if(board.isWin()) {
            winning.add(board.toInt());
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nextRow = row+dirRow[i];
            int nextCol = col+dirCol[i];
            if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N || maze[nextRow][nextCol].type == 3) {
                continue;
            }
            Cell prev = maze[nextRow][nextCol];
            boolean valid = board.update(prev.type, prev.row, prev.col);
            maze[nextRow][nextCol] = new Cell('.', '.', '.');
            if(!visited[nextRow][nextCol][board.toInt()]) {
                dfs(nextRow, nextCol);
            }
            if(valid) {
                board.remove(prev.row, prev.col);
            }
            maze[nextRow][nextCol] = prev;
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        N = Integer.parseInt(f.readLine());
        maze = new Cell[N][N];
        int row = -1;
        int col = -1;
        for(int i = 0; i < N; i++) {
            char[] temp = f.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                if(temp[j*3] == 'B') {
                    row = i;
                    col = j;
                    temp[j*3] = '.';
                    temp[j*3+1] = '.';
                    temp[j*3+2] = '.';
                }
                maze[i][j] = new Cell(temp[j*3], temp[j*3+1], temp[j*3+2]);
            }
        }
        board = new Board();
        visited = new boolean[N][N][174763];
        winning = new HashSet<>();
        dirRow = new int[]{-1, 0, 0, 1};
        dirCol = new int[]{0, -1, 1, 0};
        dfs(row, col);
        out.println(winning.size());
        f.close();
        out.close();
    }
}
