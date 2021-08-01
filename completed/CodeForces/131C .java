import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long[][] C = new long[31][31];
        for(int i = 0; i <= 30; i++) {
            C[i][0] = 1;
        }
        for(int i = 1; i <= 30; i++) {
            for(int j = 1; j <= i; j++) {
                C[i][j] = C[i-1][j-1]+C[i-1][j];
            }
        }
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        long ans = 0;
        for(int i = 4; i < t; i++) {
            if(i > n || t-i > m) {
                continue;
            }
            ans += C[n][i]*C[m][t-i];
        }
        out.println(ans);
        f.close();
        out.close();
    }
}