import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int a = Integer.parseInt(f.readLine());
        while(a >= 10) {
            int b = 0;
            while(a > 0) {
                b += a%10;
                a /= 10;
            }
            a = b;
        }
        out.println(a);
        f.close();
        out.close();
    }
}