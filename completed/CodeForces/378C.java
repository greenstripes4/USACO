import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static char[][] arr;
    private static boolean[][] visited;
    private static int left;
    private static void dfs(int r, int c) {
        if(r < 0 || r >= n || c < 0 || c >= m || arr[r][c] == '#' || visited[r][c] || left == 0) {
            return;
        }
        visited[r][c] = true;
        left--;
        dfs(r-1, c);
        dfs(r+1, c);
        dfs(r, c-1);
        dfs(r, c+1);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new char[n][];
        int empty = 0;
        int r = -1;
        int c = -1;
        for(int i = 0; i < n; i++) {
            arr[i] = f.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == '.') {
                    empty++;
                    r = i;
                    c = j;
                }
            }
        }
        visited = new boolean[n][m];
        left = empty-k;
        dfs(r, c);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == '.' && !visited[i][j]) {
                    arr[i][j] = 'X';
                }
            }
        }
        for(char[] i: arr) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}
