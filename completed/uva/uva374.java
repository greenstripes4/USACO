import java.io.*;
import java.util.*;

public class Main {
    private static int MOD;
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
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            int B = Integer.parseInt(input);
            int P = Integer.parseInt(f.readLine());
            MOD = Integer.parseInt(f.readLine());
            out.println(power(B, P));
            f.readLine();
        }
        f.close();
        out.close();
    }
}