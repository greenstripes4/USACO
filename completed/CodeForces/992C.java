import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 1000000007;
    private static int add(long a, long b) {
        return (int) ((a%MOD+b%MOD+MOD)%MOD);
    }
    private static int subtract(long a, long b) {
        return add(a, -b);
    }
    private static int multiply(long a, long b) {
        return (int) ((a%MOD*b%MOD)%MOD);
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
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long x = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        if(x == 0) {
            out.println(0);
        } else {
            out.println(add(subtract(multiply(power(2, k+1), x), power(2, k)), 1));
        }
        f.close();
        out.close();
    }
}