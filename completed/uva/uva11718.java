import java.io.*;
import java.util.*;

public class Main{
    private static long pow(long b, long p, long MOD) {
        if(p == 0) {
            return 1;
        }
        if(p%2 == 0) {
            long val = pow(b, p/2, MOD);
            return (val*val)%MOD;
        }
        return ((b%MOD)*pow(b, p-1, MOD))%MOD;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long n = Integer.parseInt(st.nextToken());
            long K = Integer.parseInt(st.nextToken());
            long MOD = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            long sum = 0;
            for(int i = 0; i < n; i++) {
                sum += Integer.parseInt(st.nextToken())%MOD;
                sum %= MOD;
            }
            out.println("Case " + t + ": " + (pow(n, K-1, MOD)*(K%MOD)*sum)%MOD);
        }
        f.close();
        out.close();
    }
}
