import java.io.*;
import java.util.*;

public class Main {
    private static boolean inRange(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] arr = new char[n][m];
            for(int i = 0; i < n; i++) {
                arr[i] = f.readLine().toCharArray();
            }
            Queue<int[]> queue = new LinkedList<>();
            int[] strt = new int[2];
            int[] targ = new int[2];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] == 'S') {
                        strt[0] = i;
                        strt[1] = j;
                    } else if(arr[i][j] == 'F') {
                        targ[0] = i;
                        targ[1] = j;
                    }
                }
            }
            boolean[][] visited = new boolean[n][m];
            queue.offer(strt);
            visited[strt[0]][strt[1]] = true;
            int[] dirr = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dirc = {-1, 0, 1, -1, 1, -1, 0, 1};
            int steps = 0;
            boolean found = false;
            while(!queue.isEmpty()) {
                int size = queue.size();
                while(size-- > 0) {
                    int[] cur = queue.poll();
                    if(cur[0] == targ[0] && cur[1] == targ[1]) {
                        found = true;
                        break;
                    }
                    for(int i = 0; i < 8; i++) {
                        int nextr = cur[0];
                        int nextc = cur[1];
                        while(inRange(nextr, nextc, n, m) && arr[nextr][nextc] != 'X') {
                            if(!visited[nextr][nextc]) {
                                queue.offer(new int[]{nextr, nextc});
                                visited[nextr][nextc] = true;
                            }
                            nextr += dirr[i];
                            nextc += dirc[i];
                        }
                    }
                }
                if(found) {
                    break;
                }
                steps++;
            }
            out.println(found ? steps : -1);
        }
        f.close();
        out.close();
    }
}
