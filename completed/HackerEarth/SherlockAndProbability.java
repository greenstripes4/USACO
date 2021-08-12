import java.io.*;
import java.util.*;

public class Main {
    private static long gcd(long a, long b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Math.min(N-1, Integer.parseInt(st.nextToken()));
            char[] S = f.readLine().toCharArray();
            int cnt = 0;
            long ans = 0;
            for(int i = 0; i < N; i++) {
                if(S[i] == '1') {
                    ans += cnt*2+1;
                }
                cnt += S[i]-'0';
                cnt -= i >= K ? S[i-K]-'0' : 0;
            }
            long total = N*N;
            long gcd = gcd(ans, total);
            ans /= gcd;
            total /= gcd;
            out.println(ans + "/" + total);
        }
        f.close();
        out.close();
    }
}
