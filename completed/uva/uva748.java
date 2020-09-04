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
            BigDecimal R = f.nextBigDecimal();
            int n = f.nextInt();
            String res = R.pow(n).stripTrailingZeros().toPlainString();
            out.println(res.charAt(0) == '0' ? res.substring(1) : res);
        }
        f.close();
        out.close();
    }
}
