import java.io.*;
import java.util.*;

public class Main {
    private static char[][] arr;
    private static char[][] min;
    private static ArrayList<int[]> points;
    private static void dfs(int r, int c, int[] pos) {
        if(r < 0 || r >= min.length || c < 0 || c >= min[0].length || min[r][c] == '.') {
            return;
        }
        points.add(pos.clone());
        min[r][c] = '.';
        pos[0]++;
        dfs(r+1, c, pos);
        pos[0]--;
        pos[1]++;
        dfs(r, c+1, pos);
        pos[1]--;
        pos[0]--;
        dfs(r-1, c, pos);
        pos[0]++;
        pos[1]--;
        dfs(r, c-1, pos);
        pos[1]++;
    }
    private static boolean check() {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == '*') {
                    boolean flag = false;
                    for(int[] k: points) {
                        int r = i+k[0];
                        int c = j+k[1];
                        if(r < 0 || r >= arr.length || c < 0 || c >= arr[0].length || arr[r][c] == '.') {
                            flag = true;
                            break;
                        }
                        arr[r][c] = '.';
                    }
                    if(!flag) {
                        return true;
                    }
                    for(int[] k: points) {
                        int r = i+k[0];
                        int c = j+k[1];
                        if(r < 0 || r >= arr.length || c < 0 || c >= arr[0].length || arr[r][c] == '.') {
                            continue;
                        }
                        arr[r][c] = '*';
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) {
                break;
            }
            arr = new char[n][];
            for(int i = 0; i < n; i++) {
                arr[i] = f.readLine().toCharArray();
            }
            min = new char[m][];
            for(int i = 0; i < m; i++) {
                min[i] = f.readLine().toCharArray();
            }
            points = new ArrayList<>();
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < m; j++) {
                    if(min[i][j] == '*') {
                        dfs(i, j, new int[2]);
                    }
                }
            }
            boolean found = false;
            for(int i = 0; i < n && !found; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] == '*') {
                        boolean flag = false;
                        for(int[] k: points) {
                            int r = i+k[0];
                            int c = j+k[1];
                            if(r < 0 || r >= n || c < 0 || c >= n || arr[r][c] == '.') {
                                flag = true;
                                break;
                            }
                            arr[r][c] = '.';
                        }
                        if(!flag && check()) {
                            found = true;
                            break;
                        }
                        for(int[] k: points) {
                            int r = i+k[0];
                            int c = j+k[1];
                            if(r < 0 || r >= n || c < 0 || c >= n || arr[r][c] == '.') {
                                continue;
                            }
                            arr[r][c] = '*';
                        }
                    }
                }
            }
            out.println(found ? 1 : 0);
        }
        f.close();
        out.close();
    }
}