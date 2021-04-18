import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int C = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] c = new int[C][2];
        for(int i = 0; i < C; i++) {
            st = new StringTokenizer(f.readLine());
            c[i][0] = Integer.parseInt(st.nextToken());
            c[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] l = new int[L][2];
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(f.readLine());
            l[i][0] = Integer.parseInt(st.nextToken());
            l[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(c, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        Arrays.sort(l, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(11);
        int ans = 0;
        int idx = 0;
        for(int[] i: l) {
            while(idx < C && c[idx][0] <= i[0]) {
                queue.offer(c[idx++][1]);
            }
            while(i[1] > 0 && !queue.isEmpty()) {
                int temp = queue.poll();
                if(temp >= i[0]) {
                    ans++;
                    i[1]--;
                }
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}