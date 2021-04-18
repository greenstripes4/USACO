import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[][] arr = new int[305][305];
        for(int[] i: arr) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        int M = Integer.parseInt(f.readLine());
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int Xi = Integer.parseInt(st.nextToken());
            int Yi = Integer.parseInt(st.nextToken());
            int Ti = Integer.parseInt(st.nextToken());
            arr[Xi][Yi] = Math.min(arr[Xi][Yi], Ti);
            for(int j = 0; j < 4; j++) {
                int nx = Xi+dx[j];
                int ny = Yi+dy[j];
                if(nx >= 0 && nx < 305 && ny >= 0 && ny < 305) {
                    arr[nx][ny] = Math.min(arr[nx][ny], Ti);
                }
            }
        }
        Queue<Integer> qX = new LinkedList<Integer>();
        Queue<Integer> qY = new LinkedList<Integer>();
        boolean[][] visited = new boolean[305][305];
        qX.offer(0);
        qY.offer(0);
        int steps = 0;
        boolean found = false;
        while(!qX.isEmpty()) {
            int size = qX.size();
            for(int i = 0; i < size; i++) {
                int x = qX.poll();
                int y = qY.poll();
                if(x >= 0 && x < 305 && y >= 0 && y < 305 && steps < arr[x][y] && !visited[x][y]) {
                    if(arr[x][y] == Integer.MAX_VALUE) {
                        found = true;
                        break;
                    }
                    visited[x][y] = true;
                    for(int j = 0; j < 4; j++) {
                        qX.offer(x+dx[j]);
                        qY.offer(y+dy[j]);
                    }
                }
            }
            if(found) {
                break;
            }
            steps++;
        }
        out.println(found ? steps : -1);
        f.close();
        out.close();
    }
}