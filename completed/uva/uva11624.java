import java.io.*;
import java.util.*;

class Position {
    int row;
    int column;
    char occupant;
    Position() {}
    Position(int row, int column, char occupant) {
        this.row = row;
        this.column = column;
        this.occupant = occupant;
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            char[][] maze = new char[R][C];
            for(int i = 0; i < R; i++) {
                maze[i] = f.readLine().toCharArray();
            }
            Queue<Position> queue = new LinkedList<>();
            Position joe = new Position();
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(maze[i][j] == 'F') {
                        queue.offer(new Position(i,j,'F'));
                    } else if(maze[i][j] == 'J') {
                        joe = new Position(i,j,'J');
                    }
                }
            }
            queue.offer(joe);
            boolean[][] visited = new boolean[R][C];
            visited[joe.row][joe.column] = true;
            int steps = 0;
            boolean found = false;
            int[] directionR = {-1,0,0,1};
            int[] directionC = {0,-1,1,0};
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    Position temp = queue.poll();
                    if(temp.occupant == 'J' && (temp.row == 0 || temp.row == R-1 || temp.column == 0 || temp.column == C-1)) {
                        steps++;
                        found = true;
                        break;
                    }
                    for(int j = 0; j < 4; j++) {
                        Position next = new Position(temp.row+directionR[j],temp.column+directionC[j],temp.occupant);
                        if(next.row < 0 || next.row >= R || next.column < 0 || next.column >= C || maze[next.row][next.column] == '#' || maze[next.row][next.column] == 'F' || visited[next.row][next.column]) {
                            continue;
                        }
                        visited[next.row][next.column] = true;
                        if(next.occupant == 'F') {
                            maze[next.row][next.column] = 'F';
                        }
                        queue.offer(next);
                    }
                }
                if(found) {
                    break;
                }
                steps++;
            }
            out.println(found ? steps : "IMPOSSIBLE");
        }
        f.close();
        out.close();
    }
}
