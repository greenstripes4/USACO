import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int M = f.nextInt();
            int N = f.nextInt();
            if(M == 0 && N == 0) {
                break;
            }
            int[][] grid = new int[M][N];
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    grid[i][j] = f.nextInt();
                }
            }
            int sourceR = f.nextInt();
            int sourceC = f.nextInt();
            int destinationR = f.nextInt();
            int destinationC = f.nextInt();
            char orientation = f.next().charAt(0);
            int orientationInd;
            switch(orientation) {
                case 'n':
                    orientationInd = 0;
                    break;
                case 'e':
                    orientationInd = 1;
                    break;
                case 's':
                    orientationInd = 2;
                    break;
                default:
                    orientationInd = 3;
                    break;
            }
            boolean[][][] visited = new boolean[M][N][4];
            Queue<Integer> queueR = new LinkedList<>();
            Queue<Integer> queueC = new LinkedList<>();
            Queue<Integer> queueO = new LinkedList<>();
            queueR.offer(sourceR);
            queueC.offer(sourceC);
            queueO.offer(orientationInd);
            visited[sourceR][sourceC][orientationInd] = true;
            int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
            int steps = 0;
            boolean found = false;
            while(!queueR.isEmpty()) {
                int size = queueR.size();
                for(int i = 0; i < size; i++) {
                    int tempR = queueR.poll();
                    int tempC = queueC.poll();
                    int tempO = queueO.poll();
                    if(tempR == destinationR && tempC == destinationC) {
                        found = true;
                        out.println(steps);
                        break;
                    }
                    if(!visited[tempR][tempC][(tempO+1)%4]) {
                        visited[tempR][tempC][(tempO+1)%4] = true;
                        queueR.offer(tempR);
                        queueC.offer(tempC);
                        queueO.offer((tempO+1)%4);
                    }
                    if(!visited[tempR][tempC][(tempO+3)%4]) {
                        visited[tempR][tempC][(tempO+3)%4] = true;
                        queueR.offer(tempR);
                        queueC.offer(tempC);
                        queueO.offer((tempO+3)%4);
                    }
                    for(int j = 1; j <= 3; j++) {
                        int nextR = tempR+directions[tempO][0]*j;
                        int nextC = tempC+directions[tempO][1]*j;
                        if(nextR > 0 && nextC > 0 && nextR < M && nextC < N &&
                                !visited[nextR][nextC][tempO] &&
                                grid[nextR-1][nextC-1] == 0 && grid[nextR-1][nextC] == 0 && grid[nextR][nextC-1] == 0 && grid[nextR][nextC] == 0) {
                            visited[nextR][nextC][tempO] = true;
                            queueR.offer(nextR);
                            queueC.offer(nextC);
                            queueO.offer(tempO);
                        } else {
                            break;
                        }
                    }
                }
                if(found) {
                    break;
                }
                steps++;
            }
            if(!found) {
                out.println(-1);
            }
        }
        f.close();
        out.close();
    }
}
