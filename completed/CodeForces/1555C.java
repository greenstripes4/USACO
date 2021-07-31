import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int m = Integer.parseInt(f.readLine());
            int[][] a = new int[2][m+1];
            for(int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                for(int j = 1; j <= m; j++) {
                    a[i][j] = a[i][j-1]+Integer.parseInt(st.nextToken());
                }
            }
            int ans = Integer.MAX_VALUE;
            for(int i = 1; i <= m; i++) {
                ans = Math.min(ans, Math.max(a[0][m]-a[0][i], a[1][i-1]));
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}