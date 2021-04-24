import java.io.*;
import java.util.*;

public class Main {
    private static int MOD;
    private static int add(long a, long b) {
        return (int) ((a%MOD+b%MOD)%MOD);
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
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int Z = f.nextInt();
        while(Z-- > 0) {
            MOD = f.nextInt();
            int H = f.nextInt();
            int sum = 0;
            for(int i = 0; i < H; i++) {
                sum = add(sum, power(f.nextInt(), f.nextInt()));
            }
            out.println(sum);
        }
        f.close();
        out.close();
    }
}