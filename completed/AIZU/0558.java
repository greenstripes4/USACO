import java.io.*;
import java.util.*;

public class Main {
    private static int bfs(char[][] arr, int sr, int sc, int dr, int dc) {
        Queue<Integer> queueR = new LinkedList<>();
        Queue<Integer> queueC = new LinkedList<>();
        boolean[][] vis = new boolean[arr.length][arr[0].length];
        queueR.offer(sr);
        queueC.offer(sc);
        vis[sr][sc] = true;
        int steps = 0;
        int[] dirR = {-1, 0, 0, 1};
        int[] dirC = {0, -1, 1, 0};
        while(!queueR.isEmpty()) {
            int size = queueR.size();
            for(int i = 0; i < size; i++) {
                int nr = queueR.poll();
                int nc = queueC.poll();
                if(nr == dr && nc == dc) {
                    return steps;
                }
                for(int j = 0; j < 4; j++) {
                    int tr = nr+dirR[j];
                    int tc = nc+dirC[j];
                    if(tr < 0 || tr >= arr.length || tc < 0 || tc >= arr[0].length || arr[tr][tc] == 'X' || vis[tr][tc]) {
                        continue;
                    }
                    queueR.offer(tr);
                    queueC.offer(tc);
                    vis[tr][tc] = true;
                }
            }
            steps++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][] arr = new char[H][W];
        int[][] map = new int[N+1][2];
        for(int i = 0; i < H; i++) {
            arr[i] = f.readLine().toCharArray();
            for(int j = 0; j < W; j++) {
                if(arr[i][j] == 'S') {
                    map[0][0] = i;
                    map[0][1] = j;
                    arr[i][j] = '.';
                } else if(arr[i][j] >= '0' && arr[i][j] <= '9') {
                    map[arr[i][j]-'0'][0] = i;
                    map[arr[i][j]-'0'][1] = j;
                    arr[i][j] = '.';
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += bfs(arr, map[i][0], map[i][1], map[i+1][0], map[i+1][1]);
        }
        out.println(sum);
        f.close();
        out.close();
    }
}