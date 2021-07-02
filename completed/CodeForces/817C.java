import java.io.*;
import java.util.*;

public class Main {
    private static long sum(long x) {
        long ans = 0;
        while(x > 0) {
            ans += x%10;
            x /= 10;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());
        if(n < s) {
            out.println(0);
        } else {
            long ans = 0;
            for(long i = s; i <= Math.min(n, s+162); i++) {
                if(i-sum(i) >= s) {
                    ans++;
                }
            }
            ans += n-Math.min(n, s+162);
            out.println(ans);
        }
        f.close();
        out.close();
    }
}