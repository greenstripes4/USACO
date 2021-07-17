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
            int n = Integer.parseInt(f.readLine());
            int[][] a = new int[n][2];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                a[i][0] = Integer.parseInt(st.nextToken());
                a[i][1] = Integer.parseInt(st.nextToken());
            }
            int cur = 0;
            int tar = 0;
            int ans = 0;
            for(int i = 0; i < n-1; i++) {
                if(cur == tar) {
                    tar = a[i][1];
                }
                int prev = cur;
                if(cur < tar) {
                    cur = Math.min(tar, cur+a[i+1][0]-a[i][0]);
                } else {
                    cur = Math.max(tar, cur-a[i+1][0]+a[i][0]);
                }
                if(a[i][1] >= Math.min(prev, cur) && a[i][1] <= Math.max(prev, cur)) {
                    ans++;
                }
            }
            if(cur == tar) {
                tar = a[n-1][1];
            }
            if(a[n-1][1] >= Math.min(cur, tar) && a[n-1][1] <= Math.max(cur, tar)) {
                ans++;
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}