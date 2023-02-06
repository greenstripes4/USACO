import java.io.*;
import java.util.*;

public class Main {
    private static class State {
        private int x1;
        private int y1;
        private int z1;
        private int x2;
        private int y2;
        private int z2;
        private State(int x1, int y1, int z1, int x2, int y2, int z2) {
            this.x1 = x1;
            this.y1 = y1;
            this.z1 = z1;
            this.x2 = x2;
            this.y2 = y2;
            this.z2 = z2;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cownav.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownav.out")));
        int N = Integer.parseInt(f.readLine());
        char[][] barn = new char[N][N];
        for(int i = 0; i < N; i++) {
            barn[i] = f.readLine().toCharArray();
        }
        Queue<State> queue = new LinkedList<>();
        boolean[][][][][][] visited = new boolean[N][N][4][N][N][4];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        queue.offer(new State(N-1, 0, 0, N-1, 0, 1));
        visited[N-1][0][0][N-1][0][1] = true;
        int steps = 0;
        boolean flag = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                State cur = queue.poll();
                if(cur.x1 == 0 && cur.y1 == N-1 && cur.x2 == 0 && cur.y2 == N-1) {
                    flag = true;
                    break;
                }
                State next = new State(cur.x1, cur.y1, (cur.z1+1)%4, cur.x2, cur.y2, (cur.z2+1)%4);
                if(!visited[next.x1][next.y1][next.z1][next.x2][next.y2][next.z2]) {
                    queue.offer(next);
                    visited[next.x1][next.y1][next.z1][next.x2][next.y2][next.z2] = true;
                }
                next = new State(cur.x1, cur.y1, (cur.z1+3)%4, cur.x2, cur.y2, (cur.z2+3)%4);
                if(!visited[next.x1][next.y1][next.z1][next.x2][next.y2][next.z2]) {
                    queue.offer(next);
                    visited[next.x1][next.y1][next.z1][next.x2][next.y2][next.z2] = true;
                }
                next = new State(cur.x1, cur.y1, cur.z1, cur.x2, cur.y2, cur.z2);
                if(!(next.x1 == 0 && next.y1 == N-1) && next.x1+dr[next.z1] >= 0 && next.x1+dr[next.z1] < N && next.y1+dc[next.z1] >= 0 && next.y1+dc[next.z1] < N && barn[next.x1+dr[next.z1]][next.y1+dc[next.z1]] == 'E') {
                    next.x1 += dr[next.z1];
                    next.y1 += dc[next.z1];
                }
                if(!(next.x2 == 0 && next.y2 == N-1) && next.x2+dr[next.z2] >= 0 && next.x2+dr[next.z2] < N && next.y2+dc[next.z2] >= 0 && next.y2+dc[next.z2] < N && barn[next.x2+dr[next.z2]][next.y2+dc[next.z2]] == 'E') {
                    next.x2 += dr[next.z2];
                    next.y2 += dc[next.z2];
                }
                if(!visited[next.x1][next.y1][next.z1][next.x2][next.y2][next.z2]) {
                    queue.offer(next);
                    visited[next.x1][next.y1][next.z1][next.x2][next.y2][next.z2] = true;
                }
            }
            if(flag) {
                break;
            }
            steps++;
        }
        out.println(steps);
        f.close();
        out.close();
    }
}
