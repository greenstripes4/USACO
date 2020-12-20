import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        char[][] labyrinth = new char[n][m];
        for(int i = 0; i < n; i++) {
            labyrinth[i] = f.readLine().toCharArray();
        }
        LinkedList<int[]> queue = new LinkedList<>();
        int[][][] visited = new int[n][m][2];
        for(int[][] i: visited) {
            for(int[] j: i) {
                j[0] = -1;
                j[1] = -1;
            }
        }
        queue.offer(new int[]{r, c, x, y});
        visited[r][c][0] = x;
        visited[r][c][1] = y;
        int[][] directions = {{-1, 0, 0, 0}, {0, -1, -1, 0}, {0, 1, 0, -1}, {1, 0, 0, 0}};
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int[] j: directions) {
                int[] next = {temp[0]+j[0], temp[1]+j[1], temp[2]+j[2], temp[3]+j[3]};
                if(next[0] < 0 || next[1] < 0 || next[2] < 0 || next[3] < 0 || next[0] >= n || next[1] >= m || labyrinth[next[0]][next[1]] == '*') {
                    continue;
                }
                if(visited[next[0]][next[1]][0] >= next[2] && visited[next[0]][next[1]][1] >= next[3]) {
                    continue;
                }
                queue.offer(next);
                visited[next[0]][next[1]][0] = Math.max(visited[next[0]][next[1]][0], next[2]);
                visited[next[0]][next[1]][1] = Math.max(visited[next[0]][next[1]][1], next[3]);
            }
        }
        int count = 0;
        for(int[][] i: visited) {
            for(int[] j: i) {
                if(j[0] > -1) {
                    count++;
                }
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}