import java.io.*;
import java.math.BigDecimal;
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
            BigInteger a = f.nextBigInteger();
            char operation = f.next().charAt(0);
            BigInteger b = f.nextBigInteger();
            if(operation == '/') {
                out.println(a.divide(b));
            } else {
                out.println(a.mod(b));
            }
        }
        f.close();
        out.close();
    }
}
