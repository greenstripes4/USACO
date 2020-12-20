import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] lake = new int[r][c];
        for(int i = 0; i < r; i++) {
            char[] temp = f.readLine().toCharArray();
            for(int j = 0; j < c; j++) {
                lake[i][j] = Character.getNumericValue(temp[j]);
            }
        }
        int[] dR = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dC = {0, 1, 1, 1, 0, -1, -1, -1};
        int n = Integer.parseInt(f.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int rs = Integer.parseInt(st.nextToken())-1;
            int cs = Integer.parseInt(st.nextToken())-1;
            int rd = Integer.parseInt(st.nextToken())-1;
            int cd = Integer.parseInt(st.nextToken())-1;
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[2]-t1[2];
                }
            });
            queue.offer(new int[]{rs, cs, 0});
            int[][] visited = new int[r][c];
            for(int[] j: visited) {
                Arrays.fill(j, Integer.MAX_VALUE);
            }
            visited[rs][cs] = 0;
            while(!queue.isEmpty()) {
                int[] temp = queue.poll();
                if(temp[0] == rd && temp[1] == cd) {
                    out.println(temp[2]);
                    break;
                }
                for(int j = 0; j < 8; j++) {
                    int nR = temp[0]+dR[j];
                    int nC = temp[1]+dC[j];
                    if(nR < 0 || nR >= r || nC < 0 || nC >= c || temp[2]+(j == lake[temp[0]][temp[1]] ? 0 : 1) >= visited[nR][nC]) {
                        continue;
                    }
                    int[] next = {nR, nC, temp[2]+(j == lake[temp[0]][temp[1]] ? 0 : 1)};
                    queue.offer(next);
                    visited[nR][nC] = next[2];
                }
            }
        }
        f.close();
        out.close();
    }
}
