import sun.awt.im.CompositionArea;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] maze = new char[n][];
            for(int j = 0; j < n; j++) {
                maze[j] = f.readLine().toCharArray();
            }
            int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
            int goodPeople = 0;
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(maze[j][k] == 'B') {
                        for(int[] l: directions) {
                            int nextJ = j+l[0];
                            int nextK = k+l[1];
                            if(nextJ < 0 || nextJ >= n || nextK < 0 || nextK >= m || maze[nextJ][nextK] == 'B') {
                                continue;
                            }
                            if(maze[nextJ][nextK] == 'G') {
                                goodPeople = -1;
                                break;
                            }
                            maze[nextJ][nextK] = '#';
                        }
                    } else if(maze[j][k] == 'G') {
                        goodPeople++;
                    }
                    if(goodPeople < 0) {
                        break;
                    }
                }
                if(goodPeople < 0) {
                    break;
                }
            }
            if(goodPeople < 0 || (goodPeople > 0 && maze[n-1][m-1] != '.')) {
                out.println("No");
                continue;
            }
            LinkedList<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{n-1, m-1});
            boolean[][] visited = new boolean[n][m];
            visited[n-1][m-1] = true;
            int goodPeopleReached = 0;
            while(!queue.isEmpty()) {
                int[] temp = queue.poll();
                if(maze[temp[0]][temp[1]] == 'G') {
                    goodPeopleReached++;
                }
                for(int[] j: directions) {
                    int[] next = {temp[0]+j[0], temp[1]+j[1]};
                    if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m || maze[next[0]][next[1]] == '#' || visited[next[0]][next[1]]) {
                        continue;
                    }
                    queue.offer(next);
                    visited[next[0]][next[1]] = true;
                }
            }
            out.println(goodPeopleReached == goodPeople ? "Yes" : "No");
        }
        f.close();
        out.close();
    }
}
