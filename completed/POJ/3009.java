import java.io.*;
import java.util.*;

public class Main {
    private static int[] helper(int[][] arr, int r, int c, int dr, int dc) {
        if(r+dr < 0 || r+dr >= arr.length || c+dc < 0 || c+dc >= arr[0].length || arr[r+dr][c+dc] == 1) {
            return new int[]{-1, -1};
        }
        while(r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && arr[r][c] == 0) {
            r += dr;
            c += dc;
        }
        if(r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && arr[r][c] == 1) {
            arr[r][c] = 0;
            r -= dr;
            c -= dc;
        }
        return new int[]{r, c};
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int[][] arr = new int[H][W];
            int sr = -1;
            int sc = -1;
            int dr = -1;
            int dc = -1;
            for(int i = 0; i < H; i++) {
                st = new StringTokenizer(f.readLine());
                for(int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 2) {
                        sr = i;
                        sc = j;
                        arr[sr][sc] = 0;
                    } else if(arr[i][j] == 3) {
                        dr = i;
                        dc = j;
                    }
                }
            }
            Queue<Integer> queueR = new LinkedList<>();
            Queue<Integer> queueC = new LinkedList<>();
            queueR.offer(sr);
            queueC.offer(sc);
            int steps = 0;
            boolean found = false;
            int[] dirR = {-1, 0, 0, 1};
            int[] dirC = {0, -1, 1, 0};
            while(steps <= 10) {
                int size = queueR.size();
                for(int i = 0; i < size; i++) {
                    int nr = queueR.poll();
                    int nc = queueC.poll();
                    if(nr == dr && nc == dc) {
                        found = true;
                        break;
                    }
                    for(int j = 0; j < 4; j++) {
                        int[] temp = helper(arr, nr, nc, dirR[j], dirC[j]);
                        int tr = temp[0];
                        int tc = temp[1];
                        if(tr < 0 || tr >= H || tc < 0 || tc >= W) {
                            continue;
                        }
                        queueR.offer(tr);
                        queueC.offer(tc);
                    }
                }
                if(found) {
                    break;
                }
                steps++;
            }
            out.println(found ? steps : -1);
        }
        f.close();
        out.close();
    }
}