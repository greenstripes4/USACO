import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] cnt = new long[m];
        for(int i = 0; i < m; i++) {
            cnt[i] = n/m;
        }
        for(int i = n/m*m+1; i <= n; i++) {
            cnt[i%m]++;
        }
        long ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                if((i*i+j*j)%m == 0) {
                    ans += cnt[i]*cnt[j];
                }
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}