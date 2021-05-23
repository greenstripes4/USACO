import java.io.*;
import java.util.*;

public class Main {
    private static int encode(boolean[][] board) {
        int res = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j]) {
                    res = res*100+i*10+j;
                }
            }
        }
        return res;
    }
    private static boolean[][] decode(int encoded) {
        boolean[][] board = new boolean[8][8];
        for(int i = 0; i < 4; i++) {
            int c = encoded%10;
            encoded /= 10;
            int r = encoded%10;
            encoded /= 10;
            board[r][c] = true;
        }
        return board;
    }
    private static int[][] decode2(int encoded) {
        int[][] res = new int[4][2];
        for(int i = 0; i < 4; i++) {
            res[i][1] = encoded%10;
            encoded /= 10;
            res[i][0] = encoded%10;
            encoded /= 10;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            boolean[][] initialBoard = new boolean[8][8];
            for(int i = 0; i < 4; i++) {
                initialBoard[f.nextInt()-1][f.nextInt()-1] = true;
            }
            boolean[][] targetBoard = new boolean[8][8];
            for(int i = 0; i < 4; i++) {
                targetBoard[f.nextInt()-1][f.nextInt()-1] = true;
            }
            int initial = encode(initialBoard);
            int target = encode(targetBoard);
            Queue<Integer> queue1 = new LinkedList<>();
            Queue<Integer> queue2 = new LinkedList<>();
            HashSet<Integer> visited1 = new HashSet<>();
            HashSet<Integer> visited2 = new HashSet<>();
            queue1.offer(initial);
            queue2.offer(target);
            visited1.add(initial);
            visited2.add(target);
            int[] dirR = {-1, 0, 0, 1};
            int[] dirC = {0, -1, 1, 0};
            boolean found = false;
            for(int k = 0; k <= 4; k++) {
                int size1 = queue1.size();
                while(size1-- > 0) {
                    int temp = queue1.poll();
                    if(visited2.contains(temp)) {
                        found = true;
                        break;
                    }
                    boolean[][] board = decode(temp);
                    int[][] pieces = decode2(temp);
                    for(int[] i: pieces) {
                        for(int j = 0; j < 4; j++) {
                            int nextR = i[0]+dirR[j];
                            int nextC = i[1]+dirC[j];
                            if(nextR < 0 || nextR > 7 || nextC < 0 || nextC > 7) {
                                continue;
                            }
                            if(board[nextR][nextC]) {
                                nextR += dirR[j];
                                nextC += dirC[j];
                            }
                            if(nextR < 0 || nextR > 7 || nextC < 0 || nextC > 7 || board[nextR][nextC]) {
                                continue;
                            }
                            board[i[0]][i[1]] = false;
                            board[nextR][nextC] = true;
                            int encoded = encode(board);
                            if(!visited1.contains(encoded)) {
                                queue1.offer(encoded);
                                visited1.add(encoded);
                            }
                            board[i[0]][i[1]] = true;
                            board[nextR][nextC] = false;
                        }
                    }
                }
                if(found) {
                    break;
                }
                if(k == 4) {
                    break;
                }
                int size2 = queue2.size();
                while(size2-- > 0) {
                    int temp = queue2.poll();
                    if(visited1.contains(temp)) {
                        found = true;
                        break;
                    }
                    boolean[][] board = decode(temp);
                    int[][] pieces = decode2(temp);
                    for(int[] i: pieces) {
                        for(int j = 0; j < 4; j++) {
                            int nextR = i[0]+dirR[j];
                            int nextC = i[1]+dirC[j];
                            if(nextR < 0 || nextR > 7 || nextC < 0 || nextC > 7) {
                                continue;
                            }
                            if(board[nextR][nextC]) {
                                nextR += dirR[j];
                                nextC += dirC[j];
                            }
                            if(nextR < 0 || nextR > 7 || nextC < 0 || nextC > 7 || board[nextR][nextC]) {
                                continue;
                            }
                            board[i[0]][i[1]] = false;
                            board[nextR][nextC] = true;
                            int encoded = encode(board);
                            if(!visited2.contains(encoded)) {
                                queue2.offer(encoded);
                                visited2.add(encoded);
                            }
                            board[i[0]][i[1]] = true;
                            board[nextR][nextC] = false;
                        }
                    }
                }
                if(found) {
                    break;
                }
            }
            out.println(found ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}