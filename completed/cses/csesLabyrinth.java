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
        char[][] map = new char[n][];
        int[] start = new int[2];
        int[] end = new int[2];
        start[0] = -1;
        end[0] = -1;
        for(int i = 0; i < n; i++) {
            map[i] = f.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'A') {
                    start[0] = i;
                    start[1] = j;
                } else if(map[i][j] == 'B') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        map[end[0]][end[1]] = '.';
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        queue.offer(start);
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            if(temp[0] == end[0] && temp[1] == end[1]) {
                break;
            }
            for(int i = 0; i < 4; i++) {
                int[] next = {temp[0]+directions[i][0], temp[1]+directions[i][1]};
                if(next[0] >= 0 && next[0] < n && next[1] >= 0 && next[1] < m && map[next[0]][next[1]] == '.') {
                    queue.offer(next);
                    map[next[0]][next[1]] = (char) (3-i);
                }
            }
        }
        if(map[end[0]][end[1]] == '.') {
            out.println("NO");
        } else {
            out.println("YES");
            StringBuilder sb = new StringBuilder();
            while(map[end[0]][end[1]] != 'A') {
                int temp = map[end[0]][end[1]];
                end[0] += directions[temp][0];
                end[1] += directions[temp][1];
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