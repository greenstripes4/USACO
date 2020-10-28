import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            int n = f.nextInt();
            int[][] cnt = new int[n+1][10];
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j < 10; j++) {
                    cnt[i][j] = cnt[i-1][j];
                }
                cnt[i][f.nextInt()]++;
            }
            int q = f.nextInt();
            for(int i = 0; i < q; i++) {
                int l = f.nextInt();
                int r = f.nextInt();
                int ans = 0;
                for(int j = 0; j < 10; j++) {
                    ans += cnt[r][j]-cnt[l-1][j] > 0 ? 1 : 0;
                }
                out.println(ans);
            }
        }
        f.close();
        out.close();
    }
}
