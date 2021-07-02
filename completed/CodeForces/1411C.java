import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] next = new int[n+1];
            for(int i = 0; i < m; i++) {
                 st = new StringTokenizer(f.readLine());
                 int x = Integer.parseInt(st.nextToken());
                 int y = Integer.parseInt(st.nextToken());
                 next[x] = y;
            }
            boolean[] vis = new boolean[n+1];
            for(int i = 1; i <= n; i++) {
                if(vis[i]) {
                    continue;
                }
                if(next[i] == i) {
                    m--;
                } else {
                    int cur = i;
                    vis[i] = true;
                    while(next[cur] > 0 && !vis[next[cur]]) {
                        cur = next[cur];
                        vis[cur] = true;
                    }
                    if(next[cur] == i) {
                        m++;
                    }
                }
            }
            out.println(m);
        }
        f.close();
        out.close();
    }
}