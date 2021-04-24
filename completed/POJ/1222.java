import java.io.*;
import java.util.*;

public class Main {
    private static int[] dr = {-1, 0, 0, 1};
    private static int[] dc = {0, -1, 1, 0};
    private static void helper(int[][] board, int r, int c) {
        board[r][c] = (board[r][c]+1)%2;
    }
    private static void flip(int[][] board, int r, int c) {
        helper(board, r, c);
        for(int i = 0; i < 4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) {
                continue;
            }
            helper(board, nr, nc);
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        for(int t = 0; t < n; t++) {
            int M = 5;
            int N = 6;
            int[][] board = new int[M][N];
            for(int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                for(int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] res =  new int[M][N];
            int min = M*N+1;
            for(int i = 0; i < (1 << N); i++) {
                int[][] copy = new int[M][];
                for(int j = 0; j < M; j++) {
                    copy[j] = board[j].clone();
                }
                int[][] temp = new int[M][N];
                int cur = 0;
                for(int j = 0; j < N; j++) {
                    if((i&(1 << j)) > 0) {
                        temp[0][N-j-1] = 1;
                        cur++;
                        flip(copy, 0, N-j-1);
                    }
                }
                for(int r = 1; r < M; r++) {
                    for(int c = 0; c < N; c++) {
                        if(copy[r-1][c] == 1) {
                            temp[r][c] = 1;
                            cur++;
                            flip(copy, r, c);
                        }
                    }
                }
                for(int j = 0; j < N; j++) {
                    if(copy[M-1][j] == 1) {
                        cur = M*N+1;
                        break;
                    }
                }
                if(cur < min) {
                    res = temp;
                    min = cur;
                }
            }
            out.println("PUZZLE #" + (t+1));
            if(min > M*N) {
                out.println("IMPOSSIBLE");
            } else {
                for(int[] i: res) {
                    out.print(i[0]);
                    for(int j = 1; j < N; j++) {
                        out.print(" " + i[j]);
                    }
                    out.println();
                }
            }
        }
        f.close();
        out.close();
    }
}
