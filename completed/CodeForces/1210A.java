import java.io.*;
import java.util.*;

public class Main {
    private static int[][] edges;
    private static int ans;
    private static void update(int[] a) {
        boolean[][] used = new boolean[7][7];
        int cur = 0;
        for(int[] i: edges) {
            if(!used[Math.min(a[i[0]], a[i[1]])][Math.max(a[i[0]], a[i[1]])]) {
                cur++;
                used[Math.min(a[i[0]], a[i[1]])][Math.max(a[i[0]], a[i[1]])] = true;
            }
        }
        ans = Math.max(ans, cur);
    }
    private static void dfs(int[] cur, int idx) {
        if(idx == cur.length) {
            update(cur);
            return;
        }
        for(int i = 1; i <= 6; i++) {
            cur[idx] = i;
            dfs(cur, idx+1);
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken())-1;
            edges[i][1] = Integer.parseInt(st.nextToken())-1;
        }
        ans = 0;
        dfs(new int[n], 0);
        out.println(ans);
        f.close();
        out.close();
    }
}