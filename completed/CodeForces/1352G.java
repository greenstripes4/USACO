import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            if(n < 4) {
                out.println(-1);
                continue;
            }
            int odd = n%2 == 0 ? n-1 : n;
            out.print(odd);
            for(int i = odd-2; i > 0; i -= 2) {
                out.print(" " + i);
            }
            out.print(" 4 2");
            for(int i = 6; i <= n; i += 2) {
                out.print(" " + i);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}