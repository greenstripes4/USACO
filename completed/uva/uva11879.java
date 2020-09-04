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
        BigInteger seventeen = new BigInteger("17");
        BigInteger zero = new BigInteger("0");
        String input;
        while(!(input = f.readLine()).equals("0")) {
            out.println(new BigInteger(input).mod(seventeen).equals(zero) ? 1 : 0);
        }
        f.close();
        out.close();
    }
}
