import java.io.*;
import java.util.*;

public class Main {
    private static char[][] board;
    private static boolean[][] visited;
    private static boolean bicolor(int r, int c, char color) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]) {
            return true;
        }
        char next = color == 'R' ? 'W' : 'R';
        if(board[r][c] == next) {
            return false;
        }
        board[r][c] = color;
        visited[r][c] = true;
        return bicolor(r-1, c, next) && bicolor(r+1, c, next) && bicolor(r, c-1, next) && bicolor(r, c+1, next);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] arr = new char[n][];
            board = new char[n][];
            for(int i = 0; i < n; i++) {
                arr[i] = f.readLine().toCharArray();
                board[i] = arr[i].clone();
            }
            visited = new boolean[n][m];
            if(bicolor(0, 0, 'R')) {
                out.println("YES");
                for(char[] i: board) {
                    out.println(new String(i));
                }
                continue;
            }
            board = arr;
            visited = new boolean[n][m];
            if(bicolor(0, 0, 'W')) {
                out.println("YES");
                for(char[] i: board) {
                    out.println(new String(i));
                }
                continue;
            }
            out.println("NO");
        }
        f.close();
        out.close();
    }
}