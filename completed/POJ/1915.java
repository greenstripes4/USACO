import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        while(n-- > 0) {
            int l = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(f.readLine());
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            Queue<int[]> queue = new LinkedList<int[]>();
            boolean[][] visited = new boolean[l][l];
            queue.offer(start);
            visited[start[0]][start[1]] = true;
            int[][] directions = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
            int steps = 0;
            boolean found = false;
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    int[] temp = queue.poll();
                    if(temp[0] == end[0] && temp[1] == end[1]) {
                        out.println(steps);
                        found = true;
                        break;
                    }
                    for(int[] j: directions) {
                        int[] next = {temp[0]+j[0], temp[1]+j[1]};
                        if(next[0] < 0 || next[0] >= l || next[1] < 0 || next[1] >= l || visited[next[0]][next[1]]) {
                            continue;
                        }
                        queue.offer(next);
                        visited[next[0]][next[1]] = true;
                    }
                }
                if(found) {
                    break;
                }
                steps++;
            }
        }
        f.close();
        out.close();
    }
}
