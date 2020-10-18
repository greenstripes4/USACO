import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = 1;
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            BigInteger total = BigInteger.ZERO;
            for(int i = 0; i < N; i++) {
                total = total.add(new BigInteger(f.readLine()));
            }
            out.println("Bill #" + testcases + " costs " + total + ": each friend should pay " + total.divide(BigInteger.valueOf(F)));
            out.println();
            testcases++;
        }
        f.close();
        out.close();
    }
}
