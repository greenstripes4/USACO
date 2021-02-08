import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> monsters = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            map[i] = f.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'A') {
                    queue.offer(new int[]{i, j});
                } else if(map[i][j] == 'M') {
                    monsters.offer(new int[]{i, j});
                }
            }
        }
        int[][] path = new int[n][m];
        for(int[] i: path) {
            Arrays.fill(i, -1);
        }
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int[] found = new int[2];
        found[0] = -1;
        while(!queue.isEmpty()) {
            int numMonsters = monsters.size();
            for(int i = 0; i < numMonsters; i++) {
                int[] temp = monsters.poll();
                for(int[] j: directions) {
                    int[] next = {temp[0]+j[0], temp[1]+j[1]};
                    if(next[0] >= 0 && next[0] < n && next[1] >= 0 && next[1] < m && map[next[0]][next[1]] == '.') {
                        monsters.offer(next);
                        map[next[0]][next[1]] = 'M';
                    }
                }
            }
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                if(temp[0] == 0 || temp[0] == n-1 || temp[1] == 0 || temp[1] == m-1) {
                    found[0] = temp[0];
                    found[1] = temp[1];
                    break;
                }
                for(int j = 0; j < 4; j++) {
                    int[] next = {temp[0]+directions[j][0], temp[1]+directions[j][1]};
                    if(next[0] >= 0 && next[0] < n && next[1] >= 0 && next[1] < m && map[next[0]][next[1]] == '.' && path[next[0]][next[1]] == -1) {
                        queue.offer(next);
                        path[next[0]][next[1]] = 3-j;
                    }
                }
            }
            if(found[0] >= 0) {
                break;
            }
        }
        if(found[0] < 0) {
            out.println("NO");
        } else {
            out.println("YES");
            StringBuilder sb = new StringBuilder();
            while(map[found[0]][found[1]] != 'A') {
                int temp = path[found[0]][found[1]];
                found[0] += directions[temp][0];
                found[1] += directions[temp][1];
                sb.append(temp == 0 ? 'D' : temp == 1 ? 'R' : temp == 2 ? 'L' : 'U');
            }
            sb.reverse();
            out.println(sb.length());
            out.println(sb);
        }
        f.close();
        out.close();
    }
}