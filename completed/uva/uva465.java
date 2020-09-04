import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            BigInteger a = new BigInteger(st.nextToken());
            char operator = st.nextToken().charAt(0);
            BigInteger b = new BigInteger(st.nextToken());
            out.println(input);
            BigInteger MAX_VALUE = new BigInteger("2147483647");
            if(a.compareTo(MAX_VALUE) > 0) {
                out.println("first number too big");
            }
            if(b.compareTo(MAX_VALUE) > 0) {
                out.println("second number too big");
            }
            BigInteger result = operator == '+' ? a.add(b) : a.multiply(b);
            if(result.compareTo(MAX_VALUE) > 0) {
                out.println("result too big");
            }
        }
        f.close();
        out.close();
    }
}
