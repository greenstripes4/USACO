import java.io.*;
import java.util.*;

public class Main {
    private static int[][] arr;
    private static HashSet<Integer> res;
    private static int[] dr = {-1, 0, 0, 1};
    private static int[] dc = {0, -1, 1, 0};
    private static void dfs(int r, int c, int steps, int cur) {
        cur = cur*10+arr[r][c];
        if(steps == 5) {
            res.add(cur);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr < 0 || nc < 0 || nr >= arr.length || nc >= arr[0].length) {
                continue;
            }
            dfs(nr, nc, steps+1, cur);
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        arr = new int[5][5];
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        res = new HashSet<Integer>();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                dfs(i, j, 0, 0);
            }
        }
        out.println(res.size());
        f.close();
        out.close();
    }
}