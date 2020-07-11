import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("closing.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            char[][] maze = new char[R][C];
            HashSet<Integer> fire = new HashSet<>();
            int joePos = -1;
            for(int i = 0; i < R; i++) {
                maze[i] = f.readLine().toCharArray();
                for(int j = 0; j < C; j++) {
                    if(maze[i][j] == 'J') {
                        joePos = i*1000+j;
                        maze[i][j] = '.';
                    } else if(maze[i][j] == 'F') {
                        fire.add(i*1000+j);
                    }
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[(R-1)*1000+C];
            queue.add(joePos);
            visited[joePos] = true;
            int steps = 0;
            boolean found = false;
            int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
            while(!queue.isEmpty()) {
                steps++;
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    int temp = queue.poll();
                    int tempX = temp/1000;
                    int tempY = temp%1000;
                    if(maze[tempX][tempY] == '.') {
                        if(tempX == 0 || tempY == 0 || tempX == R-1 || tempY == C-1) {
                            found = true;
                            break;
                        }
                        for(int[] d: directions) {
                            int nextX = tempX+d[0];
                            int nextY = tempY+d[1];
                            int nextInt = nextX*1000+nextY;
                            if(maze[nextX][nextY] == '.' && !visited[nextInt]) {
                                queue.add(nextInt);
                                visited[nextInt] = true;
                            }
                        }
                    }
                }
                if(found) {
                    break;
                }
                HashSet<Integer> remove = new HashSet<>();
                HashSet<Integer> add = new HashSet<>();
                for(int i: fire) {
                    for(int[] d: directions) {
                        int nextX = i/1000+d[0];
                        int nextY = i%1000+d[1];
                        int nextInt = nextX*1000+nextY;
                        if(nextX >= 0 && nextY >= 0 && nextX < R && nextY < C && maze[nextX][nextY] == '.') {
                            maze[nextX][nextY] = 'F';
                            remove.add(i);
                            add.add(nextInt);
                        }
                    }
                }
                fire.removeAll(remove);
                fire.addAll(add);
            }
            if(found) {
                out.println(steps);
            } else {
                out.println("IMPOSSIBLE");
            }
        }
        f.close();
        out.close();
    }
}
