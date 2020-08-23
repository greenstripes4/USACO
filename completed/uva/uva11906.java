import java.io.*;
import java.util.*;

public class Main {
    private static int R, C;
    private static boolean[][] water;
    private static boolean[][] visited;
    private static int[][] movements;
    private static void floodFill(int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || water[r][c] || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        for(int[] i: movements) {
            floodFill(r+i[0],c+i[1]);
        }
    }
    private static int getCount(int r, int c) {
        int count = 0;
        boolean[][] currentVisited = new boolean[R][C];
        for(int[] i: movements) {
            int nextR = r+i[0];
            int nextC = c+i[1];
            if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || !visited[nextR][nextC] || currentVisited[nextR][nextC]) {
                continue;
            }
            currentVisited[nextR][nextC] = true;
            count++;
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            water = new boolean[R][C];
            visited = new boolean[R][C];
            movements = new int[][]{{-M,-N},{-M,N},{M,-N},{M,N},{-N,-M},{-N,M},{N,-M},{N,M}};
            int W = Integer.parseInt(f.readLine());
            for(int i = 0; i < W; i++) {
                StringTokenizer coordinate = new StringTokenizer(f.readLine());
                water[Integer.parseInt(coordinate.nextToken())][Integer.parseInt(coordinate.nextToken())] = true;
            }
            floodFill(0,0);
            int evenCounts = 0;
            int oddCounts = 0;
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(visited[i][j]) {
                        if(getCount(i,j)%2 == 0) {
                            evenCounts++;
                        } else {
                            oddCounts++;
                        }
                    }
                }
            }
            out.println("Case " + t + ": " + evenCounts + " " + oddCounts);
        }
        f.close();
        out.close();
    }
}
