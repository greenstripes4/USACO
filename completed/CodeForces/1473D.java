import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[] s = f.readLine().toCharArray();
            int[][] prefixQueries = new int[n+1][3];
            int cur = 0;
            for(int i = 1; i <= n; i++) {
                cur += s[i-1] == '+' ? 1 : -1;
                prefixQueries[i][0] = Math.min(prefixQueries[i-1][0], cur);
                prefixQueries[i][1] = Math.max(prefixQueries[i-1][1], cur);
                prefixQueries[i][2] = cur;
            }
            int[][] suffixQueries = new int[n+2][2];
            for(int i = n; i > 0; i--) {
                int temp = s[i-1] == '+' ? 1 : -1;
                suffixQueries[i][0] = Math.min(suffixQueries[i+1][0]+temp, temp);
                suffixQueries[i][1] = Math.max(suffixQueries[i+1][1]+temp, temp);
            }
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int min = Math.min(prefixQueries[l-1][0], suffixQueries[r+1][0]+prefixQueries[l-1][2]);
                int max = Math.max(prefixQueries[l-1][1], suffixQueries[r+1][1]+prefixQueries[l-1][2]);
                out.println(max-min+1);
            }
        }
        f.close();
        out.close();
    }
}