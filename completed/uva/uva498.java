import java.io.*;
import java.util.*;

public class Main {
    private static long power(long a, long b) {
        long c = 1;
        while(b > 0) {
            if((b&1) > 0) {
                c *= a;
            }
            a *= a;
            b >>= 1;
        }
        return c;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            long[] c = new long[st.countTokens()];
            for(int i = 0; i < c.length; i++) {
                c[c.length-i-1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            StringBuilder sb = new StringBuilder();
            while(st.hasMoreTokens()) {
                long x = Integer.parseInt(st.nextToken());
                long ans = 0;
                for(int i = 0; i < c.length; i++) {
                    ans += c[i]*power(x, i);
                }
                sb.append(ans);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            out.println(sb);
        }
        f.close();
        out.close();
    }
}
