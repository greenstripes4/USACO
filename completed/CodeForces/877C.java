import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int even = n/2;
        int odd = n-even;
        out.println(2*even+odd);
        out.print(2);
        for(int i = 4; i <= n; i += 2) {
            out.print(" " + i);
        }
        for(int i = 1; i <= n; i += 2) {
            out.print(" " + i);
        }
        for(int i = 2; i <= n; i += 2) {
            out.print(" " + i);
        }
        out.println();
        f.close();
        out.close();
    }
}