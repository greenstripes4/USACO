import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            int N = f.nextInt();
            BigInteger A = f.nextBigInteger();
            BigInteger sum = BigInteger.ZERO;
            for (int i = 1; i <= N; i++) {
                sum = sum.add(A.pow(i).multiply(BigInteger.valueOf(i)));
            }
            out.println(sum.toString());
        }
        f.close();
        out.close();
    }
}
