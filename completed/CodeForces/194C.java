import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static char[][] arr;
    private static char[][] temp;
    private static void dfs(int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >= m || temp[i][j] == '.') {
            return;
        }
        temp[i][j] = '.';
        dfs(i-1, j);
        dfs(i+1, j);
        dfs(i, j-1);
        dfs(i, j+1);
    }
    private static int countComponents() {
        temp = new char[n][];
        for(int i = 0; i < n; i++) {
            temp[i] = arr[i].clone();
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(temp[i][j] == '#') {
                    ans++;
                    dfs(i, j);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = f.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == '#') {
                    cnt++;
                }
            }
        }
        if(cnt < 3) {
            out.println(-1);
        } else {
            boolean flag = false;
            for(int i = 0; i < n && !flag; i++) {
                for(int j = 0; j < m && !flag; j++) {
                    if(arr[i][j] == '#') {
                        arr[i][j] = '.';
                        if(countComponents() > 1) {
                            flag = true;
                        }
                        arr[i][j] = '#';
                    }
                }
            }
            out.println(flag ? 1 : 2);
        }
        f.close();
        out.close();
    }
}