import java.io.*;
import java.util.*;

public class Main {
    private static class Cell {
        int t, r, c;
        char v;
        public Cell(String s) {
            if(s.equals("...")) {
                t = 0;
            } else if(s.equals("###")) {
                t = 1;;
            } else {
                t = 2;
                v = s.charAt(0);
                r = s.charAt(1)-'1';
                c = s.charAt(2)-'1';
            }
        }
    }
    private static class State {
        int r;
        int c;
        String m;
        String b;
        public State(int r, int c, String m, String b) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.b = b;
        }
        public boolean isWin() {
            char[][] board = new char[3][];
            board[0] = b.substring(0, 3).toCharArray();
            board[1] = b.substring(3, 6).toCharArray();
            board[2] = b.substring(6).toCharArray();
            if(board[0][0] == 'M' && board[0][1] == 'O' && board[0][2] == 'O') {
                return true;
            }
            if(board[1][0] == 'M' && board[1][1] == 'O' && board[1][2] == 'O') {
                return true;
            }
            if(board[2][0] == 'M' && board[2][1] == 'O' && board[2][2] == 'O') {
                return true;
            }
            if(board[0][0] == 'M' && board[1][0] == 'O' && board[2][0] == 'O') {
                return true;
            }
            if(board[0][1] == 'M' && board[1][1] == 'O' && board[2][1] == 'O') {
                return true;
            }
            if(board[0][2] == 'M' && board[1][2] == 'O' && board[2][2] == 'O') {
                return true;
            }
            if(board[0][0] == 'M' && board[1][1] == 'O' && board[2][2] == 'O') {
                return true;
            }
            if(board[0][2] == 'M' && board[1][1] == 'O' && board[2][0] == 'O') {
                return true;
            }
            if(board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'M') {
                return true;
            }
            if(board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'M') {
                return true;
            }
            if(board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'M') {
                return true;
            }
            if(board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'M') {
                return true;
            }
            if(board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'M') {
                return true;
            }
            if(board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'M') {
                return true;
            }
            if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'M') {
                return true;
            }
            if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'M') {
                return true;
            }
            return false;
        }
        public String getEncoding() {
            return m+b+r+c;
        }
    }
    private static Cell[][] maze;
    private static ArrayList<Cell> moves;
    private static int[][] map;
    private static HashSet<String> wins;
    private static HashSet<String> visited;
    private static int[] dr = {1, 0, 0, -1};
    private static int[] dc = {0, 1, -1, 0};
    private static void dfs(State cur) {
        visited.add(cur.getEncoding());
        if(cur.isWin()) {
            wins.add(cur.b);
            return;
        }
        for(int i = 0; i < 4; i++) {
            State next = new State(cur.r+dr[i], cur.c+dc[i], cur.m, cur.b);
            if(next.r < 0 || next.r >= maze.length || next.c < 0 || next.c >= maze.length || maze[next.r][next.c].t == 1) {
                continue;
            }
            if(maze[next.r][next.c].t == 2 && next.m.charAt(map[next.r][next.c]) == '1') {
                char[] tempM = next.m.toCharArray();
                char[] tempB = next.b.toCharArray();
                tempM[map[next.r][next.c]] = '0';
                if(tempB[maze[next.r][next.c].r*3+maze[next.r][next.c].c] == '.') {
                    tempB[maze[next.r][next.c].r*3+maze[next.r][next.c].c] = maze[next.r][next.c].v;
                }
                next.m = new String(tempM);
                next.b = new String(tempB);
            }
            if(visited.contains(next.getEncoding())) {
                continue;
            }
            dfs(next);
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        maze = new Cell[n][n];
        moves = new ArrayList<>();
        map = new int[n][n];
        int r = -1;
        int c = -1;
        for(int i = 0; i < n; i++) {
            char[] row = f.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                String s = new String(new char[]{row[j*3], row[j*3+1], row[j*3+2]});
                if(s.equals("BBB")) {
                    r = i;
                    c = j;
                    s = "...";
                }
                maze[i][j] = new Cell(s);
                if(maze[i][j].t == 2) {
                    map[i][j] = moves.size();
                    moves.add(maze[i][j]);
                }
            }
        }
        wins = new HashSet<>();
        visited = new HashSet<>();
        char[] m = new char[moves.size()];
        Arrays.fill(m, '1');
        char[] b = new char[9];
        Arrays.fill(b, '.');
        dfs(new State(r, c, new String(m), new String(b)));
        out.println(wins.size());
        f.close();
        out.close();
    }
}