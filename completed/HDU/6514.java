import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(f.readLine());
            long[][] diff = new long[n+2][m+2];
            for(int i = 0; i < p; i++) {
                st = new StringTokenizer(f.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                diff[x1][y1]++;
                diff[x1][y2+1]--;
                diff[x2+1][y1]--;
                diff[x2+1][y2+1]++;
            }
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    diff[i][j] = diff[i][j]+diff[i-1][j]+diff[i][j-1]-diff[i-1][j-1];
                }
            }
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    diff[i][j] = Math.min(diff[i][j], 1);
                }
            }
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    diff[i][j] = diff[i][j]+diff[i-1][j]+diff[i][j-1]-diff[i-1][j-1];
                }
            }
            int q = Integer.parseInt(f.readLine());
            for(int i = 0; i < q; i++) {
                st = new StringTokenizer(f.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                long s = diff[x2][y2]-diff[x1-1][y2]-diff[x2][y1-1]+diff[x1-1][y1-1];
                int a = (x2-x1+1)*(y2-y1+1);
                out.println(s == a ? "YES" : "NO");
            }
        }
        f.close();
        out.close();
    }
}