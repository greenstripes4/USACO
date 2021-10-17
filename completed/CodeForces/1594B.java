import java.io.*;
import java.util.*;

public class Main {
        private static final int MOD = 1000000007;
        private static int add(long a, long b) { return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD); }
        private static int multiply(long a, long b) {
                return (int) (((a%MOD)*(b%MOD))%MOD);
        }
        private static int power(long a, long b) {
                long c = 1;
                while(b > 0) {
                        if((b&1) > 0) {
                                c = multiply(c, a);
                        }
                        a = multiply(a, a);
                        b >>= 1;
                }
                return (int) c;
        }
        public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int n = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                char[] res = Integer.toBinaryString(k).toCharArray();
                long ans = 0;
                for(int i = 0; i < res.length; i++) {
                        if(res[i] == '1') {
                                ans = add(ans, power(n, res.length-i-1));
                        }
                }
                out.println(ans);
        }
        f.close();
        out.close();
    }
}
