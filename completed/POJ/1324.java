import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        while(true) {
            int n = f.nextInt();
            int m = f.nextInt();
            int L = f.nextInt();
            if(n == 0 && m == 0 && L == 0) {
                break;
            }
            int pr = f.nextInt()-1;
            int pc = f.nextInt()-1;
            int tr = pr;
            int tc = pc;
            long start = pr*100+pc;
            int[] dr = {1, 0, -1, 0};
            int[] dc = {0, 1, 0, -1};
            for(int i = 1; i < L; i++) {
                int cr = f.nextInt()-1;
                int cc = f.nextInt()-1;
                for(int j = 0; j < 4; j++) {
                    if(pr+dr[j] == cr && pc+dc[j] == cc) {
                        start = start*10+j;
                        break;
                    }
                }
                pr = cr;
                pc = cc;
            }
            int w = f.nextInt();
            int[][] walls = new int[w][2];
            for(int i = 0; i < w; i++) {
                walls[i][0] = f.nextInt()-1;
                walls[i][1] = f.nextInt()-1;
            }
            PriorityQueue<long[]> queue = new PriorityQueue<long[]>(11, new Comparator<long[]>() {
                @Override
                public int compare(long[] longs, long[] t1) {
                    long temp1 = longs[1]+longs[2]+longs[3];
                    long temp2 = t1[1]+t1[2]+t1[3];
                    return temp1 < temp2 ? -1 : temp1 > temp2 ? 1 : 0;
                }
            });
            HashSet<Long> visited = new HashSet<Long>();
            queue.offer(new long[]{start, 0, tr, tc});
            visited.add(start);
            boolean found = false;
            while(!queue.isEmpty()) {
                long[] cur = queue.poll();
                int[] dir = new int[L-1];
                for(int i = L-2; i >= 0; i--) {
                    dir[i] = (int) (cur[0]%10);
                    cur[0] /= 10;
                }
                int[][] snake = new int[L][2];
                snake[0][0] = (int) (cur[0]/100);
                snake[0][1] = (int) (cur[0]%100);
                if(snake[0][0] == 0 && snake[0][1] == 0) {
                    found = true;
                    out.println("Case " + t + ": " + cur[1]);
                    break;
                }
                for(int i = 1; i < L; i++) {
                    snake[i][0] = snake[i-1][0]+dr[dir[i-1]];
                    snake[i][1] = snake[i-1][1]+dc[dir[i-1]];
                }
                for(int i = 0; i < 4; i++) {
                    int[] next = {snake[0][0]+dr[i], snake[0][1]+dc[i]};
                    if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m) {
                        continue;
                    }
                    boolean flag = false;
                    for(int[] j: walls) {
                        if(next[0] == j[0] && next[1] == j[1]) {
                            flag = true;
                            break;
                        }
                    }
                    if(flag) {
                        continue;
                    }
                    for(int[] j: snake) {
                        if(next[0] == j[0] && next[1] == j[1]) {
                            flag = true;
                            break;
                        }
                    }
                    if(flag) {
                        continue;
                    }
                    long encoded = next[0]*1000+next[1]*10+(i+2)%4;
                    for(int j = 0; j < L-2; j++) {
                        encoded = encoded*10+dir[j];
                    }
                    if(visited.contains(encoded)) {
                        continue;
                    }
                    queue.offer(new long[]{encoded, cur[1]+1, next[0], next[1]});
                    visited.add(encoded);
                }
            }
            if(!found) {
                out.println("Case " + t + ": -1");
            }
            t++;
        }
        f.close();
        out.close();
    }
}