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
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] maze = new char[n][];
        for(int i = 0; i < n; i++) {
            maze[i] = f.readLine().toCharArray();
        }
        if(k%2 == 1) {
            out.println("IMPOSSIBLE");
        } else {
            int[][] shortestPaths = new int[n][m];
            int robotRow = -1;
            int robotColumn = -1;
            for(int i = 0; i < n; i++) {
                Arrays.fill(shortestPaths[i], -1);
                for(int j = 0; j < m; j++) {
                    if(maze[i][j] == 'X') {
                        robotRow = i;
                        robotColumn = j;
                    }
                }
            }
            int[] directionsRow = {1, 0, 0, -1};
            int[] directionsColumn = {0, -1, 1, 0};
            char[] directions = {'D', 'L', 'R', 'U'};
            Queue<Integer> queueRow = new LinkedList<>();
            Queue<Integer> queueColumn = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];
            queueRow.offer(robotRow);
            queueColumn.offer(robotColumn);
            visited[robotRow][robotColumn] = true;
            int steps = 0;
            while(!queueRow.isEmpty()) {
                int size = queueRow.size();
                for(int i = 0; i < size; i++) {
                    int tempRow = queueRow.poll();
                    int tempColumn = queueColumn.poll();
                    shortestPaths[tempRow][tempColumn] = steps;
                    for(int j = 0; j < 4; j++) {
                        int nextRow = tempRow+directionsRow[j];
                        int nextColumn = tempColumn+directionsColumn[j];
                        if(nextRow < 0 || nextColumn < 0 || nextRow >= n || nextColumn >= m || maze[nextRow][nextColumn] == '*' || visited[nextRow][nextColumn]) {
                            continue;
                        }
                        queueRow.offer(nextRow);
                        queueColumn.offer(nextColumn);
                        visited[nextRow][nextColumn] = true;
                    }
                }
                steps++;
            }
            StringBuilder sb = new StringBuilder();
            while(k > 0) {
                int nextRobotRow = robotRow;
                int nextRobotColumn = robotColumn;
                for(int i = 0; i < 4; i++) {
                    int nextRow = robotRow+directionsRow[i];
                    int nextColumn = robotColumn+directionsColumn[i];
                    if(nextRow < 0 || nextColumn < 0 || nextRow >= n || nextColumn >= m || maze[nextRow][nextColumn] == '*' || shortestPaths[nextRow][nextColumn] > k) {
                        continue;
                    }
                    nextRobotRow = nextRow;
                    nextRobotColumn = nextColumn;
                    sb.append(directions[i]);
                    break;
                }
                if(robotRow == nextRobotRow && robotColumn == nextRobotColumn) {
                    break;
                }
                robotRow = nextRobotRow;
                robotColumn = nextRobotColumn;
                k--;
            }
            out.println(k == 0 ? sb : "IMPOSSIBLE");
        }
        f.close();
        out.close();
    }
}
