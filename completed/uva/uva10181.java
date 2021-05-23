import java.io.*;
import java.util.*;

public class Main {
    private static class State implements Comparable<State>{
        private long encoded;
        private String steps;
        private State(long encoded, String steps) {
            this.encoded = encoded;
            this.steps = steps;
        }
        private int[][] decode() {
            long temp = encoded;
            int[][] res = new int[4][4];
            for(int i = 3; i >= 0; i--) {
                for(int j = 3; j >= 0; j--) {
                    res[i][j] = (int) (temp&15);
                    temp >>= 4;
                }
            }
            return res;
        }
        private int distance() {
            int[][] board = decode();
            int ans = 0;
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    if(board[i][j] == 0) {
                        ans += 6-i-j;
                    } else {
                        ans += Math.abs((board[i][j]-1)/4-i)+Math.abs((board[i][j]-1)%4-j);
                    }
                }
            }
            return ans;
        }
        @Override
        public int compareTo(State o) {
            return steps.length()+distance()-o.steps.length()-o.distance();
        }
    }
    private static long encode(int[][] board) {
        long ans = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                ans = (ans << 4) | board[i][j];
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
        int N = f.nextInt();
        while(N-- > 0) {
            int[][] start = new int[4][4];
            int[] arr = new int[16];
            int emptyRow = -1;
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    start[i][j] = f.nextInt();
                    arr[i*4+j] = start[i][j];
                    if(start[i][j] == 0) {
                        emptyRow = i;
                    }
                }
            }
            int inversions = 0;
            for(int i = 0; i < 16; i++) {
                if(arr[i] == 0) {
                    continue;
                }
                for(int j = i+1; j < 16; j++) {
                    if(arr[j] != 0 && arr[i] > arr[j]) {
                        inversions++;
                    }
                }
            }
            if((emptyRow+inversions)%2 == 0) {
                out.println("This puzzle is not solvable.");
                continue;
            }
            PriorityQueue<State> queue = new PriorityQueue<>();
            HashSet<Long> visited = new HashSet<>();
            long encoded = encode(start);
            queue.offer(new State(encoded, ""));
            visited.add(encoded);
            char[] chars = {'R', 'L', 'U', 'D'};
            int[] dirR = {0, 0, -1, 1};
            int[] dirC = {1, -1, 0, 0};
            boolean found = false;
            while(!queue.isEmpty()) {
                State state = queue.poll();
                if(state.steps.length() > 50) {
                    break;
                }
                if(state.encoded == 1311768467463790320L) {
                    found = true;
                    out.println(state.steps);
                    break;
                }
                int[][] board = state.decode();
                int row = -1;
                int col = -1;
                for(int i = 0; i < 4; i++) {
                    for(int j = 0; j < 4; j++) {
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
                    if(nextR < 0 || nextR > 3 || nextC < 0 || nextC > 3) {
                        continue;
                    }
                    board[row][col] = board[nextR][nextC];
                    board[nextR][nextC] = 0;
                    long next = encode(board);
                    if(!visited.contains(next)) {
                        queue.offer(new State(next, state.steps+chars[i]));
                        visited.add(next);
                    }
                    board[nextR][nextC] = board[row][col];
                    board[row][col] = 0;
                }
            }
            if(!found) {
                out.println("This puzzle is not solvable.");
            }
        }
        f.close();
        out.close();
    }
}