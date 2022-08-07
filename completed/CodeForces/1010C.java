import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("threesum.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int gcd = k;
        for(int i = 0; i < n; i++) {
            gcd = gcd(gcd, Integer.parseInt(st.nextToken()));
        }
        int step = gcd%k;
        if(step == 0) {
            out.println(1);
            out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            int ans = 0;
            for(int i = 0; i < k; i += step) {
                ans++;
                sb.append(i);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            out.println(ans);
            out.println(sb);
        }
        f.close();
        out.close();
    }
}