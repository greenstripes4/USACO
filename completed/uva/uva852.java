import java.io.*;
import java.util.*;

public class Main{
    private static int size;
    private static char border;
    private static void dfs(char[][] board, boolean[][] visited, int r, int c) {
        size++;
        visited[r][c] = true;
        int[] directionsX = {-1,1,0,0};
        int[] directionsY = {0,0,-1,1};
        for(int i = 0; i < 4; i++) {
            int nextR = r + directionsX[i];
            int nextC = c + directionsY[i];
            if(nextR < 0 || nextR >= 9 || nextC < 0 || nextC >= 9) {
                continue;
            }
            if(board[r][c] == '.' && board[nextR][nextC] != '.') {
                if(border == 'L') {
                    border = board[nextR][nextC];
                } else if(border != board[nextR][nextC]) {
                    border = 'N';
                }
            }
            if(board[r][c] == board[nextR][nextC] && !visited[nextR][nextC]) {
                dfs(board,visited,nextR,nextC);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int boardPositions = Integer.parseInt(f.readLine());
        for(int b = 0; b < boardPositions; b++) {
            char[][] board = new char[9][9];
            for(int i = 0; i < 9; i++) {
                board[i] = f.readLine().toCharArray();
            }
            boolean[][] visited = new boolean[9][9];
            int blackScore = 0;
            int whiteScore = 0;
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    if(!visited[i][j]) {
                        size = 0;
                        border = 'L';
                        dfs(board,visited,i,j);
                        if(board[i][j] == 'X') {
                            blackScore += size;
                        } else if(board[i][j] == 'O') {
                            whiteScore += size;
                        } else {
                            if(border == 'X') {
                                blackScore += size;
                            } else if(border == 'O') {
                                whiteScore += size;
                            }
                        }
                    }
                }
            }
            out.println("Black " + blackScore + " White " + whiteScore);
        }
        f.close();
        out.close();
    }
}
