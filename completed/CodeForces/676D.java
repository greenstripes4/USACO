import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("threesum.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][];
        for(int i = 0; i < n; i++) {
            arr[i] = f.readLine().toCharArray();
        }
        st = new StringTokenizer(f.readLine());
        int xt = Integer.parseInt(st.nextToken())-1;
        int yt = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(f.readLine());
        int xm = Integer.parseInt(st.nextToken())-1;
        int ym = Integer.parseInt(st.nextToken())-1;
        Queue<int[]> queue = new LinkedList<>();
        int[][][] visited = new int[n][m][4];
        for(int[][] i: visited) {
            for(int[] j: i) {
                Arrays.fill(j, -1);
            }
        }
        char[][] doors = {{'+'}, {'*'}, {'-', '|'}, {'^', '>', 'v', '<'}, {'L', 'U', 'R', 'D'}};
        boolean[][][] valid = {{{true, true, true, true}}, {{false, false, false, false}}, {{true, false, true, false}, {false, true, false, true}},
            {{false, true, false, false}, {false, false, true, false}, {false, false, false, true}, {true, false, false, false}},
            {{false, true, true, true}, {true, false, true, true}, {true, true, false, true}, {true, true, true, false}}};
        int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        queue.offer(new int[]{xt, yt, 0});
        visited[xt][yt][0] = 0;
        boolean flag = false;
        while(!queue.isEmpty()) {
            int[] u = queue.poll();
            if(u[0] == xm && u[1] == ym) {
                flag = true;
                out.println(visited[xm][ym][u[2]]);
                break;
            }
            if(visited[u[0]][u[1]][(u[2]+1)%4] == -1) {
                queue.offer(new int[]{u[0], u[1], (u[2]+1)%4});
                visited[u[0]][u[1]][(u[2]+1)%4] = visited[u[0]][u[1]][u[2]]+1;
            }
            for(int i = 0; i < 4; i++) {
                int[] v = {u[0]+dir[i][0], u[1]+dir[i][1], u[2]};
                if(v[0] < 0 || v[0] >= n || v[1] < 0 || v[1] >= m || visited[v[0]][v[1]][v[2]] != -1) {
                    continue;
                }
                int[] cur = new int[2];
                int[] next = new int[2];
                for(int j = 0; j < 5; j++) {
                    for(int k = 0; k < doors[j].length; k++) {
                        if(doors[j][k] == arr[u[0]][u[1]]) {
                            cur[0] = j;
                            cur[1] = (k+u[2])%doors[j].length;
                        }
                        if(doors[j][k] == arr[v[0]][v[1]]) {
                            next[0] = j;
                            next[1] = (k+v[2])%doors[j].length;
                        }
                    }
                }
                if(valid[cur[0]][cur[1]][i] && valid[next[0]][next[1]][(i+2)%4]) {
                    queue.offer(v);
                    visited[v[0]][v[1]][v[2]] = visited[u[0]][u[1]][u[2]]+1;
                }
            }
        }
        if(!flag) {
            out.println(-1);
        }
        f.close();
        out.close();
    }
}