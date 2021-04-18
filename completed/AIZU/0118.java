import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void dfs(char[][] f, int x, int y, char c) {
        f[x][y] = '.';
        for(int i = 0; i < 4; i++) {
            int nx = x+dx[i], ny = y+dy[i];
            if(nx > -1 && nx < m && ny > -1 && ny < n && f[nx][ny] == c) {
                dfs(f, nx, ny, f[nx][ny]);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int cnt = 0;
            m = in.nextInt();
            n = in.nextInt();
            if(m+n == 0) {
                break;
            }
            char[][] f = new char[m][n];
            for(int i = 0; i < m; i++) {
                String s = in.next();
                f[i] = s.toCharArray();
            }
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(f[i][j] != '.') {
                        dfs(f, i, j, f[i][j]);
                        cnt++;
                    }
                }
            }
            out.println(cnt);
        }
        in.close();
        out.close();
    }
}
