import java.io.*;
import java.util.*;

public class Main {
    private static class State implements Comparable<State>{
        private int encoded;
        private String steps;
        private State(int encoded, String steps) {
            this.encoded = encoded;
            this.steps = steps;
        }
        private int[][] decode() {
            int state = encoded;
            int[][] res = new int[3][3];
            for(int i = 2; i >= 0; i--) {
                for(int j = 2; j >= 0; j--) {
                    res[i][j] = state%10;
                    state /= 10;
                }
            }
            return res;
        }
        private int distance() {
            int[][] board = decode();
            int ans = 0;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(board[i][j] == 0) {
                        ans += 4-i-j;
                    } else {
                        ans += Math.abs((board[i][j]-1)/3-i)+Math.abs((board[i][j]-1)%3-j);
                    }
                }
            }
            return ans;
        }
        @Override
        public int compareTo(State o) {
            return distance()-o.distance();
        }
    }
    private static int encode(int[][] board) {
        int ans = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                ans = ans*10+board[i][j];
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int start = 0;
        for(int i = 0; i < 9; i++) {
            char temp = f.next().charAt(0);
            if(temp == 'x') {
                start *= 10;
            } else {
                start = start*10+temp-'0';
            }
        }
        PriorityQueue<State> queue = new PriorityQueue<State>();
        HashSet<Integer> visited = new HashSet<Integer>();
        queue.offer(new State(start, ""));
        visited.add(start);
        char[] chars = {'u', 'd', 'l', 'r'};
        int[] dirR = {-1, 1, 0, 0};
        int[] dirC = {0, 0, -1, 1};
        boolean found = false;
        while(!queue.isEmpty()) {
            State state = queue.poll();
            if(state.encoded == 123456780) {
                found = true;
                out.println(state.steps);
                break;
            }
            int[][] board = state.decode();
            int row = -1;
            int col = -1;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(board[i][j] == 0) {
                        row = i;
                        col = j;
                        break;
                    }
                }
                if(row >= 0) {
                    break;
                }
            }
            for(int i = 0; i < 4; i++) {
                int nextR = row+dirR[i];
                int nextC = col+dirC[i];
                if(nextR < 0 || nextR > 2 || nextC < 0 || nextC > 2) {
                    continue;
                }
                board[row][col] = board[nextR][nextC];
                board[nextR][nextC] = 0;
                int next = encode(board);
                if(!visited.contains(next)) {
                    queue.offer(new State(next, state.steps+chars[i]));
                    visited.add(next);
                }
                board[nextR][nextC] = board[row][col];
                board[row][col] = 0;
            }
        }
        if(!found) {
            out.println("unsolvable");
        }
        f.close();
        out.close();
    }
}