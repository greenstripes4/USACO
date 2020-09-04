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
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            BigInteger a = new BigInteger(new StringBuilder(st.nextToken()).reverse().toString());
            BigInteger b = new BigInteger(new StringBuilder(st.nextToken()).reverse().toString());
            BigInteger c = new BigInteger(new StringBuilder(a.add(b).toString()).reverse().toString());
            out.println(c);
        }
        f.close();
        out.close();
    }
}
