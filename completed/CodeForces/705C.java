import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();
        int[] last = new int[n];
        int[] occ = new int[n];
        int ans = 0;
        int idx = 1;
        for(int i = 1; i <= q; i++) {
            st = new StringTokenizer(f.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type == 1) {
                int x = Integer.parseInt(st.nextToken())-1;
                queue.offer(new int[]{x, idx++, i});
                occ[x]++;
                ans++;
                out.println(ans);
            } else if(type == 2) {
                int x = Integer.parseInt(st.nextToken())-1;
                last[x] = i;
                ans -= occ[x];
                occ[x] = 0;
                out.println(ans);
            } else {
                int t = Integer.parseInt(st.nextToken());
                while(!queue.isEmpty() && queue.peek()[1] <= t) {
                    int[] next = queue.poll();
                    if(next[2] > last[next[0]]) {
                        occ[next[0]]--;
                        ans--;
                    }
                }
                out.println(ans);
            }
        }
        f.close();
        out.close();
    }
}
