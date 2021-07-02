import java.io.*;
import java.util.*;

public class Main {
    private static long f(long l, long r) {
        if(l == r) {
            return l;
        }
        long cur = 1;
        while(cur <= r) {
            cur *= 2;
        }
        cur /= 2;
        if(cur <= l) {
            return f(l-cur, r-cur)+cur;
        }
        if(cur*2-1 <= r) {
            return cur*2-1;
        }
        return cur-1;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            out.println(f(l, r));
        }
        f.close();
        out.close();
    }
}