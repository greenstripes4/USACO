import java.io.*;
import java.util.*;

public class Main {
    private static int compress(int[][] arr, int limit) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int[] i: arr) {
            set.add(i[0]-1);
            set.add(i[0]);
            set.add(i[0]+1);
            set.add(i[1]-1);
            set.add(i[1]);
            set.add(i[1]+1);
        }
        while(set.first() < 0) {
            set.remove(set.first());
        }
        while(set.last() > limit) {
            set.remove(set.last());
        }
        ArrayList<Integer> temp = new ArrayList<>(set);
        for(int[] i: arr) {
            i[0] = Collections.binarySearch(temp, i[0]);
            i[1] = Collections.binarySearch(temp, i[1]);
        }
        return temp.size()-2;
    }
    private static void bfs(boolean[][] flag, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()) {
            int[] next = queue.poll();
            if(next[0] < 0 || next[0] >= flag.length || next[1] < 0 || next[1] >= flag[0].length || flag[next[0]][next[1]]) {
                continue;
            }
            flag[next[0]][next[1]] = true;
            queue.offer(new int[]{next[0]-1, next[1]});
            queue.offer(new int[]{next[0]+1, next[1]});
            queue.offer(new int[]{next[0], next[1]-1});
            queue.offer(new int[]{next[0], next[1]+1});
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int w = f.nextInt();
            int h = f.nextInt();
            if(w == 0 && h == 0) {
                break;
            }
            int n = f.nextInt();
            int[][] x = new int[n][2];
            int[][] y = new int[n][2];
            for(int i = 0; i < n; i++) {
                x[i][0] = f.nextInt();
                y[i][0] = f.nextInt();
                x[i][1] = f.nextInt();
                y[i][1] = f.nextInt();
            }
            w = compress(x, w);
            h = compress(y, h);
            boolean[][] flag = new boolean[w+1][h+1];
            for(int i = 0; i < n; i++) {
                for(int j = x[i][0]; j < x[i][1]; j++) {
                    for(int k = y[i][0]; k < y[i][1]; k++) {
                        flag[j][k] = true;
                    }
                }
            }
            int count = 0;
            for(int i = 0; i <= w; i++) {
                for(int j = 0; j <= h; j++) {
                    if(!flag[i][j]) {
                        count++;
                        bfs(flag, i, j);
                    }
                }
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}