import java.io.*;
import java.util.*;

public class Main {
    private static char[][] arr;
    private static int[][] visited;
    private static boolean[][] res;
    private static int[] move(int[] cur, int[] dir) {
        int[] next = cur.clone();
        next[0] += dir[0];
        next[1] += dir[1];
        next[2] += dir[0];
        return next;
    }
    private static void replicate(int[] cur) {
        cur[2]--;
    }
    private static boolean check(int[] cur, int id) {
        if(arr[cur[0]][cur[1]] == '#' || visited[cur[0]][cur[1]] == id) {
            return false;
        }
        int i = cur[2];
        int j = cur[1];
        int l = cur[0]-cur[2];
        for(int k = 0; k < l; k++) {
            if(arr[i++][j++] == '#') {
                return false;
            }
        }
        for(int k = 0; k < l; k++) {
            if(arr[i++][j--] == '#') {
                return false;
            }
        }
        for(int k = 0; k < l; k++) {
            if(arr[i--][j--] == '#') {
                return false;
            }
        }
        for(int k = 0; k < l; k++) {
            if(arr[i--][j++] == '#') {
                return false;
            }
        }
        return true;
    }
    private static void fill(int r, int c, int id) {
        if(id == 0) {
            return;
        }
        if(id == 1) {
            res[r][c] = true;
            return;
        }
        id--;
        int i = r-id;
        int j = c;
        for(int k = 0; k < id; k++) {
            res[i++][j++] = true;
        }
        for(int k = 0; k < id; k++) {
            res[i++][j--] = true;
        }
        for(int k = 0; k < id; k++) {
            res[i--][j--] = true;
        }
        for(int k = 0; k < id; k++) {
            res[i--][j++] = true;
        }
        fill(r, c, id);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        arr = new char[N][N];
        Queue<int[]> queue = new LinkedList<>();
        visited = new int[N][N];
        for(int i = 0; i < N; i++) {
            arr[i] = f.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 'S') {
                    queue.offer(new int[]{i, j, i});
                    visited[i][j] = 1;
                    arr[i][j] = '.';
                }
            }
        }
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int steps = 0;
        int id = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] cur = queue.poll();
                for(int[] dir: directions) {
                    int[] next = move(cur, dir);
                    if(check(next, id)) {
                        visited[next[0]][next[1]] = id;
                        if(steps == D-1) {
                            replicate(next);
                            if(check(next, id+1)) {
                                queue.offer(next);
                                visited[next[0]][next[1]] = id+1;
                            }
                        } else {
                            queue.offer(next);
                        }
                    }
                }
            }
            steps = (steps+1)%D;
            if(steps == 0) {
                id++;
            }
        }
        res = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                fill(i, j, visited[i][j]);
            }
        }
        int ans = 0;
        for(boolean[] i: res) {
            for(boolean j: i) {
                if(j) {
                    ans++;
                }
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}