import java.io.*;
import java.util.*;

public class Main {
    private static char[][] a;
    private static boolean[][] visited;
    private static Stack<String> stack;
    private static void dfs(int r, int c, boolean root) {
        if(r < 0 || r >= a.length || c < 0 || c >= a[0].length || a[r][c] == '#' || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        if(!root) {
            stack.push("R " + (r+1) + " " + (c+1));
            stack.push("D " + (r+1) + " " + (c+1));
        }
        dfs(r+1, c, false);
        dfs(r-1, c, false);
        dfs(r, c+1, false);
        dfs(r, c-1, false);
        stack.push("B " + (r+1) + " " + (c+1));
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("mountains.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        a = new char[n][];
        for(int i = 0; i < n; i++) {
            a[i] = f.readLine().toCharArray();
        }
        visited = new boolean[n][m];
        stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == '.' && !visited[i][j]) {
                    dfs(i, j, true);
                }
            }
        }
        out.println(stack.size());
        while(!stack.isEmpty()) {
            out.println(stack.pop());
        }
        f.close();
        out.close();
    }
}
