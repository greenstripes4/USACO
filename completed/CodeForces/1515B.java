import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            double n = Integer.parseInt(f.readLine());
            double a = Math.sqrt(n/2);
            double b = Math.sqrt(n/4);
            if(a == (int) a || b == (int) b) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        f.close();
        out.close();
    }
}