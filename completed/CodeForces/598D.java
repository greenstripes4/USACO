import java.io.*;
import java.util.*;

public class Main {
    private static int[][] grid;
    private static int size;
    private static void getSize(int r, int c) {
        if(grid[r][c] < 0) {
            if(grid[r][c] == -1) {
                size++;
            }
            return;
        }
        grid[r][c] = -2;
        getSize(r-1, c);
        getSize(r+1, c);
        getSize(r, c-1);
        getSize(r, c+1);
    }
    private static void fillSize(int r, int c) {
        if(grid[r][c] != -2) {
            return;
        }
        grid[r][c] = size;
        fillSize(r-1, c);
        fillSize(r+1, c);
        fillSize(r, c-1);
        fillSize(r, c+1);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for(int i = 0; i < n; i++) {
            char[] temp = f.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                if(temp[j] == '*') {
                    grid[i][j]--;
                }
            }
        }
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            if(grid[x][y] == 0) {
                size = 0;
                getSize(x, y);
                fillSize(x, y);
            }
            out.println(grid[x][y]);
        }
        f.close();
        out.close();
    }
}
