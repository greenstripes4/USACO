import java.io.*;
import java.util.*;

public class Main {
    private static int dfsSingle(int[][] board, int r, int c, int target, boolean[][] visited) {
        if(r < 0 || c < 0 || r >= board.length || c >= board.length || board[r][c] != target || visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        return 1+dfsSingle(board, r-1, c, target, visited)+dfsSingle(board, r, c-1, target, visited)+dfsSingle(board, r, c+1, target, visited)+dfsSingle(board, r+1, c, target, visited);
    }
    private static int dfsDouble(int[][] board, int r, int c, int target1, int target2, boolean[][] visited) {
        if(r < 0 || c < 0 || r >= board.length || c >= board.length || (board[r][c] != target1 && board[r][c] != target2) || visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        return 1+dfsDouble(board, r-1, c, target1, target2, visited)+dfsDouble(board, r, c-1, target1, target2, visited)+dfsDouble(board, r, c+1, target1, target2, visited)+dfsDouble(board, r+1, c, target1, target2, visited);
    }
    private static int getDoubleRegion(int[][] board, int target1, int target2) {
        boolean[][] visited = new boolean[board.length][board.length];
        int maximumDualRegion = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == target1 || board[i][j] == target2 || !visited[i][j]) {
                    maximumDualRegion = Math.max(maximumDualRegion, dfsDouble(board, i, j, target1, target2, visited));
                }
            }
        }
        return maximumDualRegion;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("multimoo.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int maxSingle = 0;
        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    maxSingle = Math.max(maxSingle, dfsSingle(board, i, j, board[i][j], visited));
                }
            }
        }
        out.println(maxSingle);
        HashMap<Integer,HashSet<Integer>> partners = new HashMap<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i+1 < N && board[i][j] !=  board[i+1][j] && (!partners.containsKey(board[i+1][j]) || !partners.get(board[i+1][j]).contains(board[i][j]))) {
                    if(!partners.containsKey(board[i][j])) {
                        partners.put(board[i][j], new HashSet<>());
                    }
                    partners.get(board[i][j]).add(board[i+1][j]);
                }
                if(j+1 < N && board[i][j] !=  board[i][j+1] && (!partners.containsKey(board[i][j+1]) || !partners.get(board[i][j+1]).contains(board[i][j]))) {
                    if(!partners.containsKey(board[i][j])) {
                        partners.put(board[i][j], new HashSet<>());
                    }
                    partners.get(board[i][j]).add(board[i][j+1]);
                }
            }
        }
        int maxDouble = 0;
        for(int i: partners.keySet()) {
            for(int j: partners.get(i)) {
                maxDouble = Math.max(maxDouble, getDoubleRegion(board, i, j));
            }
        }
        out.println(maxDouble);
        f.close();
        out.close();
    }
}
