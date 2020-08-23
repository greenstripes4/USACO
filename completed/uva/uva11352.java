import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            char[][] grid = new char[M][N];
            for(int i = 0; i < M; i++) {
                grid[i] = f.readLine().toCharArray();
            }
            boolean[][] visited = new boolean[M][N];
            int sourceR = -1;
            int sourceC = -1;
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(grid[i][j] == 'A') {
                        sourceR = i;
                        sourceC = j;
                    }
                }
            }
            Queue<Integer> queueR = new LinkedList<>();
            Queue<Integer> queueC = new LinkedList<>();
            queueR.offer(sourceR);
            queueC.offer(sourceC);
            int steps = 0;
            int[][] kingMoves = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
            int[][] knightMoves = {{-2,-1},{-2,1},{2,-1},{2,1},{-1,2},{-1,-2},{1,2},{1,-2}};
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(grid[i][j] == 'Z') {
                        for(int[] k: knightMoves) {
                            int nextR = i+k[0];
                            int nextC = j+k[1];
                            if(nextR < 0 || nextC < 0 || nextR >= M || nextC >= N || grid[nextR][nextC] != '.') {
                                continue;
                            }
                            grid[nextR][nextC] = 'Y';
                        }
                    }
                }
            }
            boolean found = false;
            while(!queueR.isEmpty()) {
                int size = queueR.size();
                for(int i = 0; i < size; i++) {
                    int tempR = queueR.poll();
                    int tempC = queueC.poll();
                    if(grid[tempR][tempC] == 'B') {
                        found = true;
                        out.println("Minimal possible length of a trip is " + steps);
                        break;

                    }
                    for(int[] j: kingMoves) {
                        int nextR = tempR+j[0];
                        int nextC = tempC+j[1];
                        if(nextR < 0 || nextC < 0 || nextR >= M || nextC >= N || visited[nextR][nextC] || grid[nextR][nextC] == 'Z' || grid[nextR][nextC] == 'Y') {
                            continue;
                        }
                        queueR.offer(nextR);
                        queueC.offer(nextC);
                        visited[nextR][nextC] = true;
                    }
                }
                steps++;
            }
            if(!found) {
                out.println("King Peter, you can't go now!");
            }
        }
        f.close();
        out.close();
    }
}
