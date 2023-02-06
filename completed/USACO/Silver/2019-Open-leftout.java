import java.io.*;
import java.util.*;

public class Main {
        private static char flip(char c) {
                return c == 'L' ? 'R' : 'L';
        }
        private static boolean congruent(char[][] grid, int r1, int r2, int c1, int c2) {
                for(int i = r1; i <= r2; i++) {
                        for(int j = c1; j <= c2; j++) {
                                if(grid[i][j] == 'R') {
                                        return false;
                                }
                        }
                }
                return true;
        }
        public static void main(String[] args) throws IOException{
                BufferedReader f = new BufferedReader(new FileReader("leftout.in"));
                //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("leftout.out")));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                int N = Integer.parseInt(f.readLine());
                char[][] grid = new char[N][];
                for(int i = 0; i < N; i++) {
                        grid[i] = f.readLine().toCharArray();
                }
                for(int i = 0; i < N; i++) {
                        if(grid[i][0] == 'L') {
                                for(int j = 0; j < N; j++) {
                                        grid[i][j] = flip(grid[i][j]);
                                }
                        }
                }
                for(int j = 0; j < N; j++) {
                        if(grid[0][j] == 'L') {
                                for(int i = 0; i < N; i++) {
                                        grid[i][j] = flip(grid[i][j]);
                                }
                        }
                }
                if(congruent(grid, 1, N-1, 1, N-1)) {
                        out.println("1 1");
                } else {
                        int r = -1;
                        for(int i = 0; i < N; i++) {
                                if(congruent(grid, i, i, 1, N-1)) {
                                        if(r < 0) {
                                                r = i;
                                        } else {
                                                r = -2;
                                                break;
                                        }
                                }
                        }
                        if(r == -2) {
                                out.println(-1);
                        } else if(r >= 0) {
                                out.println((r+1) + " 1");
                        } else {
                                int c = -1;
                                for(int j = 0; j < N; j++) {
                                        if(congruent(grid, 1, N-1, j, j)) {
                                                if(c < 0) {
                                                        c = j;
                                                } else {
                                                        c = -2;
                                                        break;
                                                }
                                        }
                                }
                                if(c == -2) {
                                        out.println(-1);
                                } else if(c >= 0) {
                                        out.println("1 " + (c+1));
                                } else {
                                        for(int i = 0; i < N; i++) {
                                                for(int j = 0; j < N; j++) {
                                                        if(grid[i][j] == 'L') {
                                                                if(r < 0) {
                                                                        r = i;
                                                                        c = j;
                                                                } else {
                                                                        r = -2;
                                                                        break;
                                                                }
                                                        }
                                                }
                                                if(r == -2) {
                                                        break;
                                                }
                                        }
                                        if(r >= 0) {
                                                out.println((r+1) + " " + (c+1));
                                        } else {
                                                out.println(-1);
                                        }
                                }
                        }
                }
                f.close();
                out.close();
    }
}
