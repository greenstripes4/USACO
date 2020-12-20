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
        StringTokenizer st = new StringTokenizer(f.readLine());
        long r = Long.parseLong(st.nextToken());
        long g = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        out.println(Math.min(Math.min((r+g+b)/3, r+g), Math.min(r+b, g+b)));
        f.close();
        out.close();
    }
}
