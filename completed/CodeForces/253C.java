import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        boolean[][] visited = new boolean[n][];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            visited[i] = new boolean[a[i]+1];
        }
        st = new StringTokenizer(f.readLine());
        int r1 = Integer.parseInt(st.nextToken())-1;
        int c1 = Integer.parseInt(st.nextToken())-1;
        int r2 = Integer.parseInt(st.nextToken())-1;
        int c2 = Integer.parseInt(st.nextToken())-1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r1, c1});
        visited[r1][c1] = true;
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        int steps = 0;
        boolean found = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] cur = queue.poll();
                if(cur[0] == r2 && cur[1] == c2) {
                    found = true;
                    break;
                }
                for(int i = 0; i < 4; i++) {
                    int nextr = cur[0]+dr[i];
                    int nextc = cur[1]+dc[i];
                    nextr = Math.max(0, nextr);
                    nextr = Math.min(n-1, nextr);
                    nextc = Math.max(0, nextc);
                    nextc = Math.min(a[nextr], nextc);
                    if(visited[nextr][nextc]) {
                        continue;
                    }
                    queue.offer(new int[]{nextr, nextc});
                    visited[nextr][nextc] = true;
                }
            }
            if(found) {
                break;
            }
            steps++;
        }
        out.println(steps);
        f.close();
        out.close();
    }
}
