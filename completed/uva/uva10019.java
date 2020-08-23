import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++) {
            int M = Integer.parseInt(f.readLine());
            int b1 = Integer.bitCount(M);
            int hexadecimalM = Integer.parseInt(Integer.toString(M),16);
            int b2 = Integer.bitCount(hexadecimalM);
            out.println(b1 + " " + b2);
        }
        f.close();
        out.close();
    }
}
